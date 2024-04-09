package com.group.libearyapp.homework1;

public class MyService {

  @MyAnnotation
  public void test1() {
    System.out.println("result 1");
  }

  // 문자열값 변경
  @MyAnnotation(value = "*")
  public void test2() {
    System.out.println("result 2");
  }

  // 문자열, 숫자 변경
  @MyAnnotation(value = "#", number = 3)
  public void test3() {
    System.out.println("result 3");
  }

}
