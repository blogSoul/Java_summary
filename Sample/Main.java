import java.util.Scanner;

public class Main {
    public static int Min = Integer.MAX_VALUE;
    public static int[][] arr;
    public static int[] arr_visit;
    public static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i, j;
        N = sc.nextInt();
        arr = new int[N][N];
        arr_visit = new int[N];
        for(i = 0; i < N; i++){
            for(j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        backtracking(0, 0);
        System.out.println(Min);
    }
    public static void backtracking(int start, int count){
        if(count == N / 2){
            calc();
            return;
        }
        for(int i = start ; i < N; i++){
            arr_visit[i] = 1;
            backtracking(i + 1, count + 1);
            arr_visit[i] = 0;
        }
    }
    public static void calc() {
        int[] arr1 = new int[N / 2];
        int[] arr2 = new int[N / 2];
        int arr1_cnt = 0, arr2_cnt = 0;
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < N; i++){
            if(arr_visit[i] == 0){
                arr1[arr1_cnt++] = i;
            } else {
                arr2[arr2_cnt++] = i;
            }
        }
        for(int i = 0; i < N / 2; i++){
            for(int j = i + 1; j < N / 2; j++){
                sum1 += arr[arr1[i]][arr1[j]] + arr[arr1[j]][arr1[i]];
                sum2 += arr[arr2[i]][arr2[j]] + arr[arr2[j]][arr2[i]];
            }    
        }
        Min = Math.min(Min, Math.abs(sum1 - sum2));
    }
}
