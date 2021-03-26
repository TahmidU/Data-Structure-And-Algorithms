package com.tahmidu.algorithm.search.tree;

import com.tahmidu.data_structure.tree.TreeNode;

public class PostorderTraversal implements ITreeSearch
{
    @Override
    public boolean search(int elt, TreeNode node)
    {
        if(node == null)
            return false;

        return search(elt, node.left) || search(elt, node.right) || node.info == elt;
    }

    @Override
    public void print(TreeNode node) {

        if(node == null)
            return;

        print(node.left);
        print(node.right);
        System.out.println(node.info);
    }
}
