package com.tahmidu.data_structure.tree.stack;

import com.tahmidu.data_structure.stack.Stack;
import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void pushAndPop_shouldReturnCorrectSequenceOnPop(){

        int[] arr = {1,2,3,4,5,6};
        int[] expectedArr = {6,5,4,3,2,1};

        Stack stack = new Stack(arr.length);
        for(int i : arr){
            stack.push(i);
        }

        for(int i : expectedArr){
            Assert.assertEquals(i, stack.pop());
        }

    }

    @Test
    public void size_shouldDoubleSizeOnNoSpace(){

        int[] arr = {1,2,3,4};

        Stack stack = new Stack(arr.length/2);
        for(int i = 0; i < arr.length/2; i++){
            stack.push(arr[i]);
        }

        Assert.assertEquals(arr.length/2, stack.stackLength());

        for(int i = arr.length/2; i < arr.length; i++){
            stack.push(arr[i]);
        }

        Assert.assertEquals(arr.length, stack.stackLength());
    }

}
