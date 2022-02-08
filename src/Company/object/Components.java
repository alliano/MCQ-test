package Company.object;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Components extends Questions{
    private String name;
    private int[] correct;
    private Scanner terminalInput = new Scanner(System.in);

    public Components() throws Exception {
        super();
    }

    public Components(String questions) throws IOException {
        super(questions);
    }

    //menampikan list module
    public void listModule() {
        System.out.println("\nwelcome " + getName() + "\n");
        System.out.println("***List Module***\n");
        System.out.println("1)Basic java");
        System.out.println("2)typescript");
    }
    //mengambil nama-
    public void setName() {
        System.out.print("\ninput your name : ");
        String name = terminalInput.nextLine();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //mengambil module bersasarkan pilihan user
    public void switchChoose() throws IOException,Exception {
        System.out.print("\nchoose the module : ");
        String check = terminalInput.nextLine();
        switch (check) {
            case "1":
                System.out.println("\nBasic java");
                Questions pertanyaan = new Questions("Basicjava");
                List<List<String>> data = pertanyaan.getAllquestions();//megambil pertanyaan bedasarkan pilihan user
                loopQustions(data);//karna pertnayanya berbentuk array list maka pertannan akan di looping sebelum di tampilkan ke layar
                break;
            case "2":
                System.out.println("typescript");
                Questions pertanyaan3 = new Questions("Typescript");
                List<List<String>> data3 = pertanyaan3.getAllquestions();
                loopQustions(data3);
                break;
            default:
                System.out.println("please choose 1 beetwen 4");
                break;
        }
    }

    public void loopQustions(List<List<String>> qusestions) throws IOException,Exception {
        Map<String, String> opsiAns = new HashMap<>();//membuat array asosiatf kek di php Exp: $data = ["nama" => "alliano"] klo di PHP
        String[] arrAns1 = new String[1];
        String[] arrAns2 = new String[2];
        Calculate calculate = new Calculate();//instance object calculate | nanti ini akan digunaka untuk meng kalkulasi hasil dari user
        for (int i = 0; i < qusestions.size(); i++) {

            //mengambil oipsi dari soal dan si sinmpan di dalam variable opsiAns
            opsiAns.put("a", qusestions.get(i).get(1));
            opsiAns.put("b", qusestions.get(i).get(2));
            opsiAns.put("c", qusestions.get(i).get(3));
            opsiAns.put("d", qusestions.get(i).get(4));



            System.out.println("\n");
            // menampilkan opsi ke layar tap jika opsi itu mengandung * di akhir kata maka * akan di replace dengan string kosong
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



            if (i < 5) {
                System.out.print("answer : ");
                String answer = terminalInput.nextLine();
                arrAns1[0] = answer;//jwaban user akan di masukan ke dalam arrAns1
                this.correct = calculate.calculateAns1(arrAns1, opsiAns);//ini akan mengembalikan array 
            } else {
                //ini untuk multiple answer
                System.out.println("-------------------------------");
                System.out.println("---this is multiple answear ---");
                System.out.println("-------------------------------");
                System.out.print("answer : ");
                String answer = terminalInput.nextLine();
                System.out.print("answer : ");
                String answer2 = terminalInput.nextLine();
                arrAns2[0] = answer;
                arrAns2[1] = answer2;
                this.correct = calculate.calculateAns2(arrAns2, opsiAns);
                        
                    }

        }
        calculate.mesaagge(this.correct,this.name);
    }

}
