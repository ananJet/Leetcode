# 排序

### 冒泡排序
不断向头部或者尾部将每次遍历的最大最小值冒泡

1、两个for循环，第一层循环是遍历次数，第二层循环是从1到当前冒泡的位置(由数组长度和当前遍历次数相减得出)

2、按照升序还是降序比较交换位置

3、设置当前遍历是否有交换位置的flag，如果没有则提前结束循环

### 选择排序
每次选择剩余数组中最大或者最小值排在前面

两个for循环，第一个循环是遍历数组`nums.length - 1`次，第二层循环找当前循环位置之后的最小数(或者最大数)，找到之后交换找到的位置与当前循环的位置`i`上的数

### 插入排序
不断向有序的数组中插入

两个for循环，第一个循环从1开始遍历数组，第二个循环从第一个循环当前的索引值开始倒推，逐步比较相邻的两个数组值，按照升序或者降序交换

### 希尔排序



