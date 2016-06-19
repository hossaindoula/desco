<#macro admin_layout title="">
	<#assign ibcs=JspTaglibs["http://www.ibcs-primax.com/iForm"] />
	<!-- Header content -->
	<#include "meta.ftl"/>
	<!-- Header content -->

	<body class="layout-container ls-top-navbar si-l3-md-up">
		<div class="main-container">
			<!-- Nav Bar -->
			<#include "nav_top.ftl">
			<#include "nav_panel.ftl">
			<!-- Nav Bar -->
			<!--Body content-->
			<#include "scripts_layout.ftl"/>
			<#nested>
			<!--Body content-->
		</div>
		<!-- Footer content -->
			<#include "footer.ftl"/>
		<!-- Footer content -->
	</body>
</#macro>