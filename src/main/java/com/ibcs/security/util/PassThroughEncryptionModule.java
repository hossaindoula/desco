/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2013 Broadleaf Commerce
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.ibcs.security.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The default encryption module simply passes through the decrypt and encrypt text.
 * A real implementation should adhere to PCI compliance, which requires robust key
 * management, including regular key rotation. An excellent solution would be a module
 * for interacting with the StrongKey solution. Refer to this discussion:
 *
 *
 * @author hossaindoula
 *
 */
public class PassThroughEncryptionModule {

    private static final Log LOG = LogFactory.getLog(PassThroughEncryptionModule.class);

    protected SystemPropertyRuntimeEnvironmentKeyResolver keyResolver = new SystemPropertyRuntimeEnvironmentKeyResolver();

    public PassThroughEncryptionModule() {
        if ("production".equals(keyResolver.resolveRuntimeEnvironmentKey())) {
            LOG.warn("This passthrough encryption module provides NO ENCRYPTION and should NOT be used in production.");
        }
    }

    public String decrypt(String cipherText) {
        return cipherText;
    }

    public String encrypt(String plainText) {
        return plainText;
    }

}
