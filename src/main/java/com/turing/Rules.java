package com.turing;

public class Rules {
    private String[][] rules;
    private int ruleCount = 0;
    private String starterState;

    public Rules(){

    }

    public void setRules(String[][] rules) {
        this.rules = rules;
    }

    public void setRuleCount(int ruleCount) {
        this.ruleCount = ruleCount;
    }

    public void setStarterState(String starterState){
        this.starterState = starterState;
    }

    public String getStarterState(){
        return starterState;
    }

    public void increaseRuleCount(){
        ruleCount++;
    }

    public int getRuleCount(){
        return ruleCount;
    }

    public String state(int row){
        return rules[row][0];
    }

    public char read(int row){
        return rules[row][1].charAt(0);
    }

    public char write(int row){
        return rules[row][2].charAt(0);
    }

    public char move(int row){
        return rules[row][3].charAt(0);
    }

    public String nextState(int row){
        return rules[row][4];
    }
}
