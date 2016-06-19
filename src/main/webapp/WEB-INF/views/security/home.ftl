<#import "/layout/home_layout.ftl" as layout>
<@layout.home_layout "${PageTitle}" >
    <li>
        <a href="/user/">
            <img src="/assets/images/user_icon.png" alt="User List">
            <span>User</span>
        </a>
    </li>
    <li>
        <a href="/authority/">
            <img src="/assets/images/authority_icon.png" alt="Authority List">
            <span>Authority</span>
        </a>
    </li>
    <li>
        <a href="/authorizedGroups/">
            <img src="/assets/images/user_group_icon.png" alt="Authorized Group List">
            <span>Authorized Groups</span>
        </a>
    </li>
    <li>
        <a href="/features/">
            <img src="/assets/images/feature_icon.png" alt="Feature List">
            <span>Feature</span>
        </a>
    </li>
    <li>
        <a href="/component/">
            <img src="/assets/images/feature_icon.png" alt="Components List">
            <span>Component</span>
        </a>
    </li>
</@layout.home_layout>