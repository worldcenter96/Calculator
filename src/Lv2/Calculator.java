package Lv2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator {

    private List<Double> resultList = new LinkedList<Double>();

    // 덧셈 메서드 선언
    public double add(double firstNum, double secondNum) {
        resultList.add(firstNum + secondNum);
        return resultList.get(resultList.size()-1);
    }

    // 뺄셈 메서드 선언
    public double subtract(double firstNum, double secondNum) {
        resultList.add(firstNum - secondNum);
        return resultList.get(resultList.size()-1);
    }

    // 곱셈 메서드 선언
    public double multiply(double firstNum, double secondNum) {
        resultList.add(firstNum * secondNum);
        return resultList.get(resultList.size()-1);
    }

    // 나눗셈 메서드 선언
    public double divide(double firstNum, double secondNum) {
        resultList.add(firstNum / secondNum);
        return resultList.get(resultList.size()-1);
    }

    // 먼저 저장된 데이터 삭제 메서드 선언
    public void removeResult() {
        System.out.println(resultList.remove(0) + "값의 삭제가 완료되었습니다.");
    }

    // 모든 데이터 삭제
    public void allClear() {
        resultList.clear();
        System.out.println("모든 결과 데이터가 삭제 되었습니다.");
    }

    // 객체 수 파악
    public void size() {
        System.out.println("결과 값의 수: " + resultList.size());
    }

    // 큐 객체 확인
    public List<Double> getResultList() {
        return resultList;
    }
}
