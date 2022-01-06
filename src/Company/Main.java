package Company;
import Company.object.Questions;

import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static Scanner terminalInput = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.print("\ninput your name : ");
        String name = terminalInput.nextLine();
        System.out.println("\nwelcome " + name+"\n");
        System.out.println("***List Module***\n");

        System.out.println("1)Basic java");
        System.out.println("2)OOP java");
        System.out.println("3)typescript");
        System.out.println("4)Express with TS");


        System.err.print("\nChoose module : ");
        String check = terminalInput.nextLine();

       switch (check) {
           case "1":
               System.out.println("Basic java");
               Questions pertanyaan = new Questions("ExpresTs");
               pertanyaan.getQuestion();
               break;
           case "2":
               System.out.println("OOP java");
               break;
           case "3":
               System.out.println("typescript");
               break;
           case "4":
               System.out.println("Express with TS");
               break;
           default:
                System.out.println("please choose 1 beetwen 4");
               break;
       }
                // isnext = userChooseWrong("pelase choose betwen 1 until 4");
       }
    //  public static boolean userChooseWrong(String message){
    //      System.out.println(message);
    //      String inputUser = terminalInput.nextLine();
    //      while(inputUser != "1" || inputUser != "2" || inputUser != "3" || inputUser != "4"){
    //         System.out.println(message);
    //         inputUser = terminalInput.nextLine(); 
    //      }
    //      return true;
    //  }
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