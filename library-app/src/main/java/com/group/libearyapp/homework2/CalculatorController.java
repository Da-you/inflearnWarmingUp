package com.group.libearyapp.homework2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
// @RequestParam를 지우고 RequstDTO를 받아서 사용하면 좀 더 깔끔한 코드 가능
  @GetMapping("/api/v1/calc")
  public CalcResponse multi(@RequestParam(name = "num1") int num1,
      @RequestParam(name = "num2") int num2) {
    int add = num1 + num2;
    int minus = num1 - num2;
    int multiply = num1 * num2;
    return new CalcResponse(add, minus, multiply);
  }

  @GetMapping("/api/v1/day-of-week")
  public String day(@RequestParam(name = "date") LocalDate date) {
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    return dayOfWeek.toString();
  }

  @PostMapping("/api/v1/add")
  public Integer addNumbers(@RequestBody AddRequestDto requestDto) {
    Integer sum = 0;
    List<Integer> req = requestDto.getNumbers();
    for (Integer i : req) {
      sum += i;
    }
    return sum;

  }

}
