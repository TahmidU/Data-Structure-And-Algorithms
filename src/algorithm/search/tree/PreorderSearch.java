package algorithm.search.tree;

import data_structure.tree.TreeNode;

public class PreorderSearch implements ITreeSearch
{
    @Override
    public boolean search(int elt, TreeNode node) {
        if(node == null)
            return false;

        return node.info == elt || search(elt, node.left) || search(elt, node.right);
    }
}
