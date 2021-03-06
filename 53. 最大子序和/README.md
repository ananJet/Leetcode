# 53. 最大子序和

### 我的解法：
分治算法，递归将字符串拆成两半，求左半边和右半边分别的最大子序和，以及左半边和右半边连接的子序和（分别从中间向左遍历和从中间向右遍历再求和），比较得到的3个数大小，取最大者为该部分的最大子序和

### 其他解法：
>- 动态规划，从头到尾遍历一次数组，`i`状态的计算用到`i-1`状态的值，建立一个一维数组存放`i`个子状态，找所有状态中的最大值，状态转移方程是`sum(i) = max{sum(i - 1) + a[i], a[i]}`
>- 数学原理，从头到尾遍历数组，做累加，如果`sum`大于0，继续累加，如果小于0，将累加和置为当前值，每次遍历过程中维护一个`res`存放遍历过程中找到的累加和最大值
