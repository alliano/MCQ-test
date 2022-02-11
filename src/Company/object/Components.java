/**********************************************
 * this programs under development by alliano *
 * ********************************************
 */


package Company.object;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/****************************************
 * this class extends class Questions   *
 *                                      *
 * it's mean the Components class       *
 * can use property and ,method that    *
 * there in paren class (Questions)     *
 ****************************************/

public class Components extends Questions {
    /**
     * this is example for encapsulation or access modifier
     * 
     * privat -> it's mean the property or method just can use in class child class can not use 
     * if child class want to use then need method seter geter
     *  
     * protected -> it's mean this property or method can be use in this class and 
     * child class  
     * 
     * public -> it's mean this property or method can use by all class
     */
    private String name;
    private int[] correct;
    private Scanner terminalInput = new Scanner(System.in);

    /**
     * this is overide constructor
     * @throws Exception
     */
    public Components() throws Exception {
        super();
    }

    public Components(String questions) throws IOException {
        super(questions);
    }

    /**
     * menampikan list module | show list of modules
     */
    public void listModule() {
        System.out.println("\nwelcome " + getName() + "\n");
        System.out.println("***List Module***\n");
        System.out.println("1)Basic java");
        System.out.println("2)typescript");
    }
    
    /**
     * mengambil nama | take name of user
     */
    public void setName() {

        System.out.print("\nEnter your Name : ");
        // String abz = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String name = terminalInput.nextLine();
        this.name = name;
    }

    // get name user
    public String getName() {
        return this.name;
    }

    /**
     * method for take user's choose
     * mengambil module bersasarkan pilihan user | take the module based user's choose
     * 
     * @throws IOException
     * @throws Exception
     */
    public void switchChoose() throws IOException, Exception {
        boolean istrue = true;
        while (istrue) {
            System.out.print("\nchoose the module : ");
            String check = terminalInput.nextLine();
            switch (check) {
                case "1":
                    istrue = false;
                    System.out.println("\n***************");
                    System.out.println("***Basic java****");
                    System.out.println("***************");
                    Questions pertanyaan = new Questions("Basicjava");
                    
                    // megambil pertanyaan bedasarkan pilihan user | take the questions based user's choose
                    List<List<String>> data = pertanyaan.getAllquestions();


                    // karna pertnayanya berbentuk array list maka pertannan akan di looping sebelum ditampil kan ke layar | cause the questions is array list then the questions will looping before show to screen
                    loopQustions(data);
                    break;
                case "2":
                    istrue = false;
                    System.out.println("typescript");
                    Questions pertanyaan3 = new Questions("Typescript");
                    List<List<String>> data3 = pertanyaan3.getAllquestions();
                    loopQustions(data3);
                    break;
                default:
                    istrue = true;
                    System.out.println("please choose 1 beetwen 2 (basic java or typescript)");
                    break;
            }
        }
        
        
    } 

    /**
     * this method will loop question until the questons empty
     * @param qusestions
     * @throws IOException
     * @throws Exception
     */
    public void loopQustions(List<List<String>> qusestions) throws IOException, Exception {

        //membuat array asosiatf kek di php Exp: $data = ["nama" => "alliano"] klo di PHP
        Map<String, String> opsiAns = new HashMap<>();
        String[] arrAns1 = new String[1];
        String[] arrAns2 = new String[2];

        // instance object calculate | nanti ini akan digunaka untuk meng kalkulasi hasil dari user hasil dari user
        Calculate calculate = new Calculate();
        for (int i = 0; i < qusestions.size(); i++) {

            //mengambil oipsi dari soal dan sinmpan di dalam variable opsiAns | take options of questions and save in to opsiAns variable
            opsiAns.put("a", qusestions.get(i).get(1));
            opsiAns.put("b", qusestions.get(i).get(2));
            opsiAns.put("c", qusestions.get(i).get(3));
            opsiAns.put("d", qusestions.get(i).get(4));

            System.out.println("\n");

            // menampilkan opsi ke layar tap jika opsi itu mengandung * di akhir kata maka * akan di replace dengan string kosong | show options to screen but if the answears contain * then the caracter * will replace with empty string
            System.out.println(qusestions.get(i).get(0).endsWith("*") ? qusestions.get(i).get(0).replace("*", " ") : qusestions.get(i).get(0));
            System.out.println(qusestions.get(i).get(1).endsWith("*") ? qusestions.get(i).get(1).replace("*", " ") : qusestions.get(i).get(1));
            System.out.println(qusestions.get(i).get(2).endsWith("*") ? qusestions.get(i).get(2).replace("*", " ") : qusestions.get(i).get(2));
            System.out.println(qusestions.get(i).get(3).endsWith("*") ? qusestions.get(i).get(3).replace("*", " ") : qusestions.get(i).get(3));
            System.out.println(qusestions.get(i).get(4).endsWith("*") ? qusestions.get(i).get(4).replace("*", " ") : qusestions.get(i).get(4) + "\n");

            if (i < 5) {
                System.out.print("answer : ");
                String answer = terminalInput.nextLine();

                // this loop will run if user choose the options which not available
                while (isInclude(answer, "a", "b", "c", "d")) {
                    System.out.println("\nyour choose is not available in our options please choose a,b,c,d\n");
                    System.out.print("answer : ");
                    answer = terminalInput.nextLine();
                }
                // jwaban user akan di masukan ke dalam arrAns1 | user answear will entered into variable arrAns1 with index 0
                arrAns1[0] = answer;

                // ini akan mengembalikan array | this will return array 
                this.correct = calculate.calculateAns1(arrAns1, opsiAns);
            } else {
                //ini untuk multiple answer
                System.out.println("-------------------------------");
                System.out.println("---this is multiple answear ---");
                System.out.println("-------------------------------");
                System.out.print("answer : ");
                String answer = terminalInput.nextLine();
                System.out.print("answer : ");
                String answer2 = terminalInput.nextLine();
                String ans[] = new String[2];
                ans[0] = answer;
                ans[1] = answer2;

                // thuis loop will run if user pick the options which not available
                while (isInclude(ans, "a", "b", "c", "d")) {
                    System.out.println("\nyour choose is not available in our options please choose a,b,c,d\n");
                    System.out.print("answer : ");
                    answer = terminalInput.nextLine();
                    System.out.print("answer : ");
                    answer2 = terminalInput.nextLine();
                    ans[0] = answer;
                    ans[1] = answer2;
                }
                arrAns2[0] = answer;
                arrAns2[1] = answer2;
                this.correct = calculate.calculateAns2(arrAns2, opsiAns);
            }

        }
        calculate.mesaagge(this.correct, this.name);
    }
    
    /**
     * this is polimorpisem 
     * this method for check user answear available in our options or not
     * if user choose the options which not available then this method will retun value true(for run the loop)
     * is user choose the options available then this method will return false(for stop the loop)
     * @param input
     * @param rest
     * @return
     */
    private static boolean isInclude(String input, String... rest) {
        for (String value : rest) {
            if (Character.toString(input.charAt(0)).equalsIgnoreCase(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * this is polimorpisem
     * this method for check user answear available in our options or not
     * if user choose the options which not available then this method will retun value true(for run the loop)
     * is user choose the options available then this method will return false(for stop the loop)
     * @param input
     * @param rest
     * @return
     */
    private static boolean isInclude(String[] input, String... rest) {
        for (String value : rest) {
            if (input[0].equalsIgnoreCase(value) || input[1].equalsIgnoreCase(value)){
                return false;
            }
        }
        return true;
    }

}
