package Company.object;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Components extends Questions{
    private String name;
    private int correct;
    private Scanner terminalInput = new Scanner(System.in);

    public Components() throws Exception {
        super();
    }

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
        System.out.print("\nchoose the module : ");
        String check = terminalInput.nextLine();
        switch (check) {
            case "1":
                System.out.println("\nBasic java");
                Questions pertanyaan = new Questions("Basicjava");
                List<List<String>> data = pertanyaan.getAllquestions();
                loopQustions(data);
            
                break;
            case "2":
                System.out.println("\nOOP java");
                Questions pertanyaan2 = new Questions("OOP-java");
                List<List<String>> data2 = pertanyaan2.getAllquestions();
                loopQustions(data2);
                break;
            case "3":
                System.out.println("typescript");
                Questions pertanyaan3 = new Questions("Typescript");
                List<List<String>> data3 = pertanyaan3.getAllquestions();
                loopQustions(data3);
                break;
            case "4":
                System.out.println("Express with TS");
                Questions pertanyaan4 = new Questions("ExpresTs");
                List<List<String>> data4 = pertanyaan4.getAllquestions();
                loopQustions(data4);
                break;
            default:
                System.out.println("please choose 1 beetwen 4");
                break;
        }
    }

    public void loopQustions(List<List<String>> qusestions) throws IOException {
        Map<String, String> opsiAns = new HashMap<>();
        String[] arrAns = new String[2];
        Calculate calculate = new Calculate("");
        for (int i = 0; i < qusestions.size(); i++) {

            opsiAns.put("a", qusestions.get(i).get(1));
            opsiAns.put("b", qusestions.get(i).get(2));
            opsiAns.put("c", qusestions.get(i).get(3));
            opsiAns.put("d", qusestions.get(i).get(4));

            System.out.println("\n");
            System.out.println(qusestions.get(i).get(0).endsWith("*") ? qusestions.get(i).get(0).replace("*", " ")
                    : qusestions.get(i).get(0));
            System.out.println(qusestions.get(i).get(1).endsWith("*") ? qusestions.get(i).get(1).replace("*", " ")
                    : qusestions.get(i).get(1));
            System.out.println(qusestions.get(i).get(2).endsWith("*") ? qusestions.get(i).get(2).replace("*", " ")
                    : qusestions.get(i).get(2));
            System.out.println(qusestions.get(i).get(3).endsWith("*") ? qusestions.get(i).get(3).replace("*", " ")
                    : qusestions.get(i).get(3));
            System.out.println(qusestions.get(i).get(4).endsWith("*") ? qusestions.get(i).get(4).replace("*", " ")
                    : qusestions.get(i).get(4) + "\n");

            System.out.print("answer : ");
            String answer = terminalInput.nextLine();
            System.out.print("answer : ");
            String answer2 = terminalInput.nextLine();
            arrAns[0] = answer;
            arrAns[1] = answer2;
            this.correct = calculate.calculateAns(arrAns, opsiAns);
        }
        calculate.mesaagge(this.correct);
    }

}
