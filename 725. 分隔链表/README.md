# 725. 分隔链表

将链表的长度与k做比较

分成3种情况

1、链表的长度比k小或相等，以长度1为1个pack，不够的用null补全

2、链表的长度比k大且能被k整除，将整除得到的结果作为pack，将链表划分为k个pack


```
int a = len % k;
int b = len / k;
int pack = b;
```


3、链表的长度比k大且不能被k整除


```
int a = len % k;
int b = len / k;
// 前一段的pack1
int pack1 = b + 1;
int pack1_len = k - (pack1 * k - len);
// 后一段的pack2
int pack2 = b;
int pack2_len = k - pack1_len;
```
