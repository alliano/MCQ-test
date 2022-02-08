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

    //overide constructor Question
    public Questions(){
        this.question = "Basicjava";
    }

    //constructor Questios
    public Questions(String questions) throws IOException {
        this.question = questions;
        this.returnQuestions = new ArrayList<>();
        loopArrList();
    }

    //method untuk mengamil pertanyaan dari file csv
    private void getQuestion() throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(path + "/src/Company/questions/" + this.question + ".csv");//membaca file csv berdasarkan plihan user(variable this.question)
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            System.out.println("lagi error " + e);
            return;
        }
        String data = bufferedReader.readLine();//membaca per baris dari buffer reader
        StringTokenizer strToken = new StringTokenizer(data, ",");//membaca baris dari variabel data dan jika ketemu koma maka akan di enter
        int index = 0;
        while (data != null) {
            strToken = new StringTokenizer(data, ",");
            data = bufferedReader.readLine();
            //retun question ini bernilai array list kosong kosog 
            //disini retunQuestion akan di soal berdasarkan index
            this.returnQuestions.get(index).add(strToken.nextToken());
            this.returnQuestions.get(index).add(strToken.nextToken());
            this.returnQuestions.get(index).add(strToken.nextToken());
            this.returnQuestions.get(index).add(strToken.nextToken());
            this.returnQuestions.get(index).add(strToken.nextToken());
            index++;
        }
        // close buffer
        bufferedReader.close();
    }

    public List<List<String>> getAllquestions()throws IOException {
        getQuestion();
        return this.returnQuestions;
    }

    //me looping returnArray list berdasarkan banyak baris di file csv
    public void loopArrList() throws IOException {
        
        Path path = Paths.get(Questions.path + "/src/Company/questions/"+this.question+".csv");//mengambil path lokasi saat ini dari direk tori home system

        long lines = Files.lines(path).count();//mengabil bayak nya baris dari file csv
        for (int i = 0; i < lines; i++) {
            this.returnQuestions.add(new ArrayList<>());//menambahkan array list berdasarkan bnyknya baris di file csv
        }
     
    }
}
