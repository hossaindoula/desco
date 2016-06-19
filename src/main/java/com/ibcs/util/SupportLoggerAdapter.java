package com.ibcs.util;


/**
 * @author hossaindoula
 */
public interface SupportLoggerAdapter {

    public String getName();

    public void setName(String name);

    /**
     * emit a SUPPORT level message
     * @param message
     */
    void support(String message);

    /**
     * emit a SUPPORT level message with throwable
     * @param message
     * @param t
     */
    void support(String message, Throwable t);

    /**
     * emit a SUPPORT lifecycle message
     * @param lifeCycleEvent
     * @param message
     */
    void lifecycle(LifeCycleEvent lifeCycleEvent, String message);

    /**
     * In order to be backwards compatible. The support logger should also support
     * the debug, error, fatal, info, and warn levels as well.
     * @param message
     */

    void debug(String message);

    void debug(String message, Throwable t);

    void error(String message);

    void error(String message, Throwable t);

    void fatal(String message);

    void fatal(String message, Throwable t);

    void info(String message);

    void info(String message, Throwable t);

    void warn(String message);

    void warn(String message, Throwable t);

}