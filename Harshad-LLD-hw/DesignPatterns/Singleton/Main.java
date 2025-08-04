import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Enter to input the menu: ");
        String message = scanner.nextLine(); 
        
        if (message.equalsIgnoreCase("Burger")){
            log1.log("Burger Created");
            log1.log("Fries Added");
        }


        Logger log2 = Logger.getInstance();


        System.out.print("Enter to add drinks and Tacos : ");
        String msg2 = scanner.nextLine();
        if (msg2.equalsIgnoreCase("tacos")) {
            log2.log("Drink Added");
        }

        System.out.print("Enter to see the order: ");
        String message1 = scanner.nextLine(); 
    
        if (message1.equalsIgnoreCase("order")) {        
        LogPrinter pri1 = new LogPrinter();
        pri1.printLog(log1.getLogs());}

//        LogPrinter pri2 = new LogPrinter();    

//        pri2.printLog(log2.getLogs());
    }
    
}