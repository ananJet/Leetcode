public class Search1 {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }
//        二分查找，找转折点
        int trans = -1;
        int low = 0;
        int up = nums.length - 1;
        int mid = -1;
        if (nums[0] > nums[nums.length - 1]) {
            if (nums.length == 2)
                trans = nums.length - 1;
            else {
                while (low <= up) {
                    mid = (int) Math.ceil((up + low) / 2.0);
                    if (nums[mid - 1] > nums[mid]) {
                        trans = mid;
                        break;
                    }else if (nums[0] < nums[mid]) {
                        low = mid + 1;
                    }else if (nums[0] > nums[mid]) {
                        up = mid - 1;
                    }
                }
            }
        }else {
            trans = 0;
        }

//        根据找到的转折点分段进行二分查找
        int left = -1;
        int right = -1;
        int trans_left = trans == 0 ? trans : trans - 1;
        if (target >= nums[0] && target <= nums[trans_left]) {
            left = 0;
            right = trans;
        }else {
            left = trans;
            right = nums.length - 1;
        }
        low = left;
        up = right;
        int res = -1;
//        System.out.println(low + "\t" + up);
        while (low <= up) {
            mid = (low + up) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            }else if (nums[mid] < target) {
                low++;
            }else {
                up--;
            }
        }
        return res;
    }



    public int search1(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = -1;
        int right = -1;

//        寻找用于二分查找的有序区间
        int low = 0;
        int up = nums.length - 1;
        int mid = -1;
        while (low <= up) {
            mid = (low + up) / 2;
//            判断有序数组
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    left = low;
                    right = mid;
                    break;
                }else {
                    low = mid + 1;
                }
            }else {
                if (target >= nums[mid] && target <= nums[up]) {
                    left = mid;
                    right = up;
                    break;
                }else {
                    up = mid - 1;
                }
            }
        }

//        找到区间后针对目标值对区间进行二分查找
        low = left;
        up = right;
        int res = -1;
//        System.out.println(low + "\t" + up);
        if (left != -1) {
            while (low <= up) {
                mid = (low + up) / 2;
                if (nums[mid] == target) {
                    res = mid;
                    break;
                }else if (nums[mid] < target) {
                    low++;
                }else {
                    up--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Search1().search1(new int[]{4,5,6,7,0,1,2,0}, 3));
    }
}
