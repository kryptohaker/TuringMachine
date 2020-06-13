package com.turing.readers;
import java.io.IOException;
import com.turing.Rules;
import com.turing.Tape;
import com.turing.model.Params;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.Iterator;

public class JsonReader implements Reader {

    public Params read(String path) throws IOException, ParseException {
        Params params = new Params();
        Rules rules;
        Tape tape;
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
        int headPosition = Integer.parseInt((String) jsonObject.get("head-start-position"));
        tape = new Tape(headPosition, (String) jsonObject.get("tape"));
        rules = readRules(jsonObject);
        params.setTape(tape);
        params.setRules(rules);
        return params;
    }

    private Rules readRules(JSONObject jsonObject) {
        Rules rules = new Rules();
        JSONArray rulesJson = (JSONArray) jsonObject.get("rules");
        Iterator iterator = rulesJson.iterator();
        String[][] r = new String[100][5];
        int ruleCount = 0;
        while (iterator.hasNext()) {
            JSONObject rule = (JSONObject) iterator.next();
            r[ruleCount][0] = (String) rule.get("state");
            r[ruleCount][1] = (String) rule.get("read");
            r[ruleCount][2] = (String) rule.get("write");
            r[ruleCount][3] = (String) rule.get("move");
            r[ruleCount][4] = (String) rule.get("next-state");
            ruleCount++;
        }
        rules.setRuleCount(ruleCount);
        rules.setRules(r);
        rules.setStarterState("0");
        return rules;
    }
}

