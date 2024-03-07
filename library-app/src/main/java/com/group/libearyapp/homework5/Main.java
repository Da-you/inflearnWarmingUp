package com.group.libearyapp.homework5;

import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static int diceSize;
    private static int cnt;
    private static HashMap<Integer, Integer> valueMap = new HashMap<>();
    public static void main(String[] args) {
        firstStep();

        secondStep();

        finalStep();
    }
    private static void finalStep() {
        for (int i = 1; i <= diceSize; i++) {
            System.out.printf("%d는 %d번 나왔습니다.\n", i, valueMap.get(i));
        }
    }
    private static void secondStep() {
        for (int i = 1; i <= diceSize; i++) {
            valueMap.put(i, 0);
        }
        for (int i = 0; i < cnt; i++) {
            int result = (int) (Math.random() * diceSize - 1) + 1;
            valueMap.put(result, valueMap.get(result) + 1);
        }
    }
    private static void firstStep() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주시위 크기를 입력하시오 :");
        diceSize = sc.nextInt();
        System.out.println("숫자를 입력 하시오 :");
        cnt = sc.nextInt();
    }
}
