import java.util.Scanner;

public class food {
    public static void showFoodOptions(Scanner scanner, EnergyBars bars) {
            System.out.println("Food Options for Your Pet:");
            System.out.println("1. Kibble - Basic pet food for cats and dogs");
            System.out.println("2. Canned Food - More nutritious option");
            System.out.println("3. Seed - Special food for birds");
            System.out.println("Choose the food you want to give to your pet:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("You have chosen Kibble for your pet.");
                    bars.changeFood(10);
                }
                case "2" -> {
                    System.out.println("You have chosen Canned Food for your pet.");
                    bars.changeFood(20);
                }
                case "3" -> {
                    System.out.println("You have chosen Seed for your pet.");
                    bars.changeFood(15);
                }
                default -> System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
    }
}
