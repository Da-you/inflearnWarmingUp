package com.group.libearyapp.homework1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @GetMapping()
  public String hello(@MyAnnotation String hello){
    return "hello";
  }

}
