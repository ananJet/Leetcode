# 135. 分发糖果

### 我的解法

先找谷底，赋值为1，然后按照谷底将原数组划分为若干区间，对每个区间分别从左右两边开始加1，一直加到峰顶，峰顶元素先不加

然后对峰顶元素的情况分成3类

1、没有峰顶元素的情况，即左右两边均是谷底，不做操作

2、峰顶只有1个元素时，取两边元素分得糖果最大的情况加1作为峰顶分得糖果的值

3、峰顶有2个相同元素的情况，左峰顶对其左边分得的糖果数加1，右峰顶对其右边分得的糖果数加1

### 其他解法

先给每个人一个糖，初始化tmp数组为额外糖果。从左向右遍历，如果i+1分数高，tmp[i+1]=tmp[i]+1。再从后往前遍历，如果i比i+1分数高，那么比较tmp[i]和tmp[i+1]+1，如果tmp[i]小，更新。假如分数i-1<i，那么下一次继续检查，如果分数i-1>i，因为第一次tmp[i]>tmp[i-1]，从右往左更新tmp[i]只可能增加，依然满足大小关系


```
class Solution:
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        s = 0
        n=len(ratings)
        s+=n
        tmp =[0]*n
        for i in range(1,n):
            if ratings[i]>ratings[i-1]:
                tmp[i] = tmp[i-1]+1
        for i in range(n-2,-1,-1):
            if ratings[i]>ratings[i+1]:
                tmp[i]=max(tmp[i],tmp[i+1]+1)
        s+=sum(tmp)
        return s
```
