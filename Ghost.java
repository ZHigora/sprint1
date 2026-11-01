import java.util.Random;
import java.util.Scanner;

public class Ghost {
    private String ghostim = "\uD83D\uDC7B";
    private final int x, y;

    Ghost(int sizeboard) {
        Random rand = new Random();
        x = 1 + rand.nextInt(sizeboard);
        y = 1 + rand.nextInt(sizeboard);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getGhost() {
        return ghostim;
    }

    public void setGhostim(String ghostim) {
        this.ghostim = ghostim;
    }

    public boolean problem(int catx, int caty) {
        return catx == x && caty == y;
    }

    public boolean task(int brain) {
        System.out.println("Реши и беги");
        if (brain >= 60) {
            Random rand = new Random();
            int a = rand.nextInt(20);
            int b = rand.nextInt(30);
            int c = rand.nextInt(1,3);
            if (c == 2) {
                int trueanswer1 = a + b;
                System.out.println("Сколько здесь получится? Ответь " + a + "+" + b + "=?");
                Scanner scan = new Scanner(System.in);
                int answer1 = scan.nextInt();
                if (trueanswer1 == answer1) {
                    System.out.println("беги дальше, маленький котенок");
                    return true;
                } else {
                    System.out.println("неверно, повезло что у тебя 9 жизней");
                    return false;
                }
            } else {
                int trueanswer = a - b;
                System.out.println("Сколько получится? Ответь " + a + "-" + b + "=?");
                Scanner scanner = new Scanner(System.in);
                int answer = scanner.nextInt();
                if (trueanswer == answer) {
                    System.out.println("беги дальше, маленький котенок");
                    return true;
                } else {
                    System.out.println("неверно, повезло что у тебя 9 жизней");
                    return false;
                }
            }
        } else {
            Random rand = new Random();
            int f = rand.nextInt(1, 50);
            int m = rand.nextInt(1,60);
            int p = rand.nextInt(1,3);
            if (p == 2) {
                int trueanswer2 = (m * f) / 9;
                System.out.println("Кружится г#####? О#веть " + m + "*" + f + " и делён#ое наце#о на тв#и жиз#и (9) =?");
                Scanner scan = new Scanner(System.in);
                int answer2 = scan.nextInt();
                if (trueanswer2 == answer2) {
                    System.out.println("беги дал#ше,ко#е#ок");
                    return true;
                } else {
                    System.out.println("неверно, ###########");
                    return false;
                }
            } else {
                int trueanswer3 = m / f;
                System.out.println("Ответь " + m + " де##нное нац#ло на " + f + "=?");
                Scanner scanner = new Scanner(System.in);
                int answer3 = scanner.nextInt();
                if (trueanswer3 == answer3) {
                    System.out.println("б#ги, ко#енок");
                    return true;
                } else {
                    System.out.println("неверно");
                    return false;
                }
            }
        }
    }
}
