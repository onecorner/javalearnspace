package com.google.codeskill;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/*
* @since: 2019-01-11 09:31
* @author:htj
*
*
*/
public class TraverseTreeDemo  {

    public TreeNode createSampleNode(){
        TreeNode rootA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        rootA.setLeftNode(nodeB);
        rootA.setRightNode(nodeC);
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        nodeB.setLeftNode(nodeD);
        nodeB.setRightNode(nodeE);
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        nodeC.setLeftNode(nodeF);
        nodeC.setRightNode(nodeG);
        TreeNode nodeH = new TreeNode("H");
        nodeE.setLeftNode(nodeH);
        return rootA;
    }

    public void preTraverse(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.getValue());
        preTraverse(root.getLeftNode());
        preTraverse(root.getRightNode());
    }

    public void inTraverse(TreeNode root){
        if(root==null){
            return;
        }
        inTraverse(root.getLeftNode());
        System.out.println(root.getValue());
        inTraverse(root.getRightNode());
    }

    public void postTraverse(TreeNode root){
        if(root==null){
            return;
        }
        postTraverse(root.getLeftNode());
        postTraverse(root.getRightNode());
        System.out.println(root.getValue());
    }

    public static void main(String[] args) {
        TraverseTreeDemo createor = new TraverseTreeDemo();
        TreeNode sampleNode = createor.createSampleNode();
        createor.preTraverse(sampleNode);
        System.out.println();
        createor.inTraverse(sampleNode);
        System.out.println();
        createor.postTraverse(sampleNode);
    }

}

@Data
@ToString
@EqualsAndHashCode
class TreeNode{
    private final String value;
    private TreeNode leftNode;
    private TreeNode rightNode;


    public TreeNode(String value){
        this.value = value;
    }
}
