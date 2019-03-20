import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottom {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> result = new LinkedList<>();

    public void levelTravel(TreeNode treeNode, int level) {
        if (treeNode == null)
            return;
        if (this.result.size() < level + 1)
            this.result.add(new LinkedList<Integer>());
        int level_next = level + 1;
        this.levelTravel(treeNode.left, level_next);
        this.levelTravel(treeNode.right, level_next);
        List<Integer> temp = this.result.get(level);
        temp.add(treeNode.val);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        this.levelTravel(root, 0);
        List<List<Integer>> res = new LinkedList<>();
        int n = this.result.size() - 1;
        for (int i = n; i >= 0; i--) {
            res.add(this.result.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LevelOrderBottom().result.get(0));
    }
}
