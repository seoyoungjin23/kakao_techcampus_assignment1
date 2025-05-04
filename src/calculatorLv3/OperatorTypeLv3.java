package calculatorLv3;

public enum OperatorTypeLv3 {
    ADD {
        @Override
        public double operation(double x, double y) {
            return x + y;
        }
    },
    SUB {
        @Override
        public double operation(double x, double y) {
            return x - y;
        }
    },
    MUL {
        @Override
        public double operation(double x, double y) {
            return x * y;
        }
    },
    DIV {
        @Override
        public double operation(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다!");
            }
            return x / y;
        }
    };

    public abstract double operation(double x, double y);
}
