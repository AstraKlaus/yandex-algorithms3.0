import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Expensive {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nums = reader.readLine();
        int rows = Integer.parseInt(nums.split(" ")[0]);
        int columns = Integer.parseInt(nums.split(" ")[1]);
        int[][] massive = new int[rows+1][columns+1];
        int[][] dp = new int[rows+1][columns+1];
        byte[][] help = new byte[rows+1][columns+1];
        Arrays.fill(massive[0], -1);
        Arrays.fill(dp[0], -1);
        for (int i=1;i<=rows;i++){
            massive[i] = Arrays.copyOf(Arrays.stream(("-1 " + reader.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray(), columns+1);
            dp[i][0] = -1;
        }
        int up;
        int left;
        for (int i=1;i<=rows;i++){
            for (int j=1;j<=columns;j++){
                up = dp[i-1][j] + massive[i][j];
                left = dp[i][j-1] + massive[i][j];
                if (i == 1 && j ==1 ) { dp[1][1] = massive[1][1]; help[i][j] = 10;}
                else {
                    if (up >= left){
                        dp[i][j] = up;
                        help[i][j] = 1;
                    }else{
                        dp[i][j] = left;
                        help[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(dp[rows][columns]);
        Stack<Byte> stack = new Stack<>();
        byte current = help[rows][columns];
        int i = rows;
        int j = columns;
        while (current != 10){
            if (current == 1){
                stack.push((byte) 1);
                current = help[--i][j];
            }else if (current == 0){
                stack.push((byte) 0);
                current = help[i][--j];
            }
        }
        while (!stack.isEmpty()) {
            System.out.print((stack.pop() == 0 ? "R" : "D") + (!stack.isEmpty() ? " " : ""));
        }
    }
}
