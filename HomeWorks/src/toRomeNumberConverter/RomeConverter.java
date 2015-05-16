package toRomeNumberConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/*Правило вычитания:

 IV = 4
 IX = 9
 XL = 40
 XC = 90
 CD = 400
 CM = 900

 1   I   лат. unus, unum
 5   V   лат. quinque
 10  X   лат. decem
 50  L   лат. quinquaginta
 100     C   лат. centum
 500     D   лат. quingenti
 1000    M   лат. mille*/
public class RomeConverter {
    Map<Integer, Integer> parseArab = new LinkedHashMap<Integer, Integer>();
    {
        parseArab.put(1000, 0);
        parseArab.put(500, 0);
        parseArab.put(100, 0);
        parseArab.put(50, 0);
        parseArab.put(10, 0);
        parseArab.put(5, 0);
        parseArab.put(1, 0);
    }

    RomeConverter(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Year must by => zero");
        }
        int temp = i;
        for (Map.Entry<Integer, Integer> pair : parseArab.entrySet()) {
            pair.setValue(temp / pair.getKey());
            temp = temp % pair.getKey();
        }
    }

    String convertM() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < this.parseArab.get(1000); i++) {
            temp.append("M");
        }
        return temp.toString();
    }

    String convertD() {
        if (1 == this.parseArab.get(500) && 4 == this.parseArab.get(100)) {
            return "CM";
        } else {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < this.parseArab.get(500); i++) {
                temp.append("D");
            }
            return temp.toString();
        }
    }

    String convertC() {
        if (1 == this.parseArab.get(500) && 4 == this.parseArab.get(100)) {
            return "";
        } else {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < this.parseArab.get(100); i++) {
                temp.append("C");
            }
            return temp.toString();
        }
    }

    String convertL() {
        if (1 == this.parseArab.get(50) && 4 == this.parseArab.get(10)) {
            return "XC";
        } else {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < this.parseArab.get(50); i++) {
                temp.append("L");
            }
            return temp.toString();
        }
    }

    String convertX() {
        if (1 == this.parseArab.get(50) && 4 == this.parseArab.get(10)) {
            return "";
        } else {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < this.parseArab.get(10); i++) {
                temp.append("X");
            }
            return temp.toString();
        }
    }

    String convertV() {
        if (1 == this.parseArab.get(5) && 4 == this.parseArab.get(1)) {
            return "IX";
        } else {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < this.parseArab.get(5); i++) {
                temp.append("V");
            }
            return temp.toString();
        }
    }

    String convertI() {
        if (1 == this.parseArab.get(5) && 4 == this.parseArab.get(1)) {
            return "";
        } else if (4 == this.parseArab.get(1)) {
            return "IV";
        } else {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < this.parseArab.get(1); i++) {
                temp.append("I");
            }
            return temp.toString();
        }
    }

    public static String convertNumber(final int i) {
        StringBuilder temp = new StringBuilder();
        RomeConverter x = new RomeConverter(i);
        temp.append(x.convertM());
        temp.append(x.convertD());
        temp.append(x.convertC());
        temp.append(x.convertL());
        temp.append(x.convertX());
        temp.append(x.convertV());
        temp.append(x.convertI());
        return temp.toString();
    }
}
