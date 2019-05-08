package com.roboslyq.datastruct;

public class BinaryTreeUtil {

    public void preOrder(BinaryTreeNode<Source> binaryTreeNode){
        if(binaryTreeNode != null) {
            System.out.println(binaryTreeNode.getT().getId());
            preOrder(binaryTreeNode.getLeftNode());
            preOrder(binaryTreeNode.getRightNode());
        }
    }
}
