import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int i, N = sc.nextInt();
        long[] arr = new long[N];
        long min;
        for(i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            min = (i == 0) ? Math.min(min, arr[i]) : arr[i];
        }
        sc.close();
        while
    }
}
