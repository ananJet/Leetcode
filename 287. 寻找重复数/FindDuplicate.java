import java.util.Arrays;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
//        快慢指针找到相遇点
        int meet = -1;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                meet = slow;
                break;
            }
        }
//        两个指针分别从头结点和入口结点相遇找到环的入口
        int head = 0;
        while (true) {
            meet = nums[meet];
            head = nums[head];
            if (meet == head)
                return meet;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,5,9,6,9,3,8,9,7,1};
//        System.out.println(a[8]);
//        System.out.println(a[a[6]]);
        System.out.println(new FindDuplicate().findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }
}
