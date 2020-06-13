package com.turing.machine;

import com.turing.Rules;
import com.turing.Tape;
import com.turing.model.Params;

public final class Processor {

    private Processor(){}

    public static void start(Params params) {
        Rules rules = params.getRules();
        Tape tape = params.getTape();
        String state = rules.getStarterState();
        while (true) {
            for (int i = 0; i < rules.getRuleCount(); i++) {
                if (rules.state(i).equals(state) && rules.read(i) == tape.getTapeAtPosition()) {
                    tape.updateTape(rules.write(i));
                    if (rules.move(i) == 'L') {
                        tape.moveLeft();
                    } else {
                        tape.moveRight();
                    }
                    state = rules.nextState(i);
                    tape.printTape();
                }
            }
        }
    }
}
