import java.util.Random;
public class Cat {
    private int x, y;
    private String catim = "\uD83D\uDC08";
    private int brain = 100;
    Cat(int sizeboard){
         Random rand = new Random();
         x = 1 + rand.nextInt(sizeboard);
         y = sizeboard;
     }
    Cat(int x, int y){
         this.x = x;
         this.y = y;
     }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCatim() {
        return catim;
    }

    public int getBrain() {
        return brain;
    }
    public boolean correctStep(int x, int y){
         return this.x == x && Math.abs(this.y - y) == 1 && x != 6 && x != 0 && y != 6 && y != 0
                 || this.y == y && Math.abs(this.x - x) == 1 && x != 6 && x != 0 && y != 6 && y != 0;
     }
    void step(int x, int y){
         this.x = x;
         this.y = y;
     }
    public void minusBrain(){
         Random rand = new Random();
         int v = rand.nextInt(1,25);
         if (brain <= 0){
             brain = 0;
         }else{
             brain = brain - v;
         }
     }
}
