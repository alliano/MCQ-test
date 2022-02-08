package Company.object;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import Company.abstrac.AbstracCalculate;

public class Calculate extends Components implements AbstracCalculate {
    private int correct;
    private int wrong;

    public Calculate()throws Exception {
        super();
    }

    public Calculate(String questions) throws IOException {
        super(questions);
    }

    //method kalkulaisi jawaban user 
    @Override
    public int[] calculateAns1(String[] answer, Map<String, String> opsiAns,List<List<String>> question) {
        String isValid = "";

        for (int i = 0; i < opsiAns.size(); i++) {
            if (question.get(i).get(i).endsWith("*")) {
                isValid = question.get(i).get(i).replace("*", " ");
                break;
            }
        }
        System.out.println(isValid);
            if (opsiAns.get(answer[0]) == null) {//jik user milih selain opsi abcd
                System.out.println("Wrong the correct answear is " + isValid);
                this.wrong++;
            } else if (opsiAns.get(answer[0]).endsWith("*")) {//jika user memnilih jawaban yang benar
                System.out.println("correct");
                this.correct++;
            } else if (!opsiAns.get(answer[0]).endsWith("*")) {//jika user memilih jawaban yang salah
                System.out.println("Wrong the correct answear is " + isValid);
                this.wrong++;
            }
        return getcorrect();//mengembalikan jumlah jawaban yang benar
    }
    
    //menampilkan pesan jika sudah selesai pertanyaanya
    @Override
    public void mesaagge(int[] result,String name) {
        System.out.println("\n"+"Hi " + name + " you wrong " + result[1] + " and correct " + result[0] + " your graded is " + result[0]*10+"%");
    }

    @Override
    public int[] getcorrect() {
        int[] result = new int[2];
        result[0] = this.correct;
        result[1] = this.wrong;
        return result;
    }

    // for multiple answer
    @Override
    public int[] calculateAns2(String[] answer, Map<String, String> opsiAns) {

        try {
            if (opsiAns.get(answer[0]) == null && opsiAns.get(answer[1]) == null) {
                System.out.println("Wrong");
                this.wrong++;
            } else if (opsiAns.get(answer[0]) == opsiAns.get(answer[1])) {
                System.out.println("wrong");
                this.wrong++;
            } else if (!opsiAns.get(answer[0]).endsWith("*") && !opsiAns.get(answer[1]).endsWith("*")) {
                System.out.println("wrong");
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
