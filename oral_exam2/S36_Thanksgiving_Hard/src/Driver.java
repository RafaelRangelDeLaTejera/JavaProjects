import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        /* create input object of the scanner class to read in from the user
          the input object is initialized with the Scanner constructor that takes in System.in which will take in input from the user and change it into desired variable*/
        Scanner input = new Scanner(System.in);

        // Promp user to enter item price
        System.out.print("Get the optimal enjoyment for your thanksgiving dinner\n");

        System.out.print("Enter the weight of the turkey unit: ");
        // read in from user the next input string available
        int turkeyWeight = input.nextInt();
        System.out.print("Enter the enjoyment of the turkey unit: ");
        // read in from user the next input string available
        double turkeyEnjoyment = input.nextInt();

        FoodItem turkey = new FoodItem(turkeyWeight,turkeyEnjoyment);

        System.out.print("Enter the weight of the pumpkin pie unit: ");
        // read in from user the next input string available
        int pieWeight = input.nextInt();
        System.out.print("Enter the enjoyment of the pumpkin pie unit: ");
        // read in from user the next input string available
        double pieEnjoyment = input.nextInt();

        FoodItem pumpkinPie = new FoodItem(pieWeight,pieEnjoyment);

        System.out.print("Enter the weight of the mashed potatoes unit: ");
        // read in from user the next input string available
        int potatoesWeight = input.nextInt();
        System.out.print("Enter the enjoyment of the mashed potatoes unit: ");
        // read in from user the next input string available
        double potatoesEnjoyment = input.nextDouble();

        FoodItem mashedPotatoes = new FoodItem(potatoesWeight,potatoesEnjoyment);

        System.out.print("Enter the weight of the gravy unit: ");
        // read in from user the next input string available
        int gravyWeight = input.nextInt();
        System.out.print("Enter the enjoyment of the gravy unit: ");
        // read in from user the next input string available
        double gravyEnjoyment = input.nextDouble();

        FoodItem gravy = new FoodItem(gravyWeight,gravyEnjoyment);

        System.out.print("Enter the weight of the stuffing unit: ");
        // read in from user the next input string available
        int stuffingWeight = input.nextInt();
        System.out.print("Enter the enjoyment of the stuffing unit: ");
        // read in from user the next input string available
        double stuffingEnjoyment = input.nextDouble();

        FoodItem stuffing = new FoodItem(stuffingWeight,stuffingEnjoyment);

        System.out.print("Enter the weight of the cranberries unit: ");
        // read in from user the next input string available
        int cranberriesWeight = input.nextInt();
        System.out.print("Enter the enjoyment of the cranberries unit: ");
        // read in from user the next input string available
        double cranberriesEnjoyment = input.nextDouble();

        FoodItem cranberries = new FoodItem(cranberriesWeight,cranberriesEnjoyment);

        System.out.print("Enter the weight of the casserole unit: ");
        // read in from user the next input string available
        int casseroleWeight = input.nextInt();
        System.out.print("Enter the enjoyment of the casserole unit: ");
        // read in from user the next input string available
        double casseroleEnjoyment = input.nextDouble();

        FoodItem casserole = new FoodItem(casseroleWeight,casseroleEnjoyment);

        System.out.print("Enter the capacity of the Stomach");
        int capacity = input.nextInt();

        //ArrayList foods = new ArrayList<FoodItem>();

        FoodItem[] foods = {turkey,pumpkinPie,mashedPotatoes,gravy,stuffing,cranberries,casserole};

        double optimalEnjoyment = ThanksgivingStomachOptimization.optimizationAlgorithm(foods, capacity);
        System.out.print(optimalEnjoyment);

    }
}
