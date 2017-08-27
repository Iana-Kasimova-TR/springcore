
package com.spring.core;

import com.spring.core.beans.EventType;
import com.spring.core.loggers.ConsoleEventLogger;
import com.spring.core.loggers.EventLogger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Iana_Kasimova on 8/23/2017.
 */

@Configuration
@ImportResource("classpath:meanbeans.xml")
@ComponentScan("com.spring.core")
public class SpringConfig {

   // @Bean
   // public PropertyPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
   //     return new PropertyPlaceholderConfigurer();
   // }

    @Bean
    public Date date(){
        return new Date();
    }

    @Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateTimeInstance();
    }

    @Bean
    public EventType eventType(){
        return EventType.INFO;
    }

    @Bean
    public List<EventLogger> loggers(){
        List<EventLogger> list = new ArrayList<EventLogger>();
        list.add(ConsoleEventLogger);

    }
 }

