package com.spring.core;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;


/**
 * Created by Iana_Kasimova on 8/23/2017.
 */
@Configuration
public class SpringCinfig {

    @Bean
    public PropertyPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertyPlaceholderConfigurer();
    }

    @Bean
    public DateFormat dateFormat(){
        return DateFormat.getDateTimeInstance();
    }
}
