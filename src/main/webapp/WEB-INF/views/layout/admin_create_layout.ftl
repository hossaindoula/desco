<#macro admin_create_layout title="">
	<#import "admin_layout.ftl" as layout>
	<@layout.admin_layout "${PageTitle}" >
		<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
		<#assign spring=JspTaglibs["http://www.springframework.org/tags"] />
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-reorder"></i>
					${PageTitle}
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
					<div class="row">
						<div class="col-md-12">
							<#if x == 1>
								<div class="alert alert-success" role="alert">
									<g:img dir="images" file="success.png" />
									<strong>Well done!</strong> ${entityName} successfully saved.
								</div>
							<#else>
								<div class="alert alert-danger" role="alert">
										<g:img dir="images" file="failed.png" />
										<strong>Failed!</strong> ${entityName} save failed ${cause}!!!
									</div>
							</#if>                            
						</div>
					</div>
				</div>
				<div class="panel-body">
					<#nested>
				</div>
			</div>
		</div>
	</@layout.admin_layout>
</#macro>


