package com.tahmidu.algorithm.search.tree;

import com.tahmidu.data_structure.tree.TreeNode;

public class PostorderSearch implements ITreeSearch
{
    @Override
    public boolean search(int elt, TreeNode node)
    {
        if(node == null)
            return false;

        return search(elt, node.left) || search(elt, node.right) || node.info == elt;
    }
}
