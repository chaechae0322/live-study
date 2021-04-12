package org.whiteship.issue5;

public class Init {
    private int number;

    {
        System.out.println("just block number "+this.number);
    }

    public Init() {
        this.number = 100;
    }

    public static void main(String[] args) {
        Init init = new Init();
        System.out.println(init.number);
    }
}
