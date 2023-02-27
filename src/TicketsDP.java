import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TicketsDP {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[][] ans = new int[count + 3][3];
        ans[0][0] = 3601;
        ans[0][1] = 3601;
        ans[0][2] = 3601;
        ans[1][0] = 3601;
        ans[1][1] = 3601;
        ans[1][2] = 3601;
        ans[2][0] = 3601;
        ans[2][1] = 3601;
        ans[2][2] = 3601;
        int[] dp = new int[count+3];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for (int i = 3; i<=count+2;i++){
            System.arraycopy(Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(), 0, ans[i], 0, 3);
            dp[i] = Integer.min(dp[i-1] + ans[i][0], Integer.min(dp[i-2] + ans[i-1][1], dp[i-3] + ans[i-2][2]));
        }
        System.out.println(dp[count+2]);
    }
}
