/**********************************************
 * this programs under development by alliano *
 * ********************************************
 */

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

/**
 * this class for read file csv 
 * and there are some moetods for get questions
 */
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

    //method untuk mengamil pertanyaan dari file csv | method for read file csv 
    private void getQuestion() throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {

            // membaca file csv berdasarkan plihan user(variable this.question) | read csv file based user choose( variable this.question)
            fileReader = new FileReader(path + "/src/Company/questions/" + this.question + ".csv");
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            // show to screen if there arror
            System.out.println("lagi error " + e);
            return;
        }
        // membaca per baris dari buffer reader | read per line of buffer reader 
        String data = bufferedReader.readLine();

        // membaca baris dari variabel data dan jika ketemu koma maka akan di enter | read a line data variable and if find character coma (,) then will enter
        StringTokenizer strToken = new StringTokenizer(data, ",");
        int index = 0;
        while (data != null) {
            strToken = new StringTokenizer(data, ",");
            data = bufferedReader.readLine();
            
            /**
             * retun question ini bernilai array list kosong kosog
             * this return questions is worth an empty array list
             * 
             * disini retunQuestion akan di isi soal berdasarkan index
             * here the returnQuestion will be field with question based on index
             */
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

    

    /**
     * method looping returnArray list berdasarkan banyak baris di file csv
     * this method will loop property returnQuestions and the property
     * returnQuestions will field empty array list
     * 
     * @throws IOException
     */
    public void loopArrList() throws IOException {
        
        // mengambil path lokasi saat ini dari direk tori home system | take the path location now from directory home/system
        Path path = Paths.get(Questions.path + "/src/Company/questions/"+this.question+".csv");

        // mengabil bayak nya baris dari file csv | fetch multiple lines from csv file
        long lines = Files.lines(path).count();
        for (int i = 0; i < lines; i++) {

            // menambahkan array list berdasarkan bnyknya baris di file csv | add the array list in to property retunQuestions 
            this.returnQuestions.add(new ArrayList<>());
        }
     
    }
}
