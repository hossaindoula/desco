<#import "/layout/home_layout.ftl" as layout>
<@layout.home_layout "${PageTitle!}" >
    <li>
        <a href="/costAllocation">
            <img src="/assets/images/cost_allocation.png" alt="Cost Allocation">
            <span>Cost Allocation</span>
        </a>
    </li>
    <li>
        <a href="/costCenter">
            <img src="/assets/images/cost_center.png" alt="Cost Center">
            <span>Cost Center</span>
        </a>
    </li>
    <li>
        <a href="/costAllocationDetails">
            <img src="/assets/images/cost_allocation_details.png" alt="Cost Allocation Details">
            <span>Cost Allocation Details</span>
        </a>
    </li>
</@layout.home_layout>