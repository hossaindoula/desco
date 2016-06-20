<#import "/layout/admin_layout.ftl" as layout>
<#import "/testing/message.ftl" as messages />
<@layout.admin_layout "${PageTitle}" >
    <#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
    <#macro formErrors>
        <#assign formErrors><@form.errors path="*" /></#assign>
        <#if formErrors?has_content>
        <div id="errors">
            <@spring.message "admin.error.globalMessage" />
        </div>
        </#if>
    </#macro>
<!-- start: PAGE -->
<div class="main-content">
    <!-- start: PANEL CONFIGURATION MODAL FORM -->
    <div class="modal fade" id="panel-config" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title">Panel Configuration</h4>
                </div>
                <div class="modal-body">
                    Here will be a configuration form
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        Close
                    </button>
                    <button type="button" class="btn btn-primary">
                        Save changes
                    </button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    <!-- end: SPANEL CONFIGURATION MODAL FORM -->
    <div class="container">
        <!-- start: PAGE HEADER -->
        <div class="row">
            <div class="col-sm-12">
                <!-- start: PAGE TITLE & BREADCRUMB -->
                <ol class="breadcrumb">
                    <li>
                        <i class="clip-pencil"></i>
                        <a href="#">
                            Forms
                        </a>
                    </li>
                    <li class="active">
                        Form Elements
                    </li>
                    <li class="search-box">
                        <form class="sidebar-search">
                            <div class="form-group">
                                <input type="text" placeholder="Start Searching...">
                                <button class="submit">
                                    <i class="clip-search-3"></i>
                                </button>
                            </div>
                        </form>
                    </li>
                </ol>
                <div class="page-header">
                    <small>${PageTitle}</small>
                </div>
                <!-- end: PAGE TITLE & BREADCRUMB -->
            </div>
        </div>
        <!-- end: PAGE HEADER -->
        <!-- start: PAGE CONTENT -->
        <div class="row">
            <div class="col-sm-12">
                <!-- start: TEXT FIELDS PANEL -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-external-link-square"></i> ${PageTitle}
                        <div class="panel-tools">
                            <a class="btn btn-xs btn-link panel-collapse collapses" href="#">
                            </a>
                            <a class="btn btn-xs btn-link panel-config" href="#panel-config" data-toggle="modal">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <a class="btn btn-xs btn-link panel-refresh" href="#">
                                <i class="fa fa-refresh"></i>
                            </a>
                            <a class="btn btn-xs btn-link panel-expand" href="#">
                                <i class="fa fa-resize-full"></i>
                            </a>
                            <a class="btn btn-xs btn-link panel-close" href="#">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="panel-body">
                        <@form.form cssClass="form-horizontal" method="POST" modelAttribute="modelForm" action="save" >
                            <@spring.bind path="modelForm" />
                            <@form.hidden path="modelForm.id" />
                            <@messages.print_binding_errors "modelForm"/>
                            <#if forms??>
                                <#list forms as formElement>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="form-field-1">
                                            ${formElement.label}
                                        </label>
                                        <div class="col-sm-9">
                                            <#if formElement.type == "text" || formElement.type == "password" || formElement.type == "email"
                                            || formElement.type == "number">
                                                <input type="${formElement.type}" placeholder="${formElement.placeholder!}"
                                                       id="${formElement.id}" name="${formElement.id}" class="form-control"
                                                       required="${formElement.required?string}" >

                                            </#if>
                                            <#if formElement.type == "textarea">
                                                <@form.textarea placeholder="${formElement.placeholder!}"
                                                id="${formElement.id}"
                                                path="${formElement.id}"
                                                cssClass="form-control" required="${formElement.required?string}"></@form.textarea>
                                            </#if>
                                            <#if formElement.type == "select">
                                                <@form.select id="form-field-select-3" class="form-control search-select"
                                                path="${formElement.id}">
                                                    <option value="">Please select</option>
                                                    <#list formElement.id as selectVal>
                                                        <option value="${selectVal_index}">${selectVal.value}</option>
                                                    </#list>
                                                </@form.select>
                                            </#if>
                                            <#if formElement.type == "multiSelect">
                                                <@form.select id="form-field-select-3" cssClass="form-control search-select"
                                                multiple="multiple"
                                                path="${formElement.id}">
                                                    <option value="">Please select</option>
                                                    <#list formElement.id as selectVal>
                                                        <option value="${selectVal_index}">${selectVal.value}</option>
                                                    </#list>
                                                </@form.select>
                                            </#if>
                                            <#if formElement.type == "fileUpload">
                                                <input type="file" name="${formElement.id}" id="file" />
                                                <#--<@form.input id="input-simple"
                                                path="${formElement.id}" type="file"
                                                cssClass="file" />-->
                                            </#if>
                                            <#if formElement.type == "thumbFileUpload">
                                                <@form.input id="simple" path="${formElement.id}" type="file" cssClass="file"
                                                />
                                            </#if>
                                            <#if formElement.type == "avatarFileUpload">
                                                <div id="kv-avatar-errors" class="center-block" style="display:none"></div>
                                                <div class="kv-avatar">
                                                    <@form.input id="avatar" path="avatar" type="file" cssClass="file-loading"/>
                                                </div>
                                            </#if>
                                            <#if formElement.type == "ckEditor">
                                                <@form.textarea cssClass="ckeditor form-control" cols="10" rows="10" path="${formElement.id}"></@form.textarea>
                                            </#if>
                                            <#if formElement.type == "toggle">
                                                <div class="panel-body buttons-widget">
                                                    <div class="make-switch" data-on="primary" data-off="info">
                                                        <@form.input type="checkbox" checked="true" path="${formElement.id}"/>
                                                    </div>
                                                </div>
                                            </#if>
                                            <form:errors path="${formElement.id}" class="control-label" />
                                        </div>
                                    </div>
                                </#list>
                                <#if formsMasterDetails??>
                                    <table class="table table-hover" id="sample-table-1">
                                        <thead>
                                        <tr>
                                            <th class="center">#</th>
                                            <#list detail as formMetaElement>
                                                <th>${formMetaElement.label}</th>
                                            </#list>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td class="center">1</td>
                                                <#list formsMasterDetails as formElement>
                                                    <td class="hidden-xs">
                                                        <div class="form-group">
                                                            <label class="col-sm-2 control-label" for="form-field-1">
                                                            ${formElement.label}
                                                            </label>
                                                            <div class="col-sm-9">
                                                                <#if formElement.type == "text" || formElement.type == "password" || formElement.type == "email"
                                                                || formElement.type == "number">
                                                                    <input type="${formElement.type}" placeholder="${formElement.placeholder!}"
                                                                           id="${formElement.id}" name="${formElement.id}" class="form-control"
                                                                           required="${formElement.required?string}" >

                                                                </#if>
                                                                <#if formElement.type == "textarea">
                                                                    <@form.textarea placeholder="${formElement.placeholder!}"
                                                                    id="${formElement.id}"
                                                                    path="${formElement.id}"
                                                                    cssClass="form-control" required="${formElement.required?string}"></@form.textarea>
                                                                </#if>
                                                                <#if formElement.type == "select">
                                                                    <@form.select id="form-field-select-3" class="form-control search-select"
                                                                    path="${formElement.id}">
                                                                        <option value="">Please select</option>
                                                                        <#list formElement.id as selectVal>
                                                                            <option value="${selectVal_index}">${selectVal.value}</option>
                                                                        </#list>
                                                                    </@form.select>
                                                                </#if>
                                                                <#if formElement.type == "multiSelect">
                                                                    <@form.select id="form-field-select-3" cssClass="form-control search-select"
                                                                    multiple="multiple"
                                                                    path="${formElement.id}">
                                                                        <option value="">Please select</option>
                                                                        <#list formElement.id as selectVal>
                                                                            <option value="${selectVal_index}">${selectVal.value}</option>
                                                                        </#list>
                                                                    </@form.select>
                                                                </#if>
                                                                <#if formElement.type == "fileUpload">
                                                                    <input type="file" name="${formElement.id}" id="file" />
                                                                <#--<@form.input id="input-simple"
                                                                path="${formElement.id}" type="file"
                                                                cssClass="file" />-->
                                                                </#if>
                                                                <#if formElement.type == "thumbFileUpload">
                                                                    <@form.input id="simple" path="${formElement.id}" type="file" cssClass="file"/>
                                                                </#if>
                                                                <#if formElement.type == "avatarFileUpload">
                                                                    <div id="kv-avatar-errors" class="center-block" style="display:none"></div>
                                                                    <div class="kv-avatar">
                                                                        <@form.input id="avatar" path="avatar" type="file" cssClass="file-loading"/>
                                                                    </div>
                                                                </#if>
                                                                <#if formElement.type == "ckEditor">
                                                                    <@form.textarea cssClass="ckeditor form-control" cols="10" rows="10" path="${formElement.id}"></@form.textarea>
                                                                </#if>
                                                                <#if formElement.type == "toggle">
                                                                    <div class="panel-body buttons-widget">
                                                                        <div class="make-switch" data-on="primary" data-off="info">
                                                                            <@form.input type="checkbox" checked="true" path="${formElement.id}"/>
                                                                        </div>
                                                                    </div>
                                                                </#if>
                                                                <form:errors path="${formElement.id}" class="control-label" />
                                                            </div>
                                                        </div>
                                                    </td>
                                                </#list>
                                            <#--<td class="hidden-xs">Google Chrome</td>
                                            <td>Google</td>
                                            <td>
                                                <a href="#" rel="nofollow" target="_blank">
                                                    Terms of Service
                                                </a>
                                            </td>
                                            <td class="hidden-xs">Blink</td>-->
                                                <td class="center">
                                                    <div class="visible-md visible-lg hidden-sm hidden-xs">
                                                        <a href="#" class="btn btn-xs btn-green tooltips" data-placement="top" data-original-title="Add"><i class="fa fa-plus"></i></a>
                                                        <a href="#" class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove"><i class="fa fa-times fa fa-white"></i></a>
                                                    </div>
                                                    <div class="visible-xs visible-sm hidden-md hidden-lg">
                                                        <div class="btn-group">
                                                            <a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
                                                                <i class="fa fa-cog"></i> <span class="caret"></span>
                                                            </a>
                                                            <ul role="menu" class="dropdown-menu pull-right">
                                                                <li role="presentation">
                                                                    <a role="menuitem" tabindex="-1" href="#">
                                                                        <i class="fa fa-plus"></i> Add
                                                                    </a>
                                                                </li>
                                                                <li role="presentation">
                                                                    <a role="menuitem" tabindex="-1" href="#">
                                                                        <i class="fa fa-times"></i> Remove
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </#if>
                                <#if authHierarchyBtns??>
                                    <div class="btn-group">
                                        <button formnovalidate type="button" class="btn btn-purple">
                                            Submit
                                        </button>
                                        <button formnovalidate type="button" class="btn btn-green dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu">
                                            <#if authBtns??>
                                                <#list authBtns as authBtn>
                                                    <li>
                                                        <a href="${authBtn.sendToUrl}">
                                                            ${authBtn.sendToTxt}
                                                        </a>
                                                    </li>
                                                    <#if dividers??>
                                                        <li class="divider"></li>
                                                    </#if>
                                                </#list>
                                            </#if>
                                        </ul>
                                    </div>
                                <#elseif customBtn??>
                                    ${customBtnHtml}
                                <#else>
                                    <#if submitValue??>
                                        <input type="submit" formnovalidate name="submit" value="${submitValue}" class="btn btn-${color}" style="margin-left: 181px;"/>
                                    <#else>
                                        <input type="submit" formnovalidate name="submit" value="Submit" class="btn btn-blue" style="margin-left: 181px;"/>
                                        <input type="reset" formnovalidate name="reset" value="Clear" class="btn btn-default" style="margin-left: 10px;"/>
                                    </#if>
                                </#if>
                            </#if>
                        </@form.form>
                    </div>
                </div>
                <!-- end: TEXT FIELDS PANEL -->
            </div>
        </div>
        <!-- end: PAGE CONTENT-->
    </div>
</div>
</@layout.admin_layout>