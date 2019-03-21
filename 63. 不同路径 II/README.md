# 63. 不同路径 II

动态规划，与不同路径相似，边界条件缩减为终点开始，在递归时判断是否有障碍物

状态转移方程

`dp[i][j] = dp[i + 1][j] + dp[i][j + 1], if i < row && j < col `

`dp[i][j] = dp[i][j + 1], if i = row && j < col `

`dp[i][j] = dp[i + 1][j], if i < row && j = col `

边界条件

`dp[row][col] = 1, if obstacleGrid[row][col] = 0`

`dp[row][col] = 0, if obstacleGrid[row][col] = 1`

`dp[i][j] = 0, if obstacleGrid[row][col] = 1 `
