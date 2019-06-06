# 729. 我的日程安排表 I

构建一个记录着起始时间和结束时间的数组的链表，将每次预定的需求录入进去，在录入前进行判断，如果判断出现重合，不录入返回false，否则录入返回true

判断条件：
1、左交叉
2、右交叉
3、包括
4、被包括


```
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyCalendar {

    List<int[]> list;

    public MyCalendar() {
        this.list = new LinkedList<>();
    }

    public boolean book(int start, int end) {
        end--;
        for (int[] arr : this.list) {
            if ((start >= arr[0] && start <= arr[1]) || (end >= arr[0] && end <= arr[1]) || (start <= arr[0] && end >= arr[1]) || (start >= arr[0] && end <= arr[1]))
                return false;
        }
        this.list.add(new int[]{start, end});
//        for (int i = 0; i < this.list.size(); i++) {
//            System.out.println(Arrays.toString(this.list.get(i)));
//        }
//        System.out.println("-------------------");
        return true;
    }
}

```
