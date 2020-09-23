public class Euler1 {   
    int max;
    public Euler1(int max) {
        this.max = max;
    }

    public int sumOf3And5() {
        int sum = 0;
        for(int i=0; i<max; i++) {
            if (i%3 == 0 || i%5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Euler1(10).sumOf3And5());
        System.out.println(new Euler1(1000).sumOf3And5());
    }
}