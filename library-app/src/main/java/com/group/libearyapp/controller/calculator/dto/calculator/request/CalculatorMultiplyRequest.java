package com.group.libearyapp.controller.calculator.dto.calculator.request;
/**
 스프링이 자동으로 매개변수를 인스턴스화 해준다고해도 DTO에는 생성자가 없는데 어떻게 값이 정상적으로 할당되는지.
 자바 리플렉션 API 덕분이다.
 "리플렉션 (Reflection)" 이란 Java 코드가 실행중인 상황에서, 특정 클래스에 대한 정보를 가져와, 인스턴스를 만들거나, 필드의 목록을 불러오거나, 필드에 값을 넣어주는 등의 작업을 할 수 있는 기능이다.
 매개변수를 인스턴스화 하여 함수에 넣어주는 과정에서 리플렉션을 활용하면, private 변수에도 값을 직접 할당할 수가 있게 된다.

 **/
public class CalculatorMultiplyRequest {

//  private final int num1;
//  private final int num2;
private int num1;
private int num2;

  public int getNum1() {
    return num1;
  }

  public int getNum2() {
    return num2;
  }

//  public CalculatorMultiplyRequest(int num1, int num2) {
//    this.num1 = num1;
//    this.num2 = num2;
//  }
}
