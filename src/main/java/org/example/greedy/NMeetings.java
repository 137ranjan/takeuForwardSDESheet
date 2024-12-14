package org.example.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetings {
    public static int maxMeetings(int[] start, int[] end) {
        List<Interval> intervalList = new ArrayList<>();
        int n = start.length;
        for (int i = 0; i < n; i++) {
            intervalList.add(new Interval(start[i], end[i], i + 1));
        }
        Collections.sort(intervalList);

        int count = 1;
        int prevEndTime = intervalList.get(0).end;
        List<Interval> selectedIntervals = new ArrayList<>();
        selectedIntervals.add(intervalList.get(0));
        for (int i = 1; i < n; i++) {
            if (intervalList.get(i).start > prevEndTime) {
                count = count + 1;
                prevEndTime = intervalList.get(i).end;
                selectedIntervals.add(intervalList.get(i));
            }
        }
        System.out.println(selectedIntervals);
        return count;
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;
    int pos;

    public Interval(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }

    public int compareTo(Interval interval) {
        return this.end - interval.end;
    }

    public String toString() {
        return "Interval[" + this.start + "," + this.end + "]";
    }
}
