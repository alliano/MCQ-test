/**********************************************
 * this programs under development by alliano *
 * ********************************************
 */
package Company;
import Company.object.Components;
import java.io.IOException;

/**
 * main method 
 * the programs will runn form here
 */
public class Main extends Components{
    /**
     * this is constructor of Main(core of program) class
     * @param questions
     * @throws IOException
     */
    public Main(String questions) throws IOException {
        super(questions);
    }

    /**
     * this is main method all programs will start from here
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Components components = new Components();
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