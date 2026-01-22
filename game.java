public class game {
    public static void main(String[] args) {
        // Run the pet tutorial first and get pet info
        java.util.Map<String, String> petInfo = pet.runTutorial();
        
        // Create energy bars, sickness tracker, and statistics
        EnergyBars bars = new EnergyBars();
        SicknessTracker sickness = new SicknessTracker();
        Statistics stats = new Statistics(
            petInfo.get("name"),
            petInfo.get("type"),
            petInfo.get("home"),
            bars,
            sickness
        );
        
        // ...game logic can go here...
        System.out.println("Game is starting...");
        System.out.println(" Hello and welcome to the Tomagatchi Pet Game! ");
        System.out.println(" Have fun taking care of your pet! ");
        System.out.println(" ");
        System.out.println(" Enter what you wish to do with your pet at any time. ");
        System.out.println(" Type 'status' to see your pet's stats");
        System.out.println(" ");
        
        // Main game loop
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.print("Enter a command (feed/play/sleep/shower/status/cure/quit): ");
                String command = scanner.nextLine().toLowerCase().trim();
                
                switch (command) {
                    case "feed" -> food.showFoodOptions(bars);
                    case "play" -> play.main(new String[]{}, bars);
                    case "sleep" -> sleep.sleepPet(bars);
                    case "status" -> stats.displayStats();
                    case "cure" -> sickness.cure();
					case "shower" -> shower.showerPet(bars);
                    case "quit" -> {
                        running = false;
                        System.out.println("Thanks for playing!");
                    }
                    default -> System.out.println("Invalid command. Try: feed, play, sleep, shower, status, cure, or quit");
                }
                System.out.println();
            }
        }
        
        // Cleanup on exit
        bars.stopTimer();
        sickness.stopTimer();
    }
}
