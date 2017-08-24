package com.spring.core.beans;


import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@Component
@PropertySource(value={"client.properties"})
public class Client {


      private String id;
      private String fullName;
      private String greeting;

      @Autowired
      public Client(@Value("{id}")String id, @Value("{name}")String name, @Value("{greeting}")String greeting){
            this.id=id;
            this.fullName=name;
            this.greeting=greeting;
      }

}