package com.tahmidu.algorithm.search.tree;

import com.tahmidu.data_structure.tree.TreeNode;

public class InorderSearch implements ITreeSearch
{
    @Override
    public boolean search(int elt, TreeNode node) {
        if(node == null)
            return false;

        return search(elt, node.left) || node.info == elt || search(elt, node.right);
    }
}
