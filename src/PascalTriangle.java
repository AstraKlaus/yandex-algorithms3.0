import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> list = new ArrayList<>();
        list.add(0, Collections.singletonList(1));
        for (int i = 1; i <= numRows; i++){
            for (int j = 0; j < list.get(i-1).size()+1; j++){
                if (j == 0) {
                    list.add(new ArrayList<>(list.get(i-1).size()+1){{add(1);}});
                }else if (j == list.get(i-1).size()){
                    list.get(i).add(1);
                }else {
                    list.get(i).add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
        }
        System.out.println(list);
    }
}
