import java.util.LinkedList;
import java.util.Scanner;

public class FoodQueue {
    Customer customer;
    static Scanner scanner = new Scanner(System.in);
    static int maxBurgerStock = 50;
    static int burgersAvailable = 50;
    public static LinkedList<Integer> queue1Burgers = new LinkedList<>();
    public static LinkedList<Integer> queue2Burgers = new LinkedList<>();
    public static LinkedList<Integer> queue3Burgers = new LinkedList<>();

    public FoodQueue(Customer customer) {
        this.customer = customer;
    }
    public  void setQueueBurgers(int i,int queue) {
        if (queue==1)queue1Burgers.add(i);
        if (queue==2)queue2Burgers.add(i);
        if (queue==3)queue3Burgers.add(i);
    }
    public  void removeQueueBurgers(int i,int queue) {
        if (queue==1)queue1Burgers.remove(i);
        if (queue==2)queue2Burgers.remove(i);
        if (queue==3)queue3Burgers.remove(i);
    }
    public  int getBurgerCount(int i,int queue) {
        if (queue==1) return queue1Burgers.get(i);
        if (queue==2) return queue2Burgers.get(i);
        if (queue==3) return queue3Burgers.get(i);
        return 0;
    }
    public  void addBurgersTosStock(){
        System.out.println("\nhow many burgers need to add to the stock?\n");
        int numOfBurgers= scanner.nextInt();
        if ((numOfBurgers+burgersAvailable)<=maxBurgerStock) burgersAvailable+=numOfBurgers;
        else if((numOfBurgers+burgersAvailable)>maxBurgerStock){
            int maxBurgers= maxBurgerStock-burgersAvailable;
            System.out.println("\nOnly possible to store "+maxBurgers+ " burgers\n");
        }
    }
    public void BurgerIncome(){
        int firstQueueIncome= 0;
        for (int s:queue1Burgers) firstQueueIncome+=s*650;
        System.out.print("Income from the first Queue :");
        System.out.println(firstQueueIncome);

        int secondQueueIncome=0;
        for (int s:queue2Burgers) secondQueueIncome+=s*650;
        System.out.print("Income from the second Queue :");
        System.out.println(secondQueueIncome);

        int thirdQueueIncome=0;
        for (int s:queue2Burgers) secondQueueIncome+=s*650;
        System.out.print("Income from the third Queue:");
        System.out.println(thirdQueueIncome);
    }
    public void StockReducer(int numOfBurgers){burgersAvailable-=numOfBurgers;}
    public int BurgersAvailable(){return burgersAvailable;}
}
