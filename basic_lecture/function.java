class Updater{
    public void update(function sample){
        sample.count++;
    }
}

public class function {
    int count = 0;
    public int sum(int a, int b){
        return a + b;
    }
    public String say(){
        return "Hi";
    }
    public static void main(String[] args) {
        function test = new function();
        int a = 1, b = 2;
        int c = test.sum(a, b);
        System.out.println(c);
        System.out.println(test.say());
        System.out.println(test.count);
        Updater test2 = new Updater();
        test2.update(test);
        System.out.println(test.count);
    }
}