package com.ibcs.configuration;

import com.ibcs.AppConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by hossain.doula on 5/24/2016.
 */

@Configuration
@PropertySource("classpath:email.properties")
@ComponentScan(basePackages = {AppConstants.BASE_NAME_SPACE})
@EnableAspectJAutoProxy
public class EmailConfiguration {

    @Resource
    private Environment environment;

    @Bean
    public MailSender mailSender() {
        return new JavaMailSenderImpl() {{
            setHost(environment.getProperty("email.host"));
            setPort(environment.getProperty("email.port", Integer.class));
            setProtocol(environment.getProperty("email.protocol"));
            setUsername(environment.getProperty("email.username"));
            setPassword(environment.getProperty("email.password"));
            setJavaMailProperties(new Properties() {{ // https://javamail.java.net/nonav/docs/api/com/sun/mail/smtp/package-summary.html
                setProperty("mail.smtp.auth", "true");
                setProperty("mail.smtp.starttls.enable", environment.getProperty("email.starttls"));
                setProperty("mail.smtp.quitwait", "false");
            }});
        }};
    }
}
