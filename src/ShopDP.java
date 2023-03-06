import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ShopDP {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(reader.readLine());
        int[][] dp = new int[nums+1][nums+2];
        int[][] help = new int[nums+1][nums+2];
        Arrays.fill(dp[0], 111110);
        dp[0][0] = 0;
        for (int i=1;i<=nums;i++) {
            int minim;
            int money = Integer.parseInt(reader.readLine());
            for (int j = 0; j <= nums; j++) {
                if (money>100){
                    if (j>0){
                        minim = Integer.min(dp[i-1][j-1] + money, Integer.min(dp[i-1][j+1], dp[i-1][j] + money));
                        dp[i][j] = minim;
                        if (minim == dp[i-1][j-1] + money) help[i][j] = j-1;
                        else if (minim == dp[i-1][j+1]) help[i][j] = j+1;
                        else help[i][j] = j;
                    }
                    else if (i != 1){
                        minim = Integer.min(dp[i-1][j+1], dp[i-1][j] + money);
                        dp[i][j] = minim;
                        if (minim == dp[i-1][j+1]) help[i][j] = j+1;
                        else help[i][j] = j;
                    }
                    else dp[i][j] = 111110;
                }else{
                    minim = Integer.min(dp[i-1][j] + money, dp[i-1][j+1]);
                    dp[i][j] = minim;
                    if (minim == dp[i-1][j+1]) help[i][j] = j+1;
                    else help[i][j] = j;
                }
                dp[i][nums+1] = 111110;
            }
        }
        int minim = Arrays.stream(dp[nums]).min().getAsInt();
        int index = 0;
        for (int j = nums+1; j >= 0; j--){
            if (dp[nums][j] == minim){
                index = j;
                break;
            }
        }
        System.out.println(minim);
        System.out.print(index + " ");
        Stack<Integer> stack = new Stack<>();
        int i = nums;
        while (i != 0){
            if (index < help[i][index]) stack.push(i);
            index = help[i][index];
            i--;
        }
        System.out.print(stack.size());
        while (!stack.isEmpty()) System.out.print("\n" + stack.pop());
    }
}
