package org.nus.pssn;

import javax.script.*;
import org.renjin.script.*;
import java.io.StringWriter;
import java.io.FileNotFoundException;

public class ROBRenjinRunner {
    // create a script engine manager:
    private static final RenjinScriptEngineFactory FACTORY = new RenjinScriptEngineFactory();
    // create a Renjin engine:
    private static final ScriptEngine ENGINE = FACTORY.getScriptEngine();
    private static StringWriter OutputWriter = new StringWriter();

    public ROBRenjinRunner() {
        ENGINE.getContext().setWriter(OutputWriter);
    }

    public static String evalR(String codeInR) {
        try {
            return ENGINE.eval(codeInR).toString();
        } catch (Exception e) {
            System.out.println("Evaluation Exception occurred: \n");
            return e.getMessage();
        }
    }

    public static void main(String[] args) {
        for (String arg: args) {
            System.out.println("Executing.." + arg);
        }
        try {
            System.out.println("We are executing 5+7 on Renjin");
            System.out.println(evalR("5+7"));
//            System.out.println("We are executing df <- data.frame(x=1:10, y=(1:10)+rnorm(n=10)) on Renjin");
//            System.out.println(evalR("df <- data.frame(x=1:10, y=(1:10)+rnorm(n=10))"));
//            //System.out.println(evalR("d"));
//            System.out.println(evalR("library(matlib)\n"+
//                    "  A <- matrix(c(2, 1, -1,\n" +
//                    "               -3, -1, 2,\n" +
//                    "               -2,  1, 2), 3, 3, byrow=TRUE)\n" +
//                    "  b <- c(8, -11, -3)\n" +
//                    " print(showEqn(A, b))\n"));
//            System.out.println(evalR("runs <- 1\t\t\t# Number of times the tests are executed\n" +
//                    "times <- rep(0, 15); dim(times) <- c(5,3)\n" +
//                    "cat(\"\\n\\n   R Benchmark 2.3\\n\")\n" +
//                    "cat(\"   ===============\\n\")\n" +
//                    "cat(c(\"Number of times each test is run__________________________: \", runs))\n" +
//                    "cat(\"\\n\\n\")\n" +
//                    "cat(\"   I. Matrix calculation\\n\")\n" +
//                    "cat(\"   ---------------------\\n\")\n" +
//                    "# (1)\n" +
//                    "x <- rnorm(150*150) / 10\n" +
//                    "cumulate <- 0; a <- 0; b <- 0\n" +
//                    "for (i in 1:runs) {\n" +
//                    "  invisible(gc())\n" +
//                    "  timing <- 0.1\n" +
//                    "  timing <- system.time({\n" +
//                    "    a <- matrix(rnorm(150*150)/10, ncol=150, nrow=150);\n" +
//                    "    b <- t(a);\n" +
//                    "    dim(b) <- c(75, 300);\n" +
//                    "    a <- t(b)\n" +
//                    "  })[3]\n" +
//                    "  cumulate <- cumulate + timing\n" +
//                    "}\n" +
//                    "timing <- cumulate/runs\n" +
//                    "times[1, 1] <- timing\n" +
//                    "cat(c(\"Creation, transp., deformation of a 1500x1500 matrix (sec): \", timing, \"\\n\"))\n" +
//                    "remove(\"a\", \"b\")"));

            System.out.println(evalR("print(system.time(print(1:1000000 + 1:1000000)))"));

        } catch (Exception e) {
            System.out.println("Exception occurred " + e);
        }
    }
}
