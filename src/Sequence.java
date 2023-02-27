import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[] ans = new int[count + 1];
        if (count >= 0) ans[0] = 2;
        if (count >= 1) ans[1] = 4;
        if (count >= 2) ans[2] = 7;
        if (count >= 3)
        for (int i = 3; i < count; i++) {
            ans[i] = (Arrays.stream(Arrays.copyOfRange(ans,i-3,i)).sum());
        }
        System.out.println(ans[count-1]);
    }
}