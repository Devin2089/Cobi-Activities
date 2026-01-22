public class shower {
    // When this class is called the pet will take a shower
    public static void showerPet(EnergyBars bars) {
        System.out.println("Your pet is taking a shower... Splash Splash...");
        // Simulate shower with a simple message
        try {
            Thread.sleep(2000); // Shower for 2 seconds to simulate cleanliness
        } catch (InterruptedException e) {
            System.out.println("Shower was interrupted.");
        }
        System.out.println("Your pet is now clean and fresh!");
        bars.changeCleanliness(40);
    }
}