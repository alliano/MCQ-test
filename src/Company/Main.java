package Company;
import Company.object.Components;
import java.io.IOException;

public class Main extends Components{
  
    public Main(String questions) throws IOException {
        super(questions);
    }
    public static void main(String[] args) throws IOException {
        Components components = new Components("");
        components.setName();
        components.listModule();
        components.switchChoose();
       
      
    }
    public static void clearSc(){
        try{
            if (System.getProperty("os.name").contains("windows")) {
               new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor(); 
            }else{
                System.out.println("\033\143");
            }
        }catch(Exception errException){
            System.out.println(errException);
        }
    }
}