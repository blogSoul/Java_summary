public class Lion extends Predator implements Barkable {
    public String getFood(){
        return "banana";
    }
    public void bark() {
        System.out.println("으르렁");
    }
}
