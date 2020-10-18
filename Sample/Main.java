import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static int gcd(int a, int b){
        if(b == 0)
            return 0;
        int tmp;
        while(b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
    public static void PrintGcd(int num){
        List<Integer> list = new LinkedList<>();
        list.add(num);
        for(int i = 2; i <= Math.sqrt(num);i++){
            if(num % i == 0){
                if(i == num / i){
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(num / i);
                }
            }
        }
        Collections.sort(list);
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int Min = Integer.MAX_VALUE, i, Gcd = 0, N = sc.nextInt();
        int[] arr = new int[N];
        int[] minus = new int[N];
        for(i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            Min = (Min > arr[i]) ? arr[i] : Min;
        }
        sc.close();
        Arrays.sort(arr);
        for(i = 1; i < N; i++){
            minus[i] = arr[i] - arr[i - 1];
        }
        Gcd = arr[1] - arr[0];
        for(i = 1; i < minus.length; i++){
            Gcd = gcd(Gcd, minus[i]);
        }
        //System.out.println("G: " + Gcd + " ");
        PrintGcd(Gcd);
    }
}
