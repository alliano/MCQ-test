package Company.object;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Questions {
    private String question;
    private List<List<String>> returnQuestions;
    private static String path = System.getProperty("user.dir");

    public Questions(String questions) {
        this.question = questions;
        this.returnQuestions = new ArrayList<>();
        data(this.returnQuestions);
    }

    public void getQuestion() throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(path + "/src/Company/questions/" + this.question + ".csv");
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            System.out.println("lagi error " + e);
            return;
        }
        String data = bufferedReader.readLine();
        StringTokenizer strToken = new StringTokenizer(data, ",");

        while (data != null) {
            System.out.println(strToken.nextToken());
            System.out.println(strToken.nextToken());
            System.out.println(strToken.nextToken());
            System.out.println(strToken.nextToken());


            strToken = new StringTokenizer(data, ",");
            data = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
    public void data(List<List<String>> questions) {
        for (int i = 0; i <= 10; i++) {
            this.returnQuestions.add(new ArrayList<>());
        }
    }
}
