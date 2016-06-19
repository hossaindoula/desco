package com.ibcs.finance.service;

import com.ibcs.finance.dao.CostAllocationDao;
import com.ibcs.finance.model.CostAllocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Service("budgetService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private CostAllocationDao costAllocationDao;

    public boolean save(CostAllocation costAllocation) {
        return costAllocationDao.create(costAllocation);
    }

    public List<CostAllocation> findAllCostAllocations() {
        return costAllocationDao.findAll();
    }

    public boolean delete(CostAllocation costAllocation) {
        return costAllocationDao.delete(costAllocation);
    }
}
