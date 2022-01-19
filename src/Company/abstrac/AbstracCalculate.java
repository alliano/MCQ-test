package Company.abstrac;
import java.util.Map;

/**
 * Calculate
 */
public interface AbstracCalculate {

    public int calculateAns1(String[] answer, Map<String, String> opsiAns);
    public int calculateAns2(String[] answer, Map<String, String> opsiAns);

    public void mesaagge(int correct,String name);

    public int getcorrect();

}