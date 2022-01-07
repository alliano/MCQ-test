package Company.object;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Components extends Questions {
    public Components(String questions) {
        super(questions);
    }

    protected String name;
    private Scanner terminalInput = new Scanner(System.in);
    
    public void listModule() {
        System.out.println("\nwelcome " + this.name + "\n");
        System.out.println("***List Module***\n");
        System.out.println("1)Basic java");
        System.out.println("2)OOP java");
        System.out.println("3)typescript");
        System.out.println("4)Express with TS");
    }

    public void getName() {
        System.out.print("\ninput your name : ");
        String name = terminalInput.nextLine();
        this.name = name;
    }

    public void switchChoose() throws IOException {
        System.out.print("choose the module : ");
        String check = terminalInput.nextLine();
        switch (check) {
            case "1":
                System.out.println("Basic java");
                Questions pertanyaan = new Questions("ExpresTs");
                List<List<String>> data = pertanyaan.getAllquestions();
                System.out.println(data);
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
    
    
}
