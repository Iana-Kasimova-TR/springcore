package com.spring.core.beans;


import lombok.*;


@Data
public class Client {

      @NonNull
      private String id;
      @NonNull
      private String fullName;
      private String greeting;

}