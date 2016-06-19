package com.ibcs.configuration;

import com.ibcs.AppConstants;
import com.ibcs.base.component.AppComponent;
import com.ibcs.base.dao.finder.impl.FinderIntroductionInterceptor;
import com.ibcs.bundling.AddBundlingModelToViewModelInterceptor;
import com.ibcs.bundling.WroModelHolder;
import com.ibcs.configuration.wro.WebResourceOptimizerConfigurableManagerFactory;
import com.ibcs.util.SpringContext;
import com.ibcs.util.UUIDFactory;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.cache.WebappTemplateLoader;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import freemarker.template.utility.XmlEscape;
import ro.isdc.wro.manager.factory.ConfigurableWroManagerFactory;
import ro.isdc.wro.manager.factory.WroManagerFactory;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * This is a Spring based configuration for enabling Spring MVC
 * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula@ibcs-primax.com
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = AppConstants.BASE_NAME_SPACE)
@Import(value = {EmailConfiguration.class, AopConfig.class})
@PropertySource({"classpath:web.properties", "classpath:validation.properties"})
public class AppConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Resource
	private WroModelHolder wroModelHolder;

	@Bean
	public FinderIntroductionInterceptor finderIntroductionInterceptor() {
		return new FinderIntroductionInterceptor();
	}

	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver resolver() {
		return new StandardServletMultipartResolver();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*registry.addInterceptor(new
				AddBundlingModelToViewModelInterceptor(
				wroModelHolder, environment.getProperty("bundling.enabled")));*/
		/*registry.addInterceptor(finderIntroductionInterceptor());*/
	}

	@Bean(name = "springContext")
	public SpringContext getSpringContext(){
		return new SpringContext();
	}

	@Bean
	protected UUIDFactory uuidFactory() {
		return new UUIDFactory();
	}

	@Bean(name ="freemarkerConfig")
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath(AppConstants.VIEW_PREFIX);

		Properties settings = new Properties();
		settings.setProperty("auto_import", "/spring.ftl as spring");


		//James Bloom
		/*configurer.setConfiguration(new freemarker.template.Configuration() {{
			setTemplateLoader(new MultiTemplateLoader(
					new TemplateLoader[]{
							new ClassTemplateLoader(FreeMarkerConfig.class, "/"),
							new WebappTemplateLoader(servletContext, "/")
					}
			));
			setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
			setStrictSyntaxMode(true);
			setWhitespaceStripping(true);
		}});*/
		//James Bloom



		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xml_escape", new XmlEscape());
		configurer.setFreemarkerSettings(settings);
		configurer.setFreemarkerVariables(map);
		configurer.setDefaultEncoding("UTF-8");
		return configurer;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setViewClass(FreeMarkerView.class);
		viewResolver.setPrefix(AppConstants.VIEW_PREFIX);
		viewResolver.setSuffix(AppConstants.VIEW_SUFFIX);
		viewResolver.setRequestContextAttribute(AppConstants.RC_CTX_ATTR);
		viewResolver.setContentType(AppComponent.DEFAULT_CONTENT_TYPE);
		viewResolver.setExposeSpringMacroHelpers(true);
		viewResolver.setExposeRequestAttributes(true);
		registry.freeMarker();
		registry.viewResolver(viewResolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(AppConstants.RESOURCE_HANDLER).
				addResourceLocations(AppConstants.RESOURCE_LOCATION);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreUnknownPathExtensions(false).
				defaultContentType(MediaType.TEXT_HTML);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/");
	}

	/*@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		return new ThreadPoolTaskExecutor() {{
			setCorePoolSize(15);
			setMaxPoolSize(25);
			setQueueCapacity(50);
			setRejectedExecutionHandler(
					new ThreadPoolExecutor.CallerRunsPolicy());
		}};
	}*/

	// this bean is in this ApplicationContext
	// so that it can be used in DelegatingFilterProxy
	@Bean(name = "wroManagerFactory")
	public WroManagerFactory wroManagerFactory() {
		WebResourceOptimizerConfigurableManagerFactory wroManagerFactory =
				new WebResourceOptimizerConfigurableManagerFactory();

		wroManagerFactory.setConfigProperties(new Properties() {{
			setProperty("debug", environment.getProperty("bundling.enabled"));
			setProperty("preProcessors", "cssImport,semicolonAppender,conformColors");
			setProperty("postProcessors", "yuiCssMin,googleClosureAdvanced");
			setProperty("cacheGzippedContent", "true");
			setProperty("hashStrategy", "MD5"); // should drive the naming strategy to fingerprint resource urls - NOT YET WORKING / CONFIGURED CORRECTLY
			setProperty("namingStrategy", "hashEncoder-CRC32"); // should drive the naming strategy to fingerprint resource urls - NOT YET WORKING / CONFIGURED CORRECTLY
		}});
		/*wroManagerFactory.setConfigProperties(new Properties() {{
			setProperty("debug", environment.getProperty("bundling.enabled"));
			setProperty("preProcessors", "cssImport,semicolonAppender,conformColors");
			setProperty("postProcessors", "yuiCssMin,googleClosureAdvanced");
			setProperty("cacheGzippedContent", "true");
			setProperty("hashStrategy", "MD5"); // should drive the naming strategy to fingerprint resource urls - NOT YET WORKING / CONFIGURED CORRECTLY
			setProperty("namingStrategy", "hashEncoder-CRC32"); // should drive the naming strategy to fingerprint resource urls - NOT YET WORKING / CONFIGURED CORRECTLY
		}});*/

		return wroManagerFactory;
	}
}