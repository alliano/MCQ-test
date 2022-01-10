package Company.abstrac;
import java.util.Map;

/**
 * Calculate
 */
public interface AbstracCalculate {

    public int calculateAns(String[] answer, Map<String, String> opsiAns);

    public void mesaagge(int correct);

    public int getcorrect();

}