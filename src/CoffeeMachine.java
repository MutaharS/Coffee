import java.util.Scanner;
import java.text.DecimalFormat;
public class CoffeeMachine {
    //  Supply of ingredients/materials in Coffee Machine
    private int waterSupply;    // mL
    private int milkSupply;     // mL
    private int beanSupply;     // grams
    private int disposableCups; // Number of disposable cups
    private double money;       // Amount of money in machine

    // Default Constructor with starting supply
    CoffeeMachine(){
        this.waterSupply = 1200;
        this.milkSupply = 540;
        this.beanSupply = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    // Buy coffee method
    public void buyCoffee(){
        Scanner input = new Scanner(System.in);
        String user;
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - main menu: ");
        user = input.next();

        // For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
        // For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
        // And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee.
        // It costs $6.
        if(user.equals("1")){
            if(!enoughSupply("espresso")){
                return;
            }
            System.out.println("\nStarting to make Espresso!");
            this.waterSupply -= 250;
            this.beanSupply -= 16;
            this.disposableCups -= 1;
            this.money += 4;
        }
        else if(user.equals("2")){
            if(!enoughSupply("latte")){
                return;
            }
            System.out.println("\nStarting to make Latte!");
            this.waterSupply -= 350;
            this.milkSupply -= 75;
            this.beanSupply -= 20;
            this.disposableCups -= 1;
            this.money += 7;
        }
        else if(user.equals("3")){
            if(!enoughSupply("cappuccino")){
                return;
            }
            System.out.println("\nStarting to make Cappuccino!");
            this.waterSupply -= 200;
            this.milkSupply -= 100;
            this.beanSupply -= 12;
            this.disposableCups -= 1;
            this.money += 6;
        }
        else if(user.equalsIgnoreCase("back")){
            System.out.println();
            return;
        }

        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        if(!user.equals("1")){
            System.out.println("Pouring some milk into the cup");
        }
        System.out.println("Coffee is ready!\n");
    }// end buy method

    // Fill machine method
    public void fillMachine(){
        Scanner input = new Scanner(System.in);
        int temp;

        System.out.print("Write how many ml of water do you want to add: ");
        temp = input.nextInt();
        while(temp < 0){
            System.out.print("Write how many ml of water do you want to add: ");
            temp = input.nextInt();
        }
        this.waterSupply += temp;

        System.out.print("Write how many ml of milk do you want to add: ");
        temp = input.nextInt();
        while(temp < 0){
            System.out.print("Write how many ml of milk do you want to add: ");
            temp = input.nextInt();
        }
        this.milkSupply += temp;

        System.out.print("Write how many grams of coffee beans do you want to add: ");
        temp = input.nextInt();
        while(temp < 0){
            System.out.print("Write how many grams of coffee beans do you want to add: ");
            temp = input.nextInt();
        }
        this.beanSupply += temp;

        System.out.print("Write how many disposable cups do you want to add: ");
        temp = input.nextInt();
        while(temp < 0){
            System.out.print("Write how many disposable cups do you want to add: ");
            temp = input.nextInt();
        }
        this.disposableCups += temp;
        input.nextLine();   // .nextInt() leaves behind new line character, this is to "catch" it
        System.out.println();
    }// end fill method

    // Take money method
    public void takeMoney(){
        DecimalFormat fmt = new DecimalFormat("#.00");
        System.out.println("$" + fmt.format(this.money) + " has been withdrawn from coffee maker.\n");
        this.money = 0;
    }

    public void supplies(){
        DecimalFormat fmt = new DecimalFormat("0.00");
        System.out.println("The coffee machine currently has:");
        System.out.println(this.waterSupply + " mL of water.");
        System.out.println(this.milkSupply + " mL of milk.");
        System.out.println(this.beanSupply + " grams of beans.");
        System.out.println(this.disposableCups + " disposable cups.");
        System.out.println(fmt.format(this.money) + " dollars\n");
    }

    //  Private functions
    //  Supply check will return false if we dont have enough supplies to make that coffee

    private boolean enoughSupply(String coffeeType){
        boolean bool = true;
        if(coffeeType.equalsIgnoreCase("espresso")){
            if(this.waterSupply < 250){
                System.out.println("Sorry, not enough water!\n");
                bool = false;
            }
            else if(this.beanSupply < 16){
                System.out.println("Sorry, not enough coffee beans!\n");
                bool = false;
            }
            else if(this.disposableCups < 1){
                System.out.println("Sorry, no disposable cups left!\n");
                bool = false;
            }
        }

        if(coffeeType.equalsIgnoreCase("latte")){
            if(this.waterSupply < 350){
                System.out.println("Sorry, not enough water!\n");
                bool = false;
            }
            else if(this.milkSupply < 75){
                System.out.println("Sorry, not enough milk!\n");
                bool = false;
            }
            else if(this.beanSupply < 20){
                System.out.println("Sorry, not enough coffee beans!\n");
                bool = false;
            }
            else if(this.disposableCups < 1){
                System.out.println("Sorry, no disposable cups left!\n");
                bool = false;
            }
        }

        if(coffeeType.equalsIgnoreCase("cappuccino")){
            if(this.waterSupply < 200){
                System.out.println("Sorry, not enough water!\n");
                bool = false;
            }
            else if(this.milkSupply < 100){
                System.out.println("Sorry, not enough milk!\n");
                bool = false;
            }
            else if(this.beanSupply < 12){
                System.out.println("Sorry, not enough coffee beans!\n");
                bool = false;
            }
            else if(this.disposableCups < 1){
                System.out.println("Sorry, no disposable cups left!\n");
                bool = false;
            }
        }
        return bool;
    }//end method
}// end class
