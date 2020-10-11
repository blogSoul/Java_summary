import java.util.Scanner;

public class Main {
    public static int[][] dp;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();
        int Max = 0;
        dp = new int[N][2];
        arr = new int[N];
        for(int i = 0; i < N; i++){
            dp[i][0] = sc.nextInt(); // A
            dp[i][1] = sc.nextInt(); // B
        }
        sc.close();
        int temp = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(dp[i][0] > dp[j][0]){
                    temp = dp[i][0];
                    dp[i][0] = dp[j][0];
                    dp[j][0] = temp;
                    temp = dp[i][1];
                    dp[i][1] = dp[j][1];
                    dp[j][1] = temp;
                }
            }
        } // sort
        for(int i = 0; i < N; i++){
            arr[i] = 1;
            for(int j = 0; j <= i; j++){
                if(dp[i][1] < dp[j][1]){
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            Max = Math.max(arr[i], Max);
        }
        System.out.println(N - Max);
    }
}