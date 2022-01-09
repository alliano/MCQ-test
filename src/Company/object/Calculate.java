package Company.object;

import java.io.IOException;
import java.util.Map;

import Company.abstrac.AbstracCalculate;

public class Calculate extends Components implements AbstracCalculate {
    private int correct;

    public Calculate(String questions) throws IOException {
        super(questions);
    }

    @Override
    public int calculateAns(String answer, Map<String, String> opsiAns) {
        
        if (opsiAns.get(answer).endsWith("*")) {
            System.out.println("correct");
            this.correct++;
        } else if (!answer.equals("a") || !answer.equals("b") || !answer.equals("c")|| !answer.equals("d")) {
            System.out.println("Wrong");
        }
        return getcorrect();
    }

    @Override
    public void mesaagge(int correct) {
        System.out.println("your graded is "+ correct*10+"%");
    }

    @Override
    public int getcorrect() {
        return this.correct;
    }

}
