package com.ibcs.base.model;

import java.util.UUID;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */
public class IdGenerator {

    public static String createId() {
        UUID uuid = java.util.UUID.randomUUID();
        return uuid.toString();
    }

}
