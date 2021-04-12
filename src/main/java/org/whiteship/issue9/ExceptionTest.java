package org.whiteship.issue9;
import java.lang.RuntimeException;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            Bridge br = new Bridge();
            br.connect();
        }catch (RuntimeException e) {
            System.out.println("Runtime Exception Catch!");
        }
    }
}
