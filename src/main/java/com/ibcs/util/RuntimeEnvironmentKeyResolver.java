package com.ibcs.util;

/**
 * Created by Dell on 6/16/2016.
 */
public interface RuntimeEnvironmentKeyResolver {
    /**
     * Determine and return the runtime environment; if an implementation is
     * unable to determine the runtime environment, null can be returned to
     * indicate this.
     */
    String resolveRuntimeEnvironmentKey();
}
