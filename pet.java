import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class pet {
    public static Map<String, String> runTutorial() {
        Map<String, String> petInfo = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Tomagatchi Pet Game");
            System.out.println("Welcome to the Pet Selector!");
            System.out.println("Choose your pet:");
            System.out.println("1. Dog - Loyal and playful");
            System.out.println("2. Cat - Independent and curious");
            System.out.println("3. Bird - Free-spirited and cheerful");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            String selectedPet;
            switch (choice) {
                case 1 -> selectedPet = "Dog";
                case 2 -> selectedPet = "Cat";
                case 3 -> selectedPet = "Bird";
                default -> {
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                    return petInfo;
                }
            }
            System.out.println("You have chosen a " + selectedPet + " as your pet!");
            System.out.println(" ");
            System.out.println("Now, let's choose a name for your " + selectedPet + ":");
            System.out.print("Enter the name: ");
            String petName = scanner.next();
            System.out.println("Great! Your " + selectedPet + " is named " + petName + ".");
            System.out.println(" ");
            // Home selection
            System.out.println("\nNow, choose a home for you and your pet:");
            System.out.println("1. Cozy House - A warm and comfortable home");
            System.out.println("2. Garden Cottage - Surrounded by nature");
            System.out.println("3. Modern Apartment - Sleek and contemporary");
            System.out.print("Enter your home choice (1-3): ");
            int homeChoice = scanner.nextInt();
            String homeName;
            switch (homeChoice) {
                case 1 -> homeName = "Cozy House";
                case 2 -> homeName = "Garden Cottage";
                case 3 -> homeName = "Modern Apartment";
                default -> {
                    System.out.println("Invalid choice. Defaulting to Cozy House.");
                    homeName = "Cozy House";
                }
            }
            System.out.println("Your " + selectedPet + " will live in the " + homeName + "!");
            System.out.println("Enjoy your new companion!");
            System.out.println(" ");
            System.out.println(" Welcome the the tutorial for taking care of your pet! ");
            System.out.println(" Here are some basic commands to take care of your pet: ");
            System.out.println(" 1. feed - Feed your pet to keep it healthy.");
            System.out.println(" 2. play - Play with your pet to keep it happy.");
            System.out.println(" 3. sleep - Let your pet rest to regain energy.");
            System.out.println(" 4. status - Check your pet's current status.");
            System.out.println(" 5. quit - Exit the game.");
            System.out.println(" Have fun taking care of your pet!");
            
            // Store pet information
            petInfo.put("name", petName);
            petInfo.put("type", selectedPet);
            petInfo.put("home", homeName);
        }
        return petInfo;
    }
}
