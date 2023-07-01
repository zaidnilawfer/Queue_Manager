import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean isRunning = true;
        Customer customer= new Customer();
        FoodQueue foodQueue=new FoodQueue(customer);
        while (isRunning) {
            System.out.println("""
                    \n
                    100 or VFQ: View all Queues
                    101 or VEQ: View all Empty Queues.
                    102 or ACQ: Add customer to a Queue.
                    103 or RCQ: Remove a customer from a Queue.
                    104 or PCQ: Remove a served customer.
                    105 or VCS: View Customers Sorted .
                    106 or SPD: Store Program Data into file.
                    107 or LPD: Load Program Data from file.
                    108 or STK: View Remaining burgers Stock.
                    109 or AFS: Add burgers to Stock.
                    999 or EXT: Exit the Program.""");
            System.out.println("\nEnter an option from above. \n");
            String action = scanner.next();
            switch (action) {
                case "100", "VQF" ->customer.printAllQueues(foodQueue);
                case "101", "VEQ" ->customer.printAllEmptyQueues();
                case "102", "ACQ" -> customer.addCustomer(foodQueue);
                case "103", "RCQ" -> customer.removeASpecificCustomer(foodQueue);
                case "104", "PCQ" -> customer.removeAServedCustomer(foodQueue);
                case "105", "VCS" -> customer.sortMethod();
                case "106", "SPD" -> customer.storeData(foodQueue);
                case "107", "LPD" -> customer.readData();
                case "108", "STK" -> System.out.println("\n"+foodQueue.BurgersAvailable());
                case "109", "AFS" -> foodQueue.addBurgersTosStock();
                case "110","IFQ"  -> foodQueue.BurgerIncome();
                case "999", "EXT" -> isRunning = false;
                default -> System.out.println("enter a valid action");
            }
        }
    }
}