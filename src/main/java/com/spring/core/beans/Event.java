package com.spring.core.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Iana_Kasimova on 8/21/2017.
 */
@Data
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Event {
    private int id = (int)Math.random();
    private String msg;
    private Date date;
    private DateFormat dateForm;
    private EventType type;

    public String toString() {
       return "id"+this.id+"with date"+this.dateForm.format(this.date)+"message"+this.msg;
    }

    @Autowired
        public Event(Date dt, DateFormat df, @Value("{INFO}") EventType tp){
            this.date = dt;
            this.dateForm = df;
            this.type = tp;
        }

}
