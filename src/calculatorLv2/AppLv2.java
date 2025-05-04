package calculatorLv2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv2 calculator = new CalculatorLv2();

        while(true) {
            int num1;
            int num2;
            char operator;
            int result;

            /*
                숫자 입력 받는 부분
             */
            while (true) {
                try {
                    System.out.print("첫 번째 숫자(0 or 양의 정수)를 입력하세요: ");
                    num1 = sc.nextInt();
                    if (num1 < 0) {
                        System.out.println("음의 정수는 입력 불가능 합니다!");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("입력 값이 잘못되었습니다! 숫자를 입력해주세요!");
                    sc.next();
                }
            }

            while (true) {
                try {
                    System.out.print("두 번째 숫자(0 or 양의 정수)를 입력하세요: ");
                    num2 = sc.nextInt();
                    if (num2 < 0) {
                        System.out.println("음의 정수는 입력 불가능 합니다!");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("입력 값이 잘못되었습니다! 숫자를 입력해주세요!");
                    sc.next();
                }
            }

            /*
                사칙연산 기호 입력 받는 부분
             */
            while (true) {
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                String input = sc.next();
                if (input.length() != 1) {
                    System.out.println("한 글자만 입력해주세요!");
                    continue;
                }

                operator = input.charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println("유효하지 않은 연산자입니다! (+, -, *, / 중에서 입력해주세요)");
                }
            }

            try {
                result = calculator.calculate(num1, num2, operator);
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다!");
                System.out.println("계산기를 다시 실행 합니다...\n");
                continue;
            }

            /*
                출력
             */
            System.out.println("[결과]\n" + result);

            // getter 활용
            List<Integer> originResults = calculator.getResults();
            System.out.println("[모든 연산 결과 리스트]\n" + originResults);

            // remove 메소드 활용
            calculator.removeResult();
            System.out.println("가장 먼저 저장된 데이터가 삭제되었습니다. \n[삭제 결과 리스트]\n" + calculator.getResults());

            // setter 활용
            calculator.setResults(originResults);
            System.out.println("삭제된 데이터를 복구하였습니다. \n[복구 결과 리스트]\n" + calculator.getResults());

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String reply = sc.next();
            if (reply.equals("exit")) {
                break;
            }

        }
    }
}