import java.util.Scanner;
public class play {
    public static void main(String[] args, Scanner scanner, EnergyBars bars) {
            System.out.println("Choose how you wish to play with your pet press 1-3:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("You chose to play fetch.");
                    bars.changePlay(10);
                }
                case "2" -> {
                    System.out.println("You chose to play hide and seek.");
                    bars.changePlay(15);
                }
                case "3" -> {
                    System.out.println("You chose to play treasure hunt.");
                    bars.changePlay(20);
                }
                default -> System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
            switch (choice) {
                case "1" -> System.out.println("You throw the ball and your pet runs to fetch it! \nThe pet brings the ball back to you.");
                case "2" -> System.out.println("You hide and your pet is searching for you! \nYour pet found you and starts moving around happily.");
                case "3" -> System.out.println("You play treasure hunt with your pet! \nYour pet finds the treasure and brings it back to you.");
            }
    }
}
