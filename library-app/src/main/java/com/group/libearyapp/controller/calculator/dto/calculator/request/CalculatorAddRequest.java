package com.group.libearyapp.controller.calculator.dto.calculator.request;

public class CalculatorAddRequest {
// final을 붙인 이유 final 키워드를 변수에 붙이면 해당 필드는 변경이 불가능한 불변 상태가 된다.
// 해당 DTO 경우 API를 통해 들어온 값이 기록된 후 변경될 필요가 없기에 final 키워드를 사용,
// 불변 키워드를 많이 쓸수록 SW가 안전해진다.

  private final int num1;
  private final int num2;

  public CalculatorAddRequest(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  public int getNum1() {
    return num1;
  }

  public int getNum2() {
    return num2;
  }

}
