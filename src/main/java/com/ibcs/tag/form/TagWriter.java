package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import java.io.IOException;
import java.io.Writer;
import java.util.Stack;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class TagWriter {
    private final SafeWriter writer;
    private final Stack<TagStateEntry> tagState = new Stack();

    public TagWriter(PageContext pageContext) {
        Assert.notNull(pageContext, "PageContext must not be null");
        this.writer = new SafeWriter(pageContext);
    }

    public TagWriter(Writer writer) {
        Assert.notNull(writer, "Writer must not be null");
        this.writer = new SafeWriter(writer);
    }

    public void startTag(String tagName) throws JspException {
        if(this.inTag()) {
            this.closeTagAndMarkAsBlock();
        }

        this.push(tagName);
        this.writer.append("<").append(tagName);
    }

    public void writeAttribute(String attributeName, String attributeValue) throws JspException {
        if(this.currentState().isBlockTag()) {
            throw new IllegalStateException("Cannot write attributes after opening tag is closed.");
        } else {
            this.writer.append(" ").append(attributeName).append("=\"").append(attributeValue).append("\"");
        }
    }

    public void writeOptionalAttributeValue(String attributeName, String attributeValue) throws JspException {
        if(StringUtils.hasText(attributeValue)) {
            this.writeAttribute(attributeName, attributeValue);
        }

    }

    public void appendValue(String value) throws JspException {
        if(!this.inTag()) {
            throw new IllegalStateException("Cannot write tag value. No open tag available.");
        } else {
            this.closeTagAndMarkAsBlock();
            this.writer.append(value);
        }
    }

    public void forceBlock() throws JspException {
        if(!this.currentState().isBlockTag()) {
            this.closeTagAndMarkAsBlock();
        }
    }

    public void endTag() throws JspException {
        this.endTag(false);
    }

    public void endTag(boolean enforceClosingTag) throws JspException {
        if(!this.inTag()) {
            throw new IllegalStateException("Cannot write end of tag. No open tag available.");
        } else {
            boolean renderClosingTag = true;
            if(!this.currentState().isBlockTag()) {
                if(enforceClosingTag) {
                    this.writer.append(">");
                } else {
                    this.writer.append("/>");
                    renderClosingTag = false;
                }
            }

            if(renderClosingTag) {
                this.writer.append("</").append(this.currentState().getTagName()).append(">");
            }

            this.tagState.pop();
        }
    }

    private void push(String tagName) {
        this.tagState.push(new TagStateEntry(tagName));
    }

    private void closeTagAndMarkAsBlock() throws JspException {
        if(!this.currentState().isBlockTag()) {
            this.currentState().markAsBlockTag();
            this.writer.append(">");
        }

    }

    private boolean inTag() {
        return this.tagState.size() > 0;
    }

    private TagStateEntry currentState() {
        return (TagStateEntry)this.tagState.peek();
    }

    private static final class SafeWriter {
        private PageContext pageContext;
        private Writer writer;

        public SafeWriter(PageContext pageContext) {
            this.pageContext = pageContext;
        }

        public SafeWriter(Writer writer) {
            this.writer = writer;
        }

        public SafeWriter append(String value) throws JspException {
            try {
                this.getWriterToUse().write(String.valueOf(value));
                return this;
            } catch (IOException var3) {
                throw new JspException("Unable to write to JspWriter", var3);
            }
        }

        private Writer getWriterToUse() {
            return (Writer)(this.pageContext != null?this.pageContext.getOut():this.writer);
        }
    }

    private static class TagStateEntry {
        private final String tagName;
        private boolean blockTag;

        public TagStateEntry(String tagName) {
            this.tagName = tagName;
        }

        public String getTagName() {
            return this.tagName;
        }

        public void markAsBlockTag() {
            this.blockTag = true;
        }

        public boolean isBlockTag() {
            return this.blockTag;
        }
    }
}

