package com.ibcs.finance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hossain.doula on 5/3/2016.
 */

@Entity
@Table(name="cash_in_flow")
@DiscriminatorValue("in_flow")
public class InFlow extends CashFlow {
}
