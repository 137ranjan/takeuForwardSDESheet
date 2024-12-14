package org.example.binarysearch;

import java.util.ArrayList;
import java.util.Collections;

public class AllocateBooks {
    public static int books(ArrayList<Integer> A, int B) {
        int n = A.size();

        if (B > n) {
            return -1;
        }

        int low = Collections.max(A);
        int high = A.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(A, mid);
            if (students > B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static int countStudents(ArrayList<Integer> A, int pages) {
        int n = A.size();
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + A.get(i) <= pages) {
                pagesStudent += A.get(i);
            } else {
                students++;
                pagesStudent = A.get(i);
            }
        }
        return students;
    }
}
