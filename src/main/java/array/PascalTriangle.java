package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> outerList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            List<Integer> innerList = new ArrayList<>();
            innerList.add(1);
            outerList.add(innerList);
        }

        if(n > 1) {
            outerList.get(1).add(1);
            for(int i = 2; i < n; i++) {
                for(int j = 1; j < i; j++) {
                    int num = outerList.get(i-1).get(j-1) + outerList.get(i-1).get(j);
                    outerList.get(i).add(num);
                }
                outerList.get(i).add(1);
            }
        }

        return outerList;
    }
}
