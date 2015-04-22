package calculator;

public class Calculator {

    // TODO
    // java Calculator 10 plus 20 plus 100 minus 30 get
    int total = 0;

    abstract class Command {
        abstract void interpret();
    }

    public class Clear extends Command {

        @Override
        void interpret() {
            total = 0;
        }

    }

    public class Get extends Command {

        @Override
        void interpret() {
            System.out.println(total);
        }

    }

    public class Minus extends Plus {
        Minus(final int value) {
            super(-value);
        }
    }

    public class Plus extends Command {

        int _value;

        Plus(final int value) {
            _value = value;
        }

        @Override
        void interpret() {
            total += _value;
        }
    }

    public class Set extends Command {

        int _value;

        public Set(final int value) {
            _value = value;
        }

        @Override
        void interpret() {
            total = _value;
        }
    }

    public static void main(final String[] args) {
        Calculator calc = new Calculator();

        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                calc.new Set(Integer.parseInt(args[0])).interpret();
            } else if (args[i].equals("plus")) {
                calc.new Plus(Integer.parseInt(args[i + 1])).interpret();
            } else if (args[i].equals("minus")) {
                calc.new Minus(Integer.parseInt(args[i + 1])).interpret();
            } else if (args[i].equals("get")) {
                calc.new Get().interpret();
            }
        }

    }
}
