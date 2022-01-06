package Company.object;
import java.io.BufferedReader;
import java.io.FileReader;

public class Questions {
    private String question;

   public Questions(String questions){
        this.question = questions;
   }
   public void getQuestion(){
       FileReader fileReader;
       BufferedReader bufferedReader;

       try {
           fileReader = new FileReader("Company/question/"+this.question+".txt");
           bufferedReader = new BufferedReader(fileReader);
           System.out.println(bufferedReader.readLine());
       } catch (Exception e) {
           System.out.println("err " + e);
       }

   }
}
