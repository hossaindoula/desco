package com.ibcs.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * For password validation
 * Created by hossaindoula on 4/27/2016.
 */
public class PasswordValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9!@#$%^&*()_]{6,20}$";

    public PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
}
