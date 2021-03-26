package com.tahmidu.algorithm.search.tree;

import com.tahmidu.data_structure.tree.TreeNode;

public class PreorderTraversal implements ITreeSearch
{
    @Override
    public boolean search(int elt, TreeNode node) {
        if(node == null)
            return false;

        return node.info == elt || search(elt, node.left) || search(elt, node.right);
    }

    @Override
    public void print(TreeNode node) {

        if(node == null)
            return;

        System.out.println(node.info);
        print(node.left);
        print(node.right);

    }
}
