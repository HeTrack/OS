package laba2_OS;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        MemoryManagerUnit manager = new MemoryManagerUnit(128);

        for (int i = 0; i < 10; i++) {
        	int rnd = random.nextInt(1024);
        	 System.out.println("ƒобавление страницы в физическую пам€ть:" + rnd);
            manager.RequestPage(rnd);
           
        }
    }
}
