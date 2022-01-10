package Company.object;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Questions {
    private String question;
    private List<List<String>> returnQuestions;
    private static String path = System.getProperty("user.dir");

    public Questions(){
        this.question = "Basicjava";
    }

    public Questions(String questions) throws IOException {
        this.question = questions;
        this.returnQuestions = new ArrayList<>();
        loopArrList();
    }

    private void getQuestion() throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader;
        System.out.println(path);
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
            this.returnQuestions.get(index).add(strToken.nextToken());
            index++;
        }
        bufferedReader.close();
    }

    public List<List<String>> getAllquestions()throws IOException {
        getQuestion();
        return this.returnQuestions;
    }

    public void loopArrList() throws IOException {
        
        Path path = Paths.get(Questions.path + "/src/Company/questions/"+this.question+".csv");

        long lines = Files.lines(path).count();
        for (int i = 0; i < lines; i++) {
            this.returnQuestions.add(new ArrayList<>());
        }
     
        // System.out.println(File.lines(path).count());

        // long lines = Files.lines(path).count();
        // for (int i = 0; i < lines; i++) {
        //     this.returnQuestions.add(new ArrayList<>());
        // }
        // FileReader fileReader;
        // BufferedReader bufferedReader;
        // try {
        //     fileReader = new FileReader(path + "/src/Company/questions/" + this.question + ".csv");
        //     bufferedReader = new BufferedReader(fileReader);
        // } catch (Exception e) {
        //     System.err.println("lagi error mas :v " + e);
        //     return;
        // }
        // String data = bufferedReader.readLine();
        // while (data != null) {
        //     data = bufferedReader.readLine();
        //     this.returnQuestions.add(new ArrayList<>());
        // }
        // bufferedReader.close();
    }
}
