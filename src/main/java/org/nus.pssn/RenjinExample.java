package org.nus.pssn;

import javax.script.*;
import org.renjin.eval.*;
import org.renjin.sexp.*;
import org.renjin.script.*;
import java.io.StringWriter;
import java.io.FileNotFoundException;

public class RenjinExample {
    // create a script engine manager:
    private static final RenjinScriptEngineFactory FACTORY = new RenjinScriptEngineFactory();
    // create a Renjin engine:
    private static final ScriptEngine ENGINE = FACTORY.getScriptEngine();
    private static StringWriter OutputWriter = new StringWriter();

    public RenjinExample() {
        ENGINE.getContext().setWriter(OutputWriter);
    }
    public static String evalR(String codeInR) {
        try {
            return ENGINE.eval(codeInR).toString();
        } catch (ScriptException e) {
            System.out.println("Script Exception occurred " + e);
            return "Error occurred";
        }
    }

    public static void main(String[] args) {
        for (String arg: args) {
            System.out.println("Executing.." + arg);
        }
        try {
            System.out.println("We are executing 5+7 on Renjin");
            System.out.println(evalR("5+7"));
            System.out.println("We are executing df <- data.frame(x=1:10, y=(1:10)+rnorm(n=10)) on Renjin");
            System.out.println(ENGINE.eval("df <- data.frame(x=1:10, y=(1:10)+rnorm(n=10))"));
        } catch (ScriptException e) {
            System.out.println("Script Exception occurred " + e);
        } catch (Exception e) {
        System.out.println("Exception occurred " + e);
    }
    }
}
