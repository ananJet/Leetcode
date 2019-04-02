import java.util.Arrays;

public class Trap {

    public int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int begin_index = -1;
        int end_index = -1;

        int last = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= last) {
                last = height[i];
            }else {
                begin_index = i - 1;
                break;
            }
        }

        last = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] >= last) {
                last = height[i];
            }else {
                end_index = i + 1;
                break;
            }
        }
        if (begin_index == -1 || end_index == -1 || begin_index >= end_index)
            return 0;

        int res = 0;
        int left = begin_index;
        int right = begin_index;
        boolean[] flag = new boolean[height.length];
        flag[begin_index] = true;
        flag[end_index] = true;
        while (right < end_index) {
//            ÏÈµÝ¼õ
            while (height[right + 1] <= height[right]) {
                right++;
            }
//            ÔÙµÝÔö
            while (height[right + 1] > height[right]) {
                right++;
                if (right == end_index)
                    break;
            }
            if (right == end_index)
                break;
            flag[right] = true;
            while (height[right + 1] == height[right]) {
                right++;
            }
            left = right;
        }

        left = begin_index;
        while (left < end_index) {
            int r = end_index;
            for (int i = left + 1; i <= end_index; i++) {
                if (flag[i] && height[i] >= height[left]) {
                    r = i;
                    break;
                }
            }
            if (r == end_index) {
                for (int i = left + 1; i <= end_index; i++) {
                    if (flag[i] && height[i] >= height[r]) {
                        r = i;
                    }
                }
            }
            int top = Math.min(height[r], height[left]);
            int t = r - 1;
            for (int i = left + 1; i <= t; i++) {
                if (height[i] < top)
                    res += top - height[i];
            }
            left = r;
        }
//        System.out.println(Arrays.toString(flag));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[]{2,8,5,5,6,1,7,4,5}));
    }
}
