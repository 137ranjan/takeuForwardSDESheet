package org.example.heaps;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private static List<Integer> container = new ArrayList<>();

    public static int[] minHeap(int n, int[][] q) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (q[i][0] == 0) {
                add(q[i][1]);
            } else if (q[i][0] == 1) {
                output.add(remove());
            }
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void add(int item) {
        List<Integer> temp = new ArrayList<>();
        int i = 0;
        for (; i < container.size() && container.get(i) < item; i++) {
            temp.add(container.get(i));
        }
        temp.add(item);
        for (; i < container.size(); i++) {
            temp.add(container.get(i));
        }
        container = temp;
    }

    public static int remove() {
        return container.remove(0);
    }

    public static int getSmallest() {
        return container.get(0);
    }


}
