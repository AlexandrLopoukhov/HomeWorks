package calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String, Command> operations = new HashMap<String, Command>();
    {
        operations.put("set", new Set(0));
        operations.put("plus", new Plus(0));
        operations.put("minus", new Minus(0));
        operations.put("get", new Get());
    }

    // TODO
    // java Calculator 10 plus 20 plus 100 minus 30 get
    int total = 0;

    abstract class Command {
        abstract void interpret();

        abstract void setValue(int i);
    }

    public class Clear extends Command {

        @Override
        void interpret() {
            total = 0;
        }

        @Override
        void setValue(final int i) {
            // TODO Auto-generated method stub

        }

    }

    public class Get extends Command {

        @Override
        void interpret() {
            System.out.println(total);
        }

        @Override
        void setValue(final int i) {
            // TODO Auto-generated method stub

        }

    }

    public class Minus extends Plus {
        Minus(final int value) {
            super(-value);
        }

        @Override
        void setValue(final int i) {
            _value = -i;
            interpret();
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

        @Override
        void setValue(final int i) {
            _value = i;
            interpret();
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

        @Override
        void setValue(final int i) {
            _value = i;
            interpret();
        }
    }

    public static void main(final String[] args) {
        Calculator calc = new Calculator();

        calc.operations.get("set").setValue(Integer.parseInt(args[0]));
        for (int i = 1; i < args.length; i += 2) {
            if (i == args.length - 1) {
                calc.operations.get(args[i]).interpret();
            } else {
                calc.operations.get(args[i]).setValue(
                        Integer.parseInt(args[i + 1]));
            }
        }

    }
}
