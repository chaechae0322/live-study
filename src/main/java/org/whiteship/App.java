package org.whiteship;

import org.whiteship.issue4.DashBoard;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) {

        try {
            DashBoard board = new DashBoard("chaechae0322/live-study");
            board.makeBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
