package calculatorLv2;

import java.util.ArrayList;
import java.util.List;

public class CalculatorLv2 {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> getResults() {
        return new ArrayList<>(result);
    }

    public void setResults(List<Integer> results) {
        this.result = results;
    }

    public int calculate(int num1, int num2, char operator) throws ArithmeticException, IllegalArgumentException {

        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        this.result.add(result);

        return result;
    }

    public void removeResult() {
        if (!result.isEmpty()) {
            result.remove(0);
        } else {
            System.out.println("삭제할 결과가 없습니다!");
        }
    }
}