package com.turing.readers;

import com.turing.Rules;
import com.turing.Tape;
import com.turing.model.Params;

import java.io.*;

public class TextReader implements Reader{

    public Params read(String path) {
        Params params = new Params();
        Rules rules = null;
        Tape tape = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            tape = new Tape(Integer.parseInt(br.readLine()), br.readLine());
            rules = readRules(br);
            br.close();
            rules.setStarterState("0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        params.setRules(rules);
        params.setTape(tape);
        return params;
    }

    private Rules readRules(BufferedReader br) throws IOException {
        Rules rules = new Rules();
        int ruleCount = 0;
        String readLine;
        String[][] r = new String[100][5];
        while ((readLine = br.readLine()) != null) {
            if( readLine.isBlank()) continue;
            String[] tokens = readLine.split(" ");
            for(int i = 0; i < 5; i++) {
                r[ruleCount][i] = tokens[i];
            }
            ruleCount++;
        }
        rules.setRules(r);
        rules.setRuleCount(ruleCount);
        return rules;
    }

}
