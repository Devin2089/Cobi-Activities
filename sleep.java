public class sleep {
    // When this class is called the pet will sleep
    public static void sleepPet(EnergyBars bars) {
        System.out.println("Your pet is now sleeping... Zzzzz...");
        // Simulate sleep with a simple message
        try {
            Thread.sleep(2000); // Sleep for 2 seconds to simulate rest
        } catch (InterruptedException e) {
            System.out.println("Sleep was interrupted.");
        }
        System.out.println("Your pet has woken up feeling refreshed!");
        bars.changeSleep(30);
    }
}
