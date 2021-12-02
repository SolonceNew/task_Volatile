package partsOfTheGame;

public class Box {
    private volatile boolean boxStatus;
    private final int USER_SLEEP = 1000;
    private final int LIMIT_OPEN_TIMES = 10;
    private int currentStatusLimitOpenTimes = 0;
    private final int TOY_SLEEP = 2000;


    public void on() {
        try {
            while (currentStatusLimitOpenTimes < LIMIT_OPEN_TIMES) {
                if (!boxStatus) {
                    boxStatus = true;
                    System.out.printf("Пользователь %s включил тумблер. Коробка открылась.\n",
                            Thread.currentThread().getName());
                    Thread.sleep(USER_SLEEP);
                }
            }
        } catch (InterruptedException e) {
            System.out.printf("Поток %s прервал свою работу\n", Thread.currentThread().getName());
        }
    }


    public void off() {
        try {
            while (currentStatusLimitOpenTimes != LIMIT_OPEN_TIMES) {
                if (boxStatus) {
                    boxStatus = false;
                    System.out.printf("%s переключил тумблер и закрыл коробку\n",
                            Thread.currentThread().getName());
                    Thread.sleep(TOY_SLEEP);
                    currentStatusLimitOpenTimes++;
                }
            }
        } catch (InterruptedException e) {
            System.out.printf("Поток %s прервал свою работу\n", Thread.currentThread().getName());
        }
        Thread.interrupted();
    }
}




