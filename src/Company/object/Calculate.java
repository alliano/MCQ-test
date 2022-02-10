/**********************************************
 * this programs under development by alliano *
 * ********************************************
 */

package Company.object;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Company.abstrac.AbstracCalculate;


/**
 * this class implement interface/abstrac form class AbstracCalculate
 */
public class Calculate extends Components implements AbstracCalculate {
    private int correct;//this variable for storage corect answear (just point)
    private int wrong;//same like above //storage wrong points

    /**
     * overide constructor calculate
     * 
     * @throws Exception
     */
    public Calculate()throws Exception {
        super();
    }

    public Calculate(String questions) throws IOException {
        super(questions);
    } 
    
    /**
     * this class recive data
     * 1.answear as user's answear
     * 2.opsiAns as options of question
     * 
     * 
     *  **/
    @Override
    public int[] calculateAns1(String[] answer, Map<String, String> opsiAns) {
        String[] isValid = new String[1];
        String[] ops = { "a", "b", "c", "d" };
        for (int i = 0; i < opsiAns.size(); i++) {
            if (opsiAns.get(ops[i]).endsWith("*")) {
                isValid[0] = opsiAns.get(ops[i]).replace("*", " ");
            }
        }
            // jik user milih selain opsi abcd | if user pick else abcd or user pick not available options
            if (opsiAns.get(answer[0]) == null) {
                System.out.println("\nWrong the correct answear is " + isValid[0]);
                this.wrong++;

                // jika user memnilih jawaban yang benar | if user pick the correct answer
            } else if (opsiAns.get(answer[0]).endsWith("*")) {
                System.out.println("correct");
                this.correct++;

                // jika user memilih jawaban yang salah | if user pick the wrong answer
            } else if (!opsiAns.get(answer[0]).endsWith("*")) {
                System.out.println("Wrong the correct answear is " + isValid[0]);
                this.wrong++;
            }
        // mengembalikan jumlah jawaban yang benar dan salah | this method will return the point of user
        return getcorrect();
    }
    
    /**
     * menampilkan pesan jika sudah selesai pertanyaanya | this method will show message if the answear have answered
     */
    @Override
    public void mesaagge(int[] result,String name) {
        System.out.println("\n"+"Hi " + name + " you wrong " + result[1] + " and correct " + result[0] + " your graded is " + result[0]*10+"%");
    }


    /**
     * this method will return array 
     * arrays contains point of user(wrong and corect)
     * 
     * **/
    @Override
    public int[] getcorrect() {
        int[] result = new int[2];
        result[0] = this.correct;
        result[1] = this.wrong;
        return result;
    }

    /**
     * for multiple answer
     */
    @Override
    public int[] calculateAns2(String[] answer, Map<String, String> opsiAns) {
        List<String> isValid = new ArrayList<>();
    
        //entry set mengubah array map menjadi seperti array biasa kek gini [a=a.kamu,b=b.love you];

        opsiAns.entrySet().forEach((item) -> {
            if (item.getValue().endsWith("*")) {
                isValid.add(item.getValue().replace("*", " "));
            }
        });

        try {
            if (opsiAns.get(answer[0]) == null && opsiAns.get(answer[1]) == null) {
                System.out.println("Wrong " + "the correct answears are "  +  isValid.get(0)  + " and " + isValid.get(1));
                this.wrong++;
            } else if (opsiAns.get(answer[0]) == opsiAns.get(answer[1])) {
                System.out.println("Wrong " + "the correct answears are "  +  isValid.get(0)  + " and " + isValid.get(1));
                this.wrong++;
            } else if (!opsiAns.get(answer[0]).endsWith("*") && !opsiAns.get(answer[1]).endsWith("*")) {
                System.out.println("Wrong " + "the correct answears are "  +  isValid.get(0)  + " and " + isValid.get(1));
                this.wrong++;
            } else if (opsiAns.get(answer[0]).endsWith("*") && opsiAns.get(answer[1]).endsWith("*")) {
                System.out.println("correct");
                this.correct++;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        return getcorrect();
    }

}
