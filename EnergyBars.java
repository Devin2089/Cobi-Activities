import java.util.Timer;

public class EnergyBars {
    private int sleep;
    private int food;
    private int play;
    private int cleanliness;
    private Timer decreaseTimer;

    public EnergyBars() {
        this.sleep = 100;
        this.food = 100;
        this.play = 100;
        this.cleanliness = 100;
        startDecreaseTimer();
    }

    private void startDecreaseTimer() {
        decreaseTimer = new Timer(true);
        decreaseTimer.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                decreaseAllBars();
            }
        }, 10000, 10000); // Decrease every 10 seconds
    }

    private synchronized void decreaseAllBars() {
        this.sleep = Math.max(0, this.sleep - 1);
        this.food = Math.max(0, this.food - 1);
        this.play = Math.max(0, this.play - 1);
        this.cleanliness = Math.max(0, this.cleanliness - 1);
    }

    public void stopTimer() {
        if (decreaseTimer != null) {
            decreaseTimer.cancel();
        }
    }

    public void changeSleep(int amount) {
        synchronized (this) {
            this.sleep = clamp(this.sleep + amount);
        }
    }

    public void changeFood(int amount) {
        synchronized (this) {
            this.food = clamp(this.food + amount);
        }
    }

    public void changePlay(int amount) {
        synchronized (this) {
            this.play = clamp(this.play + amount);
        }
    }

    public void changeCleanliness(int amount) {
        synchronized (this) {
            this.cleanliness = clamp(this.cleanliness + amount);
        }
    }

    public synchronized void showBars() {
        System.out.println("\n========== ENERGY BARS ==========");
        System.out.println("Sleep:        " + barString(sleep));
        System.out.println("Food:         " + barString(food));
        System.out.println("Play:         " + barString(play));
        System.out.println("Cleanliness:  " + barString(cleanliness));
        System.out.println("================================\n");
    }

    public synchronized void displayBars() {
        System.out.println("║ Sleep:     " + String.format("%-22s║", barString(sleep)));
        System.out.println("║ Food:      " + String.format("%-22s║", barString(food)));
        System.out.println("║ Play:      " + String.format("%-22s║", barString(play)));
        System.out.println("║ Cleanliness: " + String.format("%-20s║", barString(cleanliness)));
    }

    private int clamp(int value) {
        return Math.max(0, Math.min(100, value));
    }

    private String barString(int value) {
        int bars = value / 10;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 10; i++) {
            sb.append(i < bars ? "#" : "-");
        }
        sb.append("] ").append(value).append("%");
        return sb.toString();
    }
}
