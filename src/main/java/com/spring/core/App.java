package com.spring.core;


import com.spring.core.beans.Client;
import com.spring.core.beans.Event;
import com.spring.core.loggers.CacheFileEventLogger;
import com.spring.core.loggers.ConsoleEventLogger;
import com.spring.core.loggers.EventLogger;
import lombok.AllArgsConstructor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@AllArgsConstructor
public class App {
    public Client client;
    public EventLogger eventLogger;
    public EventLogger cacheFileEventLogger;


    public void logEvent(Event event) throws IOException {
        event.setMsg(client.getFullName());
        cacheFileEventLogger.logEvent(event);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args){

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.client = (Client) ctx.getBean("client");
        app.eventLogger = (ConsoleEventLogger) ctx.getBean("eventLogger");
        app.cacheFileEventLogger = (CacheFileEventLogger) ctx.getBean("cacheEventLogger");
       try {
           app.logEvent((Event) ctx.getBean("event"));
       }catch(IOException e){
           e.printStackTrace();
       }
        ctx.close();
    }
}