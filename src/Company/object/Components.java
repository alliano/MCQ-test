package Company.object;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Components extends Questions {
    private String name;
    private Scanner terminalInput = new Scanner(System.in);
    public Components(String questions) throws IOException {
        super(questions);
    }

    public void listModule() {
        System.out.println("\nwelcome " + getName() + "\n");
        System.out.println("***List Module***\n");
        System.out.println("1)Basic java");
        System.out.println("2)OOP java");
        System.out.println("3)typescript");
        System.out.println("4)Express with TS");
    }

    public void setName() {
        System.out.print("\ninput your name : ");
        String name = terminalInput.nextLine();
        this.name = name;
    }

    private String getName() {
        return this.name;
    }

    public void switchChoose() throws IOException {
        System.out.print("choose the module : ");
        String check = terminalInput.nextLine();
        switch (check) {
            case "1":
                System.out.println("Basic java");
                Questions pertanyaan = new Questions("Basicjava");
                List<List<String>> data = pertanyaan.getAllquestions();
                loopQustions(data);
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
    }

    public void loopQustions(List<List<String>> qusestions) throws IOException {
        for (int i = 0; i < qusestions.size(); i++) {
            System.out.println("\n");
            System.out.println(qusestions.get(i).get(0).endsWith("*") ? qusestions.get(i).get(0).replace("*", " ") : qusestions.get(i).get(0));
            System.out.println(qusestions.get(i).get(1).endsWith("*") ? qusestions.get(i).get(1).replace("*", " ") : qusestions.get(i).get(1));
            System.out.println(qusestions.get(i).get(2).endsWith("*") ? qusestions.get(i).get(2).replace("*", " ") : qusestions.get(i).get(2));
            System.out.println(qusestions.get(i).get(3).endsWith("*") ? qusestions.get(i).get(3).replace("*", " ") : qusestions.get(i).get(3));
            System.out.println(qusestions.get(i).get(4).endsWith("*") ? qusestions.get(i).get(4).replace("*", " ") : qusestions.get(i).get(4)+"\n");
            System.out.print("answer : ");
            String answer = terminalInput.nextLine();
            calculate(answer,qusestions);
            
        }
    }
    
    private void calculate(String answer, List<List<String>> questions) {
        int correct;
        
        for (int i = 1; i < 4; i++) {
            switch (answer) {
                case "a":
                    if (questions.get(i).get(1).endsWith("*")) {
                        System.out.println("correct");
                        System.out.println(questions.get(i).get(1));
                        correct = +1;
                    } else {
                        System.out.println("Wrong");
                    }
                    break;
                case "b":
                    if (questions.get(i).get(2).endsWith("*")) {
                        System.out.println(questions.get(i).get(2));
                        System.out.println("correct");
                        correct = +1;
                    } else {
                        System.out.println("Wrong");
                    }
                    break;
                case "c":
                    if (questions.get(i).get(3).endsWith("*")) {
                        System.out.println(questions.get(i).get(3));
                        System.out.println("correct");
                        correct = +1;
                    } else {
                        System.out.println("Wrong");
                    }
                    break;
                case "d":
                    if (questions.get(i).get(4).endsWith("*")) {
                        System.out.println("correct");
                        System.out.println(questions.get(i).get(4));
                        correct = +1;
                    } else {
                        System.out.println("Wrong");
                    }
                    break;

                default:
                    System.out.println("wrong u are type else abcd");
                    break;
                }
            }
    }
   

}
