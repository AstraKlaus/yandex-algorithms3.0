import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GraphComponents {
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static ArrayList<Boolean> visited = new ArrayList<>();
    static ArrayList<StringBuilder> help = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int combs = Integer.parseInt(line[1]);
        int nums = Integer.parseInt(line[0]);
        for (int i = 0; i < combs; i++){
            String cords = reader.readLine();
            int first = Integer.parseInt(cords.split(" ")[0]);
            int second = Integer.parseInt(cords.split(" ")[1]);
            if (graph.containsKey(first)) {
                if (!graph.get(first).contains(second))
                    graph.get(first).add(second);
            }else graph.put(first, new ArrayList<>() {{add(second);}});
            if (graph.containsKey(second)) {
                if (!graph.get(second).contains(first))
                    graph.get(second).add(first);
            }else graph.put(second, new ArrayList<>() {{add(first);}});
        }
        for (int i = 0; i <= nums; i++){
            visited.add(false);
            help.add(new StringBuilder(String.valueOf(i)));
        }
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int vertex = 1; vertex<=nums; vertex++){
            dfs(vertex, vertex);
            if (help.get(vertex).toString().contains(" ") || !visited.get(vertex) || graph.get(vertex) == null){
                stringBuilder.append(help.get(vertex).toString().split(" ").length).append("\n").append(help.get(vertex)).append("\n");
                count++;
            }
        }
        System.out.println(count);
        System.out.print(stringBuilder);
    }

    public static void dfs(int vertex, int start){
        if (vertex < visited.size()) visited.set(vertex, true);
        else visited.set(vertex, true);
        if (graph.get(vertex) != null)
            for (int edge : graph.get(vertex)) {
                if (!visited.get(edge)) {
                    help.get(start).append(" ").append(edge);
                    dfs(edge, start);
                }
            }

    }
}
