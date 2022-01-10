package Company.object;

import java.io.IOException;
import java.util.Map;

import Company.abstrac.AbstracCalculate;

public class Calculate extends Components implements AbstracCalculate {
    private int correct;

    public Calculate()throws Exception {
        super();
    }

    public Calculate(String questions) throws IOException {
        super(questions);
    }

    @Override
    public int calculateAns1(String answer[], Map<String, String> opsiAns) {
            if (opsiAns.get(answer[0]) == null) {
                System.out.println("Wrong");
            } else if (opsiAns.get(answer[0]).endsWith("*")) {
                System.out.println("correct");
                this.correct++;
            } else if (!opsiAns.get(answer[0]).endsWith("*")) {
                System.out.println("wrong");
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

    @Override
    public int calculateAns2(String[] answer, Map<String, String> opsiAns) {

        try {
            if (opsiAns.get(answer[0]) == null && opsiAns.get(answer[1]) == null) {
                System.out.println("Wrong");
            } else if (opsiAns.get(answer[0]).endsWith("*") && opsiAns.get(answer[1]).endsWith("*")) {
                System.out.println("correct");
                this.correct++;
            } else if (!opsiAns.get(answer[0]).endsWith("*") && !opsiAns.get(answer[1]).endsWith("*")) {
                System.out.println("wrong");
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        return getcorrect();
    }

}
