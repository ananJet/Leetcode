# 80. 删除排序数组中的重复项 II

### 我的解法

`last`为上一个数组元素的标志，`time`为上一个数组元素出现的次数，`delete`为重复元素出现的总次数（用于将前面对应位置有重复的元素置换为后面的新元素）

遍历一次数组，更新3个标志，当`delete`大于0时，修改前面元素

### 其他解法

维护一个索引`i`，当不是重复项时才++（如果当前元素比`i-2`大，更新元素）
