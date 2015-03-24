package homeWork1;

import java.util.Date;

public class PrintfDemo {

    public static void main(final String[] args) {
        String hello = "Hello";
        // TODO Auto-generated method stub
        System.out
                .printf("Demo printf - %2$s %1$s!!! %3$.10f - demofloat, %3$e - exponential, %4$tF - date ",
                        "world", hello, Math.PI, new Date());
    }

}
