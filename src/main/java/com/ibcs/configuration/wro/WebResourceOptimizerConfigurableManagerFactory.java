package com.ibcs.configuration.wro;

import com.google.javascript.jscomp.CompilationLevel;
import ro.isdc.wro.extensions.processor.css.YUICssCompressorProcessor;
import ro.isdc.wro.extensions.processor.js.GoogleClosureCompressorProcessor;
import ro.isdc.wro.manager.factory.ConfigurableWroManagerFactory;
import ro.isdc.wro.model.factory.WroModelFactory;
import ro.isdc.wro.model.factory.XmlModelFactory;
import ro.isdc.wro.model.resource.processor.factory.ProcessorsFactory;
import ro.isdc.wro.model.resource.processor.factory.SimpleProcessorsFactory;
import ro.isdc.wro.model.resource.processor.impl.css.CssUrlRewritingProcessor;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by hossain.doula on 5/26/2016.
 */

public class WebResourceOptimizerConfigurableManagerFactory extends
        ConfigurableWroManagerFactory {


    public ConfigurableWroManagerFactory setConfigProperties(final Properties props){
        return new ConfigurableWroManagerFactory() {
            protected Properties newProperties() {
                return props;
            }
        };
    }

    @Override
    protected ProcessorsFactory newProcessorsFactory() {
        final SimpleProcessorsFactory rv = new SimpleProcessorsFactory();
        // URLs in CSS needs to be rewritten as it is served from a different location than the original files. I'm not using @import statements, otherwise the appropriate processor should be added for rewriting them as well
        rv.addPreProcessor(new CssUrlRewritingProcessor());
        // JavaScript compression by the Google Closure compressor
        rv.addPreProcessor(new GoogleClosureCompressorProcessor(CompilationLevel.SIMPLE_OPTIMIZATIONS));
        // And css by YUI Css Compressor
        rv.addPreProcessor(new YUICssCompressorProcessor());
        return rv;
    }

    @Override
    protected WroModelFactory newModelFactory() {
        return new XmlModelFactory() {
            @Override
            protected InputStream getModelResourceAsStream() {
                return this.getClass().getResourceAsStream("/resources/wro.xml");
            }
        };
    }

}
