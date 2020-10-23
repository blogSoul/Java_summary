import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr, arrSum;
    public static void SumArr(int N, int M){
        int sum = 0;
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                sum += arr[i][j];
            }    
        }
        arrSum[N + 1][M + 1] = sum;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] psum = new int[N + 1][M + 1];
        int[] remainder = new int[K];
        int answer = 0, num, temp;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++){
                num = Integer.parseInt(st.nextToken());
                psum[i][j] = Math.floorMod(psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + num, K);
                
            }
        }
        for(int x_start = 1; x_start <= N; x_start++){
            for(int x_end = x_start; x_end <= N; x_end++){
                for(int y_start = 1; y_start <= M; y_start++){
                    for(int y_end = y_start; y_end <= M; y_end++){
                        temp = Math.floorMod(psum[x_end][y_end] - psum[x_start - 1][y_end] - psum[x_end][y_start - 1] + psum[x_start - 1][y_start - 1], K);
                        //System.out.println(x_start+ " " + x_end + " " + y_start+ " " + y_end + " " + temp);
                        remainder[temp]++;
                        if(temp == 0){
                            answer++;
                        }
                    }    
                }        
            }    
        }
        /*
        for(int i = 0; i < K; i++){
            answer += remainder[i] * (remainder[i] - 1) / 2;
        }
        */
        bw.write(Integer.toString(answer));
        br.close();
        bw.close();
    }
} 