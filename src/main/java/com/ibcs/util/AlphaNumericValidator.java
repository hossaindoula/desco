package com.ibcs.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hossaindoula on 4/27/2016.
 */

@Component
public class AlphaNumericValidator {
    private Pattern pattern;
    private Matcher matcher;


    private static final String ALPHA_NUMERIC_PATTERN = "[A-Za-z0-9]{3,}";

    public AlphaNumericValidator() {
        pattern = Pattern.compile(ALPHA_NUMERIC_PATTERN);
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
