import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Knight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nums = reader.readLine();
        int rows = Integer.parseInt(nums.split(" ")[0]);
        int columns = Integer.parseInt(nums.split(" ")[1]);
        int[][] dp = new int[rows+2][columns+2];
        for (int i=0;i<=rows+1;i++){
            Arrays.fill(dp[i], -1);
        }
        for (int i=2;i<=rows+1;i++) {
            for (int j = 2; j <= columns+1; j++) {
                if (i == 2 && j == 2) { dp[2][2] = 1; }
                else {
                    if (dp[i-2][j-1] >= 0){
                        if (dp[i][j] == -1){
                            dp[i][j] = 0;
                        }
                        dp[i][j] += dp[i-2][j-1];
                    }
                    if (dp[i-1][j-2] >= 0){
                        if (dp[i][j] == -1){
                            dp[i][j] = 0;
                        }
                        dp[i][j] += dp[i-1][j-2];
                    }
                }
            }
        }
        if (dp[rows+1][columns+1] == -1) {
            System.out.println(0);
        }else System.out.println(dp[rows+1][columns+1]);
    }
}
