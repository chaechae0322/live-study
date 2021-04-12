package org.whiteship.issue9;

public class Bridge {
    public void connect(){
        RuntimeException rn = new RuntimeException();
        rn.makeRuntimeException();
    }
}
