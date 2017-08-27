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

      @Value("${id}")
      private String id;
      @Value("${name}")
      private String fullName;
      @Value("${greeting}")
      private String greeting;



}