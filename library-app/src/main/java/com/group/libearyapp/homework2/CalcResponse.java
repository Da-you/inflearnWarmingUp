package com.group.libearyapp.homework2;

public class CalcResponse {
  private int addResult;
  private int minusResult;
  private int multiplyResult;

  public CalcResponse() {
  }

  public int getAddResult() {
    return addResult;
  }

  public int getMinusResult() {
    return minusResult;
  }

  public int getMultiplyResult() {
    return multiplyResult;
  }

  public CalcResponse(int addResult, int minusResult, int multiplyResult) {
    this.addResult = addResult;
    this.minusResult = minusResult;
    this.multiplyResult = multiplyResult;
  }
}
