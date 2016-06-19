<#import "admin_layout.ftl" as layout>
<#macro home_layout title="">
    <#import "/layout/admin_layout.ftl" as layout>
    <#assign ibcs=JspTaglibs["http://www.ibcs-primax.com/iForm"] />
    <@layout.admin_layout "${PageTitle}" >
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
                            <div class="widget">
                                <style>
                                    .content{height: 125px;}
                                    .widgetlist { list-style: none; }
                                    .widgetlist li { display: inline-block; float: left; width: 130px; margin: 0 10px 10px 0; }
                                    .widgetlist li a { display: block; padding: 15px; border: 1px solid #ccc; color: #333; text-align: center; background: #f7f7f7; }
                                    .widgetlist li a { -moz-border-radius: 3px; -webkit-border-radius: 3px; border-radius: 3px; -moz-box-shadow: 1px 1px 0 #fff; color: #069; }
                                    .widgetlist li a span { font-size: 12px; display: block; margin-top: 10px; }
                                    .widgetlist li a:hover { -moz-box-shadow: 0 0 4px #ddd; background: #fcfcfc; text-decoration: none; }
                                </style>
                                <div class="header" style="width: 849px;">
                                </div>
                                <div id="list_user" class="content scaffold-list" role="main" style="width: 800px;">
                                    <ul class="widgetlist">
                                        <#nested>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end: TEXT FIELDS PANEL -->
                </div>
            </div>
            <!-- end: PAGE CONTENT-->
        </div>
    </div>
    </@layout.admin_layout>
</#macro>