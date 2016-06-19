package com.ibcs.finance.model;

import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType= DiscriminatorType.STRING
)
@DiscriminatorValue("cash_flow")
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_cash_flow")
public class CashFlow extends FinancialStatement {
}
