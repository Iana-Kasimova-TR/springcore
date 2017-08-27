package com.spring.core;


import com.spring.core.beans.Client;
import com.spring.core.beans.Event;
import com.spring.core.beans.EventType;
import com.spring.core.loggers.EventLogger;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

import static com.spring.core.beans.EventType.ERROR;
import static com.spring.core.beans.EventType.INFO;

@AllArgsConstructor
@Data
public class App {
    //@Autowired
    public Client client;
   // @Autowired
    public EventLogger eventLogger;
    //@Autowired
    public Map<EventType, EventLogger> loggers;

    public void logEvent(Event event) throws IOException {
        event.setMsg(client.getFullName()+client.getGreeting());
        if(event.getType()== INFO){
            loggers.get(INFO).logEvent(event);
        }
        else if(event.getType()== ERROR){
            loggers.get(ERROR).logEvent(event);
        }else{
            eventLogger.logEvent(event);
        }


    }

    public static void main(String[] args){

       // ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("meanbeans.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringConfig.class);
        ctx.refresh();
        App app = (App) ctx.getBean("app");
       try {
           app.logEvent((Event) ctx.getBean("event"));
       }catch(IOException e){
           e.printStackTrace();
       }
        ctx.close();
    }
}