public class Statistics {
    private String petName;
    private String petType;
    private String homeName;
    private final EnergyBars bars;
    private final SicknessTracker sickness;

    public Statistics(String petName, String petType, String homeName, EnergyBars bars, SicknessTracker sickness) {
        this.petName = petName;
        this.petType = petType;
        this.homeName = homeName;
        this.bars = bars;
        this.sickness = sickness;
    }

    public void displayStats() {
        String healthStatus = sickness.getIsSick() ? "🤒 SICK" : "✓ Healthy";
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         PET STATISTICS              ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Pet Name:  " + String.format("%-23s║", petName));
        System.out.println("║ Pet Type:  " + String.format("%-23s║", petType));
        System.out.println("║ Home:      " + String.format("%-23s║", homeName));
        System.out.println("║ Health:    " + String.format("%-23s║", healthStatus));
        System.out.println("╠════════════════════════════════════╣");
        bars.displayBars();
        System.out.println("╚════════════════════════════════════╝\n");
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }
}
