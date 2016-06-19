<#import "/layout/admin_create_layout.ftl" as layout>
<#assign ibcs=JspTaglibs["http://www.ibcs-primax.com/iForm"] />
<@layout.admin_create_layout "${PageTitle}" >
    <ibcs:form name="authorityForm" id="authorityForm" controller="security" action="saveAuthority" method="POST">
        <g:render template="authority_form"/>
        <div class="panel-body">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </ibcs:form>
</@layout.admin_create_layout>

