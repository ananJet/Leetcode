# 62. 不同路径

动态规划

机器人每次只能向下走一步或者向右走一步，因此若机器人在地图上任意一个点作为出发点，其路径总数为当前出发点下面一个格子和右边一个格子的走法之和，进而不断拆分为重叠的子问题，边界条件为底边和右边所有格子的路径数为1(只能向下或向右走)

状态转移方程

`dp[i][j] = dp[i + 1][j] + dp[i][j + 1]`

边界条件

`dp[m][j] = 1`

`dp[i][n-1] = 1`
