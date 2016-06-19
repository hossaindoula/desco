package com.ibcs.finance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@DiscriminatorValue("income_statement")
public class IncomeStatement extends FinancialStatement {
}
