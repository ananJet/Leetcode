# 19. 删除链表的倒数第N个节点

先遍历一次链表，得到链表的总长度，然后用总长度`l`减去倒数第N个节点的`n`得到第二次遍历链表的次数，设置last和target为分别指向删除的目标结点上一结点和目标结点的指针，做删除目标节点的操作
