package org.whiteship.issue5;

public class NewOperator {
    public static void main(String[] args) {
        Acme a;     // Acme 타입의 참조변수 선언
        a = null;   // a 변수에 null assign
        System.out.println(a);

        System.out.println("----------");
        // new 연산자가 메모리에 Acme 객체 생성 후 주소값 리턴, 대입연산자로 리턴된 주소값을 참조변수 a에 할당
        a = new Acme();
        System.out.println(a);

        System.out.println("----------");
        // loop 5 times showing what the NEW operator returns as a reference
        for (int i = 0; i < 5; i++) {
            System.out.println(new Acme());
        }
    }
}

class Acme {
    // empty class
}
