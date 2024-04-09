package com.group.libearyapp.homework1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @GetMapping()
  public String hello( String hello) {
    return "hello";
  }
  @MyAnnotation
  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

    // 리플렉션으로 서비스 클래스의 메서드 흭득
    Method[] methods = MyService.class.getMethods();

    for (Method method : methods) {
      // 어노 테이션 적용 확인
      if (method.isAnnotationPresent(MyAnnotation.class)){
        // 적용 되어 있다면 메서드 객체를 흭득
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        System.out.println(method.getName());
        for (int i = 0; i < annotation.number(); i++){
          System.out.print(annotation.value());
        }
        System.out.println();

        method.invoke(new MyService());
      }
    }
  }
}
