package com.tahmidu.algorithm.search.tree;

import com.sun.source.tree.Tree;
import com.tahmidu.data_structure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Breadth First Search
 */
public class BFSTraversal implements ITreeSearch
{
    @Override
    public boolean search(int elt, TreeNode node) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        TreeNode currentNode;

        while(!queue.isEmpty()){
            currentNode = queue.remove();

            if(currentNode.info == elt){
                return true;
            }else{
                if(currentNode.left != null)
                    queue.add(currentNode.left);

                if(currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }

        return false;
    }

    public void print(TreeNode node){

        if(node == null)
            return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        TreeNode currentNode;

        while(!queue.isEmpty()){
            currentNode = queue.remove();

            System.out.println(currentNode.info);

            if(currentNode.left != null)
                queue.add(currentNode.left);

            if(currentNode.right != null)
                queue.add(currentNode.right);

        }

    }
}
