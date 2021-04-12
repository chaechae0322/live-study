package org.whiteship.issue5;

public class Constructor {
    private String message;

    public Constructor(){
        System.out.println("called by this()");
    }
    public Constructor(String message) {
        this();                 // 생성자 this
        this.message = message; // 객제 자기 자신 this
    }

    public static void main(String[] args) {
        Constructor cons = new Constructor("hello");
        System.out.println(cons.message);
    }
}
