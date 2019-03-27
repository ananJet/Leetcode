# 105. 从前序与中序遍历序列构造二叉树

根据前序顺序去中序数组中找根结点，递归构造每个结点的左子树和右子树

左子树

        root.left = this.dg(left_pre + 1, left_pre + index - left_in, left_in, index - 1);


右子树

        root.right = this.dg(left_pre + 1 + index - left_in, right_pre,  index + 1, right_in);

其中index为前序中找到的根结点在中序中的索引值
