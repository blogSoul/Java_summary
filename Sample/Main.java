import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main {
    private static ArrayList<Integer> queue;
    private static StringBuilder sb;
    public static String check(String order, int M, ArrayList<Integer> queue){
        StringBuilder sb = new StringBuilder();
        boolean checkArrow = true; // true면 첫번째 부터 
        for(int i = 0; i < order.length(); i++){
            if(order.charAt(i) == 'R'){
                checkArrow = (checkArrow) ? false : true;
            } else if(order.charAt(i) == 'D'){
                if(queue.isEmpty()){
                    return "error\n";
                } else if(checkArrow){
                    queue.remove(0);
                } else if(!checkArrow){
                    queue.remove(queue.size() - 1);
                }
            }
        }
        //System.out.println("D: " + queue + " " + checkArrow);
        if(checkArrow){
            sb.append("[");
            for(int i = 0; i < queue.size(); i++){
                sb.append(queue.get(i));
                sb.append(",");
            }
            if(queue.size() != 0){
                sb.delete(sb.length() - 1, sb.length());
            }
            sb.append("]\n");
        } else if(!checkArrow){
            sb.append("[");
            for(int i = queue.size() - 1; i >= 0; i--){
                sb.append(queue.get(i));
                sb.append(",");
            }
            if(queue.size() != 0){
                sb.delete(sb.length() - 1, sb.length());
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        queue = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String order = br.readLine();
            int M = Integer.parseInt(br.readLine());
            String array = br.readLine();
            array = array.substring(1, array.length() - 1);
            st = new StringTokenizer(array, ",");
            while(st.hasMoreTokens()){
                queue.add(Integer.parseInt(st.nextToken()));
            }
            bw.write(check(order, M, queue));
            //sb.append("D:" + order + " " + Integer.toString(M) + " " + queue.toString() + "\n");
            queue.clear();
        }
        br.close();
        bw.close();
    }
}