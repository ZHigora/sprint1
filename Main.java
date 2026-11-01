import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int sizeboard = 5;
        Random rand = new Random();
        Cat kitty = new Cat(sizeboard);
        String[][] board = new String[sizeboard][sizeboard];
        for (int y = 1; y <= sizeboard; y++) {
            for (int x = 1; x <= sizeboard; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }
        int countGhost = sizeboard * sizeboard - sizeboard - 1;
        Ghost[] ghosts = new Ghost[countGhost];
        int count = 0;
        while (count < countGhost) {
            Ghost ghost;
            if (rand.nextBoolean()) {
                ghost = new Ghost(sizeboard);
            } else {
                ghost = new Kindghost(sizeboard);
            }
            int column = ghost.getX() - 1;
            int row = ghost.getY() - 1;
            if (board[row][column].equals("  ")) {
                board[row][column] = ghost.getGhost();
                ghosts[count] = ghost;
                count++;
            }
        }
        System.out.println("Помоги коту выбраться. Дойди до клетки (2, 1) Начнём? да/нет");
        Scanner scan = new Scanner(System.in);
        String answear = scan.nextLine();
        switch (answear) {
            case "да":
                while (true) {
                    board[kitty.getY() - 1][kitty.getX() - 1] = kitty.getCatim();
                    outputBoard(board, kitty.getBrain());
                    System.out.println("Введи, куда прыгнет котик"
                            + " ,котик не может прыгать в углы"
                            + "\nМесто котика сейчас —— (x: " + kitty.getX() +
                            ", y: " + kitty.getY() + ")");
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    System.out.println(x + ", " + y);
                    if (kitty.correctStep(x, y)) {
                        if (board[y - 1][x - 1].equals("  ")) {
                            board[kitty.getY() - 1][kitty.getX() - 1] = "  " +
                                    "";
                            kitty.step(x, y);

                            System.out.println("Котик прыгнул");
                        } else if (kitty.getX() == 1 && kitty.getY() == 1) {
                            System.out.println("Ты выбрался из видений!");
                            break;
                        } else{
                            for (Ghost ghost : ghosts) {
                                if (ghost.problem(x, y)) {
                                    if (ghost.task(kitty.getBrain())) {
                                        board[kitty.getY() - 1][kitty.getX() - 1] = "  ";
                                        kitty.step(x, y);
                                    }else {
                                        kitty.minusBrain();

                                    }
                                    break;
                                }
                            }
                        }
                    }else {
                        System.out.println("котик не смог прыгнуть");
                    }
                     if (kitty.getBrain() <= 0) {
                         break;
                     }
                }

                if (kitty.getBrain() <= 0){
                    System.out.println("Рассудок потерян. ты не выбрался...");
                }
                break;
            case "нет":
                System.out.println("Ступай. может ты поможешь в другой раз...");
            default:
                System.out.println("на это дана одна попытка. ты её истратил, человек");
                break;
        }
    }
    static void  outputBoard(String[][] board, int brain) {
        String leftWall = "| ";
        String rightWall = "|";
        String wall = "^ —— ^ —— ^ —— ^ —— ^ —— ^";

        for (String[] row : board) {
            System.out.println(wall);
            for (String col : row) {
                System.out.print(leftWall + col + " ");
            }
            System.out.println(rightWall);
        }
        System.out.println(wall);

        System.out.println("Рассудок:\t" + brain + "\n");
    }
}
