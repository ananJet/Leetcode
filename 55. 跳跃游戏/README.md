# 55. 跳跃游戏

动态规划，基本原理是每个点是否能跳到终点，是从当前点开始跳当前点的步数到对应点是否能够跳到终点的结果，最后返回dp[0]

状态转移方程


```
dp[i] = dp[i + 1] & dp[i + 2]......& dp[i + a[i]]
```


边界条件


```
dp[a.length - 1] = true
```
