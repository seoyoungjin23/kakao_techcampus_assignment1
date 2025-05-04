package calculatorLv3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculatorLv3 {
    private List<Double> result = new ArrayList<>();

    public List<Double> getResults() {
        return new ArrayList<>(result);
    }

    public void setResults(List<Double> results) {
        this.result = results;
    }

    public <T extends Number, U extends Number> double calculate(T num1, U num2, char operatorChar)
            throws ArithmeticException, IllegalArgumentException {

        OperatorTypeLv3 operator;
        switch (operatorChar) {
            case '+':
                operator = OperatorTypeLv3.ADD;
                break;
            case '-':
                operator = OperatorTypeLv3.SUB;
                break;
            case '*':
                operator = OperatorTypeLv3.MUL;
                break;
            case '/':
                operator = OperatorTypeLv3.DIV;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다!");
        }

        double resultValue = operator.operation(num1.doubleValue(), num2.doubleValue());
        result.add(resultValue);

        return resultValue;
    }

    public void removeResult() {
        if (!result.isEmpty()) {
            result.remove(0);
        } else {
            System.out.println("삭제할 결과가 없습니다!");
        }
    }

    public List<Double> getResultsBigger(double threshold) {
        return result.stream()
                .filter(r -> r > threshold)
                .toList();
    }
}