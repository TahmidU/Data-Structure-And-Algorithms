package com.tahmidu.data_structure.tree.search_tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setUp(){
        binarySearchTree = new BinarySearchTree(5);
    }

    @Test
    public void isEmpty_shouldReturnTrue(){

        binarySearchTree.root = null;
        boolean isEmptyResult = binarySearchTree.isEmpty();

        Assert.assertTrue(isEmptyResult);
    }

    @Test
    public void isEmpty_shouldReturnFalse(){
        binarySearchTree.add(20);
        binarySearchTree.add(11);
        binarySearchTree.add(40);
        binarySearchTree.add(33);

        boolean isEmptyResult = binarySearchTree.isEmpty();

        Assert.assertFalse(isEmptyResult);
    }

    @Test
    public void add_shouldAddNodeWithElem(){

        int expectedElem = 20;
        binarySearchTree.add(expectedElem);

        int actualElem = binarySearchTree.root.right.info;

        Assert.assertEquals(expectedElem, actualElem);
    }

    @Test
    public void remove_shouldRemoveNodeWithElem(){

        int expectedElem = 20;
        binarySearchTree.add(expectedElem);
        binarySearchTree.remove(expectedElem);

        Object actualElem = binarySearchTree.root.right;

        Assert.assertNull(actualElem);
    }

}
