package com.ibcs.base.cloner;

/**
 * This class is used to display customized exception in the POJO.
 * 		Example of using this class:
 * 		<code>
 * 			// <b>This function receives as input a bean attached to Hibernate session</b>
 * 			// <b>The below line specifies the attributes to be copied when the bean is attached to the collections and hibernate beans</b>
 * 			// <b>this avoids loading all the elements of the bean in memory and in its copy.</b>
 * 			String[] levelsToCopy = new String[] {"language", "chapters/book", "authors"};<br/>
 *			// This bean is attached to Hibernate Session<br/>
 * 			Book hibernateAttachedBean = new Book();<br/>
 * 			[...]<br/>
 * 			Book hibernateDetachedBean = (new CloneException()).clone(hibernateAttachedBean, levelsToCopy);<br/>
 * 		</code>
 * </p>
 *
 * @author Mohammed Hossain Doula
 */
public class CloneException extends RuntimeException {

    public CloneException() {
    }

    public CloneException(String message) {
        super(message);
    }

    public CloneException(Throwable cause) {
        super(cause);
    }

    public CloneException(String message, Throwable cause) {
        super(message, cause);
    }

}

