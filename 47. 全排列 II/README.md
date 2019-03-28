# 47. 全排列 II

### 我的解法：

在建立是否经过的解法的全排列基础上，加入判断之前没有经过且之前没有重复放入

### 其他解法：

交换时去重，去重条件为当前值与之前跟原值交换过的值不重复

    private boolean isDuplicate(int[] nums, int start, int end) {
        for (int j = start; j <end; j++) {
            if (nums[j]==nums[end]){
                return false;
            }
        }
        return true;
    }
