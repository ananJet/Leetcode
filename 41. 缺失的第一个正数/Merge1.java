import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Merge1 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        if (n <= 1)
            return intervals;
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0; j--) {
//                Interval i1 = intervals.get(j);
//                Interval i2 = intervals.get(j - 1);
//                if (i1.start < i2.start) {
//                    intervals.remove(j);
//                    intervals.add(j, i2);
//                    intervals.remove(j - 1);
//                    intervals.add(j - 1, i1);
//                }
//            }
//        }
        intervals.sort(Comparator.comparing(interval -> interval.start));

        List<Interval> res = new LinkedList<>();
        int l = 0;
        int r = 0;
        int maxEnd = Integer.MIN_VALUE;
        while (true) {
//            System.out.println(l);
//            System.out.println(r);
            Interval i1 = intervals.get(l);
            Interval i2 = intervals.get(r);
            maxEnd = Math.max(i1.end, maxEnd);
            if (maxEnd >= i2.start) {
                r++;
            }else {
                res.add(new Interval(i1.start, maxEnd));
                l = r;
            }
            maxEnd = Math.max(maxEnd, i2.end);
            if (r == n) {
                res.add(new Interval(i1.start, maxEnd));
                break;
            }
        }
        return res;
    }
}
