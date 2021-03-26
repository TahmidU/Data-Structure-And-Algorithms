package com.tahmidu.algorithm.search.tree;

import com.tahmidu.data_structure.tree.TreeNode;

public class InorderTraversal implements ITreeSearch
{
    @Override
    public boolean search(int elt, TreeNode node) {
        if(node == null)
            return false;

        return search(elt, node.left) || node.info == elt || search(elt, node.right);
    }

    @Override
    public void print(TreeNode node) {
        if(node == null)
            return;

        print(node.left);
        System.out.println(node.info);
        print(node.right);
    }
}
