import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Customer {
    Scanner scanner= new Scanner(System.in);
    FoodQueue foodQueue;
    public static LinkedList<String> queue1 = new LinkedList<>();
    public static LinkedList<String> queue2 = new LinkedList<>();
    public static LinkedList<String> queue3 = new LinkedList<>();
    static File file;

    private Customer[] customers;
    private int front;
    private int rear;
    private int size;
    public Customer() {
    }
    public void printAllQueues() {
        System.out.println();
        System.out.println("*".repeat(16) + "\n" + "*   cashiers   *" + "\n" + "*".repeat(16));
        System.out.println("  1    2    3 \n");
        for (int i = 0; i <= 5; i++) {
            try {if (i < 2 && queue1.get(i) != null) System.out.print("  " + "O" + " ");}
            catch (IndexOutOfBoundsException e) {System.out.print("  " + "X" + " ");}
            try {
                if (i < 3 && queue2.get(i) != null) {
                    if (i < 2) System.out.print("   " + "O" + "   ");
                    else System.out.print("       " + "O" + "   ");
                }
            } catch (IndexOutOfBoundsException e) {
                if (i < 2) System.out.print("   " + "X" + "   ");
                else System.out.print("       " + "X" + "   ");
            }
            try {
                if (i < 5 && queue3.get(i) != null) {
                    if (i >= 3) System.out.print("            " + "O" + " ");
                    else System.out.print(" " + "O" + " ");
                }
            } catch (IndexOutOfBoundsException e) {
                if (i >= 3) System.out.print("            " + "X" + " ");
                else System.out.print(" " + "X" + " ");
            }
            System.out.println();
        }
    }

    public void printAllEmptyQueues(){
        System.out.println();
        System.out.println("*".repeat(16) + "\n" + "*   cashiers   *" + "\n" + "*".repeat(16));
        System.out.println("  1    2    3 \n");
        for (int i = 0; i <= 5; i++) {
            try {
                if (i < 2 && queue1.size()==2)System.out.print("    ");
                else if (i < 2 && queue1.get(i) != null) {
                    System.out.print("  " + "O" + " ");
                }
            } catch (IndexOutOfBoundsException e) {System.out.print("  " + "X" + " ");}
            try {
                if (i<2 && queue2.size()==3) System.out.print("       ");
                else if (i==2 && queue2.size()==3) System.out.print("           ");
                else if (i < 3 && queue2.get(i) != null) {
                    if (i < 2) System.out.print("   " + "O" + "   ");
                    else System.out.print("       " + "O" + "   ");
                }
            } catch (IndexOutOfBoundsException e) {
                if (i < 2) System.out.print("   " + "X" + "   ");
                else System.out.print("       " + "X" + "   ");
            }
            try {
                if (i<3&&queue3.size()==5) System.out.print("   ");
                else if (i>2 && queue3.size()==5) System.out.print(" ");
                else if (i < 5 && queue3.get(i) != null) {
                    if (i >= 3) System.out.print("            " + "O" + " ");
                    else System.out.print(" " + "O" + " ");
                }
            } catch (IndexOutOfBoundsException e) {
                if (i >= 3) System.out.print("            " + "X" + " ");
                else System.out.print(" " + "X" + " ");
            }
            System.out.println();
        }
    }
    public void addCustomer(FoodQueue foodQueue){
        if (foodQueue.BurgersAvailable()>=11){
            System.out.println("Enter your first name");
            String firstName=scanner.next();
            System.out.println("Enter your second name");
            String secondName=scanner.next();
            System.out.println("How many Burgers needed ?");
            int numOfBurgers =scanner.nextInt();
            if (queue1.size()<2){
                queue1.add(firstName+" "+secondName);
                foodQueue.setQueueBurgers(numOfBurgers,1);
                foodQueue.StockReducer(numOfBurgers);
            } else if (queue2.size()<3) {
                queue2.add(firstName+" "+secondName);
                foodQueue.setQueueBurgers(numOfBurgers,2);
                foodQueue.StockReducer(numOfBurgers);
            } else if (queue3.size()<5) {
                queue3.add(firstName+" "+secondName);
                foodQueue.setQueueBurgers(numOfBurgers,3);
                foodQueue.StockReducer(numOfBurgers);
            }else System.out.println("Queues are full.");
        }else {
            System.out.println("insufficient burgers to place an order please add burgers to stock.");
        }

    }
    public void removingCustomer(int queueNum,int position){
        if (queueNum==1)queue1.remove(position);
        else if (queueNum==2)queue2.remove(position);
        else if (queueNum ==3) queue3.remove(position);
    }
    public void removeAServedCustomer(FoodQueue foodQueue){
        try {
            System.out.println("\n Enter the Queue number :");
            int queueNum = scanner.nextInt();
            if (queueNum<4){
                removingCustomer(queueNum,0);
                foodQueue.removeQueueBurgers(0,1);
            }
        }catch (InputMismatchException e){System.out.println("Enter a valid Queue.");}
    }
    public void removeASpecificCustomer(FoodQueue foodQueue){
            try{
                System.out.println("\nEnter the Queue number :");
                int queueNum= scanner.nextInt();
                System.out.println("\nEnter position number :");
                int position=scanner.nextInt();
                if (queueNum<4){
                    removingCustomer(queueNum,position-1);
                    foodQueue.removeQueueBurgers(position-1,queueNum);
                }if (queueNum>3)System.out.println("No such Queue");
            }catch (InputMismatchException e){
                System.out.println("\nEnter a valid Queue number and position.");
                scanner.nextLine();
            }catch (IndexOutOfBoundsException e){
                System.out.println("\nNo customers at this position.");
                scanner.nextLine();
            }
    }
    public void sortMethod(){
        LinkedList<String> allCustomer = new LinkedList<>();
        allCustomer.addAll(queue1);
        allCustomer.addAll(queue2);
        allCustomer.addAll(queue3);
        for (int i = 0; i < allCustomer.size(); i++) {
            for (int j = i + 1; j < allCustomer.size(); j++) {
                if (allCustomer.get(i).compareToIgnoreCase(allCustomer.get(j)) > 0) {
                    String temp = allCustomer.get(i);
                    String set  = allCustomer.get(j);
                    allCustomer.set(i,set);
                    allCustomer.set(j,temp);
                }
            }
        }
        System.out.println();
        for (String s : allCustomer) {
            if (!Objects.equals(s, "X")) {
                System.out.println(s);
            }
        }
    }
    public static void createFile(){//creates a file named customerDetails
        try {
            file = new File("CustomerDetails.txt");
            if (!file.createNewFile()) System.out.println();
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    public  void storeData(FoodQueue foodQueue){//store the data from the customers array to the CustomerDetails file
        createFile();
        try {
            FileWriter myWriter = new FileWriter("CustomerDetails.txt");
            for (int i= 0;i<queue1.size();i++) {
                myWriter.write("Queue : 1 -> Position : "+(i+1)+" "+queue1.get(i)+" has ordered "+foodQueue.getBurgerCount(i,1)+" burgers.\n");
            }
            for (int i= 0;i<queue2.size();i++) {
                myWriter.write("Queue : 2 -> Position : "+(i+1)+" "+queue2.get(i)+" has ordered "+foodQueue.getBurgerCount(i,2)+" burgers.\n");
            }
            for (int i= 0;i<queue3.size();i++) {
                myWriter.write("Queue : 3 -> Position : "+(i+1)+" "+queue3.get(i)+" has ordered "+foodQueue.getBurgerCount(i,3)+" burgers.\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void readData(){//this method reads the data from customerDetails file.
        try {
            Scanner myReader = new Scanner(file);
            System.out.println();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("data not stored to file");
        }
    }

//hi
}
