package com.spring.core.beans;

import lombok.Data;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Iana_Kasimova on 8/21/2017.
 */
@Data
public class Event {
    private int id = (int)Math.random();
    private String msg;
    private Date date;
    private DateFormat dateForm;

    public String toString() {
       return "id"+this.id+"with date"+this.dateForm.format(this.date)+"message"+this.msg;
    }

        public Event(Date dt, DateFormat df){
            this.date = dt;
            this.dateForm = df;
        }

}
