package data_structure.tree;

public class TreeNode
{
    public int info;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int info) {
        this.info = info;
    }

    public TreeNode(int info, TreeNode left, TreeNode right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}
