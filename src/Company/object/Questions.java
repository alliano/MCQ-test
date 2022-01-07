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

    private void getQuestion() throws IOException {
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
        int index = 0;
        while (data != null) {
            strToken = new StringTokenizer(data, ",");
            data = bufferedReader.readLine();
            this.returnQuestions.get(index).add(strToken.nextToken());
            this.returnQuestions.get(index).add(strToken.nextToken());
            this.returnQuestions.get(index).add(strToken.nextToken());
            this.returnQuestions.get(index).add(strToken.nextToken());
            index++;
        }
        bufferedReader.close();
    }

    public List<List<String>> getAllquestions()throws IOException {
        getQuestion();
        return this.returnQuestions;
    }
    public void data(List<List<String>> questions) {
        for (int i = 0; i <= 10; i++) {
            this.returnQuestions.add(new ArrayList<>());
        }
    }
}
