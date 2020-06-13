package com.turing;

public class Tape {
    private char [] tape;
    private int headPosition;

    public Tape(){}

    public Tape(int headPosition, String t){
        tape = t.toCharArray();
        this.headPosition = headPosition;
    }

    public void moveLeft(){
        headPosition--;
    }

    public void moveRight(){
        headPosition++;
    }

    public void updateTape(char value){
        tape[getCurrentPosition()] = value;
    }

    public int getCurrentPosition(){
        return headPosition;
    }


    public char getTapeAtPosition(){
        return tape[getCurrentPosition()];
    }

    public void printTape(){
        System.out.println();
        for(int j = 0; j < tape.length; j++) {
            System.out.print(tape[j]);
        }
    }
}
