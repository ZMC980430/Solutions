package practice;

import java.util.concurrent.TimeUnit;

public class Nap {
    public Nap() throws InterruptedException {
        System.out.println("Nap created");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
    public Nap(int i) throws InterruptedException {
        System.out.println("Nap " + i + " created");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Awake from sleep " + i);
    }
}
