package com.ibcs.configuration;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.cfg.DefaultNamingStrategy;
import org.hibernate.cfg.EJB3NamingStrategy;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.metamodel.relational.Identifier;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/7/2016.
 */
public class EntityNamingStrategy extends ImprovedNamingStrategy {

    private static final String PLURAL_SUFFIX = "s";

    /**
     * Transforms class names to table names by using the described naming conventions.
     * @param className
     * @return  The constructed table name.
     */
    @Override
    public String classToTableName(String className) {
        String tableNameInSingularForm = super.classToTableName(className);
        return transformToPluralForm(tableNameInSingularForm);
    }

    private String transformToPluralForm(String tableNameInSingularForm) {
        StringBuilder pluralForm = new StringBuilder();

        pluralForm.append(tableNameInSingularForm);
        pluralForm.append(PLURAL_SUFFIX);

        return pluralForm.toString();
    }
}