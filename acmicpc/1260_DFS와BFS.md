```java
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

class ListGraph {
    private ArrayList<ArrayList<Integer>> listGraph;
    public ListGraph(int size){
        this.listGraph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < size + 1; i++){
            listGraph.add(new ArrayList<Integer>());
        }
    }
    public ArrayList<ArrayList<Integer>> getGraph() {
        return this.listGraph;
    }
    public void addEdge(int start, int end){
        listGraph.get(start).add(end);
        Collections.sort(listGraph.get(start));
    }
    public void deleteEdge(int start, int end){
        listGraph.get(start).remove(Integer.valueOf(end));
    }
    public void print() throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < listGraph.size(); i++){
            for(int j = 0; j < listGraph.get(i).size(); j++){
                sb.append(Integer.toString(i) + " -> " + Integer.toString(listGraph.get(i).get(j)) + "\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
    public void dfs(int node, boolean[] visited, StringBuilder sb){
        if(visited[node]) {
            return;
        }
        visited[node] = true;
        sb.append(node + " ");
        for(int nextnode : listGraph.get(node)){
            dfs(nextnode, visited, sb);
        }
    }
    public void bfs(int node, boolean[] visited, StringBuilder sb){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            if(visited[node]){
                continue;
            }
            visited[node] = true;
            sb.append(node + " ");
            for(int nextnode : listGraph.get(node)){
                queue.offer(nextnode);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);
        ListGraph graph = new ListGraph(N);
        boolean[] visited_dfs = new boolean[N + 1];
        boolean[] visited_bfs = new boolean[N + 1];
        for(int i = 0; i < M; i++){
            String[] input_edge = br.readLine().split(" ");
            int start = Integer.parseInt(input_edge[0]);
            int end = Integer.parseInt(input_edge[1]);
            graph.addEdge(start, end);
            graph.addEdge(end, start);
        }
        //graph.print();
        StringBuilder sb = new StringBuilder();
        graph.dfs(V, visited_dfs, sb);
        sb.append("\n");
        graph.bfs(V, visited_bfs, sb);
        bw.write(sb.toString() + "\n");
        br.close();
        bw.close();
    }
}
```
