<#-- @ftlvariable name="cssResources" type="java.util.Map<java.lang.String, java.util.List<java.lang.String>>" -->
<#-- @ftlvariable name="jsResources" type="java.util.Map<java.lang.String, java.util.List<java.lang.String>>" -->
<#-- @ftlvariable name="isAjax" type="java.lang.Boolean" -->

<#include "/testing/settings.ftl" />
<#import "/spring.ftl" as spring/>
<#import "/testing/message.ftl" as messages />

<@layout.admin_layout "${PageTitle}" >
    <#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<#--<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />-->
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
                        <form action="save" method="POST">
                            <@messages.print_binding_errors "modelForm"/>
                            <div>
                                <p>
                                    <label for="name">Name:</label>
                                        <@spring.formInput path="modelForm.username"
                                            attributes='required="required" pattern=".{3,50}" maxlength="50" class="show_validation" autocorrect="off" autocapitalize="off" autocomplete="off"' />
                                    <span class="error_message"></span>
                                </p>

                                <p>
                                    <label for="name">Password:</label>
                                        <@spring.formInput path="modelForm.password"
                                            attributes='required="required" pattern=".{3,50}" maxlength="50" class="show_validation" autocorrect="off" autocapitalize="off" autocomplete="off"' />
                                    <span class="error_message"></span>
                                </p>

                                <p>
                                    <label for="name">Confirm Password:</label>
                                        <@spring.formInput path="modelForm.confirmPassword"
                                            attributes='required="required" pattern=".{3,50}" maxlength="50" class="show_validation" autocorrect="off" autocapitalize="off" autocomplete="off"' />
                                    <span class="error_message"></span>
                                </p>

                                <p>
                                    <label for="email">Email:</label>
                                        <@spring.formInput path="modelForm.email"
                                            fieldType="email"
                                            attributes='required="required" pattern="${emailPattern}"
                                                class="show_validation" autocorrect="off" autocapitalize="off" autocomplete="off"' />
                                    <span class="error_message"></span>
                                </p>

                                <div style="width:100%; height: 1em;"></div>

                                <p>
                                    <input type="submit" formnovalidate name="submit" value="Register">
                                </p>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- end: TEXT FIELDS PANEL -->
            </div>
        </div>
        <!-- end: PAGE CONTENT-->
    </div>
</div>
</@layout.admin_layout>
