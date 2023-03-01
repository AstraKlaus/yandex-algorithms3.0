import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cheapest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nums = reader.readLine();
        int rows = Integer.parseInt(nums.split(" ")[0]);
        int columns = Integer.parseInt(nums.split(" ")[1]);
        int[][] massive = new int[rows+1][columns+1];
        int[][] dp = new int[rows+1][columns+1];
        Arrays.fill(massive[0], 10100);
        Arrays.fill(dp[0], 10100);
        for (int i=1;i<=rows;i++){
            massive[i] = Arrays.copyOf(Arrays.stream( ("10100 " + reader.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray(), columns+1);
            dp[i][0] = 10100;
        }
        for (int i=1;i<=rows;i++){
            for (int j=1;j<=columns;j++){
                if (i == 1 && j ==1 ) { dp[1][1] = massive[1][1]; }
                else dp[i][j] = Integer.min(dp[i-1][j] + massive[i][j], dp[i][j-1] + massive[i][j]);
            }
        }
        System.out.println(dp[rows][columns]);
    }
}
