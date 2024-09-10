package Lv2;

import java.util.*;

public class App {
    public static void main(String[] args) {

        // Calculator 객체 생성
        Calculator cal = new Calculator();

        while(true) {

            try {

                // 계산기 기능 선택
                System.out.println("======== 계산기 ========");
                System.out.println("1.계산 2.Clear 3.All_Clear");
                System.out.println("=======================");
                System.out.print("기능 선택: ");
                Scanner sc = new Scanner(System.in);
                int func = sc.nextInt();

                // 계산기 기능별 동작
                switch (func) {
                    case 1:
                        // 첫 번째 피연산자 입력(0을 포함한 양의 정수)
                        System.out.println();
                        System.out.println("======== 계산 =========");
                        System.out.print("첫 번째 숫자를 입력하세요: ");
                        double firstNum = sc.nextLong();

                        // 연산자 입력
                        System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
                        char operator = sc.next().charAt(0);

                        // 두 번째 피연산자 입력(0을 포함한 양의 정수)
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        double secondNum = sc.nextLong();

                        // 데이터 정합성 검사
                        if (firstNum < 0 || secondNum < 0) {
                            System.out.println("======== 결과값 ========");
                            System.out.println("음수는 입력이 불가합니다!");
                            continue;
                        }

                        System.out.println("======== 결과값 ========");

                        // 연산자에 따른 계산
                        switch (operator) {
                            case '+':
                                System.out.println((int) cal.add(firstNum, secondNum));
                                break;

                            case '-':
                                System.out.println((int) cal.subtract(firstNum, secondNum));
                                break;

                            case '*':
                                System.out.println((int) cal.multiply(firstNum, secondNum));
                                break;

                            case '/':
                                // 나눠 떨어지는 수는 정수로 표기되고, 소수점이 있는 경우 실수로 표기
                                if (firstNum % secondNum == 0.0) {
                                    System.out.println((int) cal.divide(firstNum, secondNum));
                                } else {
                                    System.out.println(cal.divide(firstNum, secondNum));
                                }
                                break;

                            default:
                                System.out.println("사칙연산을 잘못 입력하였습니다!");
                                break;

                        }
                        break;

                    case 2:
                        System.out.println();
                        System.out.println("======== Clear =========");
                        System.out.print("가장 먼저 저장된 데이터를 삭제하시겠습니까? (y or n): ");
                        String clear = sc.next();
                        if (clear.equals("y")) {
                            cal.removeResult();
                            continue;
                        }
                        break;

                    case 3:
                        System.out.println();
                        System.out.println("======== All_Clear =========");
                        System.out.print("저장된 모든 데이터를 삭제하시겠습니까? (y or n): ");
                        String allClear = sc.next();
                        if (allClear.equals("y")) {
                            cal.allClear();
                            continue;
                        }
                        break;
                }

            // 예외 처리
            } catch (InputMismatchException e) { // 데이터 타입 허용 범위 외 값이 입력된 경우
                System.out.println("======== 결과값 ========");
                System.out.println("잘못된 값을 입력하였습니다!");
            } catch (ArithmeticException e) { // 산술적인 에러가 발생한 경우
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다!");

            } finally {
                // 연산 재개 또는 종료
                System.out.println("======================");
                System.out.print("더 계산하시겠습니까? (y or exit): ");
                Scanner sc = new Scanner(System.in);
                String sys = sc.next();
                if (sys.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    break;
                } else {
                    continue;
                }
            }
        }
    }
}
