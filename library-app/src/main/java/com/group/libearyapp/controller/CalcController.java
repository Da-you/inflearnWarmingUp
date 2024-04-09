package com.group.libearyapp.controller;

import com.group.libearyapp.controller.calculator.dto.calculator.request.CalculatorAddRequest;
import com.group.libearyapp.controller.calculator.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

  @GetMapping("/add")
  public int addTwoNumbers(CalculatorAddRequest request) {
    return request.getNum1() + request.getNum2();
  }

  // 생성자 없이 값이 할당되는 이유 컨트롤러 코드에서 단순히 해당 DTO 객체를 매개변수로 적었을 뿐인데 API가 호출되면 자동으로 인스턴스화 해서 함수를 실행한다.
  // 이게 가능한 이유는 스프링 프레임워크의 내부적으로 API 요청을 받으면
  // API의 URL은 무엇인지, HTTP Method는 무엇인지 확인해
  // 적절한 Controller 클래스와, Controller 내부의 함수를 특정한 후 필요한 매개변수를 스프링이 직접 인스턴스화 하여 넣어준다.
  @PostMapping("/multiply")
  public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
    return request.getNum1() * request.getNum2();
  }

}
