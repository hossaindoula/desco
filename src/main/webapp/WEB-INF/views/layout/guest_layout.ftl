<#macro gen_app_layout title="">
	
			<!-- Header content -->
				<#include "header.ftl"/>
			<!-- Header content -->
			
			<!--Body content-->
                <#nested>
			<!--Body content-->
			
			<!-- Footer content -->
				<#include "ffooter.ftl"/>
			<!-- Footer content -->
			
			
		</body>
	</html>
</#macro>