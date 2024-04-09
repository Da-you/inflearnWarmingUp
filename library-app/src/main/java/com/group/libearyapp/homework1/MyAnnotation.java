package com.group.libearyapp.homework1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD) // 적용 위치
@Retention(value = RetentionPolicy.RUNTIME) // 생명주기
public @interface MyAnnotation {
  String value() default "-";
  int number() default 1;

}
