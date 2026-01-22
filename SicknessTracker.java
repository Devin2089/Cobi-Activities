import java.util.Timer;

public class SicknessTracker {
    private boolean isSick;
    private Timer sicknessTimer;
    private static final int CHECK_INTERVAL = 3000; // Check every 3 seconds
    private static final int SICKNESS_CHANCE = 500; // 1 in 500 chance

    public SicknessTracker() {
        this.isSick = false;
        startSicknessCheck();
    }

    private void startSicknessCheck() {
        sicknessTimer = new Timer(true);
        sicknessTimer.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                checkForSickness();
            }
        }, CHECK_INTERVAL, CHECK_INTERVAL);
    }

    private synchronized void checkForSickness() {
        if (!isSick) {
            // 1 in 500 chance to get sick
            int random = (int) (Math.random() * SICKNESS_CHANCE);
            if (random == 0) {
                isSick = true;
                System.out.println("\n⚠️  Oh no! Your pet has gotten sick! Use 'cure' command to heal it.");
            }
        }
    }

    public synchronized boolean getIsSick() {
        return isSick;
    }

    public synchronized void cure() {
        if (isSick) {
            isSick = false;
            System.out.println("✓ Your pet is now healthy again!");
        } else {
            System.out.println("Your pet is already healthy!");
        }
    }

    public void stopTimer() {
        if (sicknessTimer != null) {
            sicknessTimer.cancel();
        }
    }
}
