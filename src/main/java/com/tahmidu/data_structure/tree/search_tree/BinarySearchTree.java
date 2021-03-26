package com.tahmidu.data_structure.tree.search_tree;

import com.tahmidu.algorithm.search.tree.*;
import com.tahmidu.data_structure.tree.TreeNode;

/**
 * Unbalanced Binary Search Tree is a tree data structure that place nodes on the right if they are greater than the parent and on
 * the left is they are less than the parent. In this version duplicate elements are not accepted.
 */
public class BinarySearchTree
{
    public TreeNode root;
    private ITreeSearch searchMode;

    public BinarySearchTree(TreeNode root, ITreeSearch searchMode) {
        this.root = root;
        this.searchMode = searchMode;
    }

    public BinarySearchTree(int rootElt)
    {
        root = new TreeNode(rootElt, null, null);
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void add(int elt)
    {
        add(elt, root);
    }

    private void add(int elt, TreeNode node)
    {
        if(elt < node.info && node.left == null)
        {
            node.left = new TreeNode(elt, null, null);
            return;
        }

        if(elt > node.info && node.right == null)
        {
            node.right = new TreeNode(elt, null, null);
            return;
        }

        if(elt < node.info) {
            add(elt, node.left);
            return;
        }

        if(elt > node.info)
            add(elt, node.right);
    }

    public void remove(int elt)
    {
        root = remove(elt, root);
    }
    
    public TreeNode remove(int elt, TreeNode node)
    {
        //Case 1: None
        if(node == null)
            return null;

        //Found value...
        if(node.info == elt)
        {
            //Case 2: No children
            if(node.left == null && node.right == null)
                return null;

            //Case 3: Only one child
            if(node.right == null)
                return node.left;

            if(node.left == null)
                return node.right;

            //Case 4: Has exactly 2 children
            //Since the successor is the smallest it would be a leaf. Leaf (case 2) would apply.
            node.info = findSuccessor(node.right);
            node.right = remove(node.info, node.right);
            return node;
        }

        //Traverse...
        if(elt < node.info)
        {
            node.left = remove(elt, node.left);
            return node;
        }

        node.right = remove(elt, node.right);
        return node;
    }

    private int findSuccessor(TreeNode node)
    {
        return node.left == null ? node.info : findSuccessor(node.left);
    }

    public void printTree(TreeNode node)
    {
        searchMode.print(node);
    }

    public boolean search(int elt)
    {
        if(searchMode == null)
            searchMode = new BFSTraversal();
        return searchMode.search(elt, root);
    }

    public void setSearch(ITreeSearch searchMode)
    {
        this.searchMode = searchMode;
    }
}
