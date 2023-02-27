import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n+1];
        int[] help = new int[n+1];
        Deque<Integer> stack = new LinkedList<>();
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++){
            if (i % 2 == 0 && (dp[i] == -1 || dp[i/2] + 1 < dp[i])){
                dp[i] = dp[i/2] + 1;
                help[i] = i/2;
            }
            if (i % 3 == 0 && (dp[i] == -1 || dp[i/3] + 1 < dp[i])){
                dp[i] = dp[i/3] + 1;
                help[i] = i/3;
            }
            if (dp[i] == -1 || dp[i-1] + 1 < dp[i]){
                dp[i] = dp[i-1] + 1;
                help[i] = i-1;
            }
        }
        stack.add(n);
        while (stack.getLast() != 1){
            stack.add(help[stack.getLast()]);
        }
        System.out.println(dp[n]);
        while (!stack.isEmpty()){
            System.out.print(stack.pollLast() + (stack.size() != 0 ? " " : ""));
        }
    }
}
