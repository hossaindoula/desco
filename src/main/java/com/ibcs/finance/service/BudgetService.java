package com.ibcs.finance.service;

import com.ibcs.finance.model.CostAllocation;

import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */
public interface BudgetService {

    boolean save(CostAllocation costAllocation);

    List<CostAllocation> findAllCostAllocations();

    boolean delete(CostAllocation costAllocation);


}
