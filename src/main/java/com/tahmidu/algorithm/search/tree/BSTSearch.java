package com.tahmidu.algorithm.search.tree;

import com.tahmidu.data_structure.tree.TreeNode;

public class BSTSearch implements ITreeSearch
{
    @Override
    public boolean search(int elt, TreeNode node) {

        if(node == null)
            return false;

        if(node.info == elt)
            return true;

        if(elt > node.info)
            return search(elt, node.right);

        return search(elt, node.left);
    }
}
