package com.tahmidu.algorithm.search.tree;

import com.tahmidu.data_structure.tree.search_tree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InorderTraversalTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setUp(){
        binarySearchTree = new BinarySearchTree(5);
        binarySearchTree.setSearch(new InorderTraversal());
        binarySearchTree.add(20);
        binarySearchTree.add(11);
        binarySearchTree.add(40);
        binarySearchTree.add(33);
    }

    @Test
    public void search_shouldFindElem(){

        boolean actualResult = binarySearchTree.search(40);

        Assert.assertTrue(actualResult);
    }

    @Test
    public void search_shouldNotFindElem(){

        boolean actualResult = binarySearchTree.search(50);

        Assert.assertFalse(actualResult);
    }

}
