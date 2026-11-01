import java.util.Scanner;
public class Kindghost extends Ghost {
    Kindghost(int sizeboard) {
        super(sizeboard);
        setGhostim("\uD83D\uDC7B");
    }

    @Override
    public boolean task(int brain) {
        if (brain <= 60) {
            System.out.println("я добрый. ступай");
            return true;
        } else {
            System.out.println("я пропущу тебя маленький путник но...");
            System.out.println("ты хочешь домой? да/нет");
            Scanner scan = new Scanner(System.in);
            String answeari = scan.nextLine();
            if (answeari.equals("да")){
                System.out.println("хорошо");
                return true;
            }else{
                System.out.println("как пожелаешь");
                return false;
            }
        }
    }
}

