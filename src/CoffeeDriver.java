import java.util.Scanner;
public class CoffeeDriver{
    public static void main(String [] args){
        String response = "dontexit";
        // Create coffee machine object
        CoffeeMachine coffee = new CoffeeMachine();
        do{
            // Create Scanner
            Scanner input = new Scanner(System.in);
            String action;
            System.out.print("What would you like to do (buy, fill, take, remaining, exit): ");
            action = input.next();
            if(action.equalsIgnoreCase("buy")){
                coffee.buyCoffee();
            }
            else if(action.equalsIgnoreCase("fill")){
                coffee.fillMachine();
            }
            else if(action.equalsIgnoreCase("take")){
                coffee.takeMoney();
            }
            else if(action.equalsIgnoreCase("remaining")){
                System.out.println();
                coffee.supplies();
            }
            else if(action.equalsIgnoreCase("exit")){
                response = "exit";
            }
        }while(!response.equalsIgnoreCase("exit"));
    }// end main
}// end class