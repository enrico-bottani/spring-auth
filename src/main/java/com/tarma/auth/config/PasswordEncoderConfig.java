package com.tarma.auth.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    // @Bean is a method-level annotation and a direct analog of the XML <bean/> element. The annotation supports
    // most of the attributes offered by <bean/> such as init-method, destroy-method, autowiring,
    // lazy-init, dependency-check, depends-on and scope.
    // When JavaConfig encounters such a method, it will execute that method and register the return value as a bean
    // within a BeanFactory. By default, the bean name will be that of the method name.
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
