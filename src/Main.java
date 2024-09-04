import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 변수 선언
        long result;
        double dResult;

        while(true) {
            try {
                // 1. 첫 번째 피연산자 입력(0을 포함한 양의 정수)
                System.out.println();
                System.out.println("======== 계산기 ========");
                Scanner sc = new Scanner(System.in);
                System.out.print("첫 번째 숫자를 입력하세요: ");
                long firstNum = sc.nextLong();

                // 2. 연산자 입력
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
                char operator = sc.next().charAt(0);

                // 3. 두 번째 피연산자 입력(0을 포함한 양의 정수)
                System.out.print("두 번째 숫자를 입력하세요: ");
                long secondNum = sc.nextLong();

                // 1-1, 3-1. 데이터 정합성 검사
                if (firstNum < 0 || secondNum < 0) {
                    System.out.println("======== 결과값 ========");
                    System.out.println("음수는 입력이 불가합니다!");
                    continue;
                }

                System.out.println("======== 결과값 ========");

                // 4. 연산자에 따른 계산
                switch (operator) {
                    case '+':
                        result = firstNum + secondNum;
                        System.out.println(result);
                        break;

                    case '-':
                        result = firstNum - secondNum;
                        System.out.println(result);
                        break;

                    case '*':
                        result = firstNum * secondNum;
                        System.out.println(result);
                        break;

                    case '/':
                        // 나눠 떨어지는 수는 정수로 표기되고, 소수점이 있는 경우 실수로 표기
                        if (firstNum % secondNum == 0) {
                            result = firstNum / secondNum;
                            System.out.println(result);
                        } else {
                            dResult = (double)firstNum / secondNum;
                            System.out.println(dResult);
                        }
                        break;

                    default:
                        System.out.println("사칙연산을 잘못 입력하였습니다!");
                        break;

                }

                // 5. 예외 처리
            } catch (InputMismatchException e) { // 데이터 타입 허용 범위 외 값이 입력된 경우
                System.out.println("======== 결과값 ========");
                System.out.println("잘못된 값을 입력하였습니다!");
            } catch (ArithmeticException e) { // 산술적인 에러가 발생한 경우
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다!");

            } finally {
                // 4. 연산 재개 또는 종료
                System.out.println("======================");
                System.out.print("더 계산하시겠습니까? (y or exit) ");
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