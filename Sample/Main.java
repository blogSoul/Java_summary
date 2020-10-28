import java.util.Stack;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    public static long check(long[] arr){
        long MAX = 0;
        int size = arr.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < size; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                Long Heigth = arr[stack.pop()];
                int Width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                MAX = Math.max(MAX, Width * Heigth);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            Long Heigth = arr[stack.pop()];
            int Width = (stack.isEmpty()) ? size : size - stack.peek() - 1;
            MAX = Math.max(MAX, Width * Heigth);
        }
        return MAX;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if(N == 0)
                break;
            long[] arr = new long[N];
            for(int i = 0; i < N; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
            sb.append(Long.toString(check(arr)) + "\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}