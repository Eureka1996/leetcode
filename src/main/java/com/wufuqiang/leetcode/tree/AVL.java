package com.wufuqiang.leetcode.tree;

import com.wufuqiang.leetcode.entries.AVLNode;

/**
 * @ author wufuqiang
 **/
public class AVL {

    private int getHeight(AVLNode<Integer> node){
        if(node != null){
            return node.height;
        }
        return 0;
    }

    private AVLNode<Integer> findMin(AVLNode<Integer> root){
        if(root == null) return null;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }


    /**
     * 左左单旋
     * @param node
     * @return
     */
    private AVLNode<Integer> singleRotateLeft(AVLNode<Integer> node){
        AVLNode<Integer> left = node.left;
        AVLNode<Integer> leftRight = left.right;
        node.left = leftRight;
        left.right = node;
        node.height = Math.max(getHeight(node.left),getHeight(node.right))+1;
        left.height = Math.max(getHeight(left.left),getHeight(left.right))+1;
        return left;
    }

    /**
     * 右右单旋
     * @param node
     * @return
     */
    private AVLNode<Integer> singleRotateRight(AVLNode<Integer> node){
        AVLNode<Integer> right = node.right;
        node.right = right.left;
        right.left = right;
        node.height = Math.max(getHeight(node.left),getHeight(node.right))+1;
        right.height = Math.max(getHeight(right.left),getHeight(right.right))+1;
        return right;
    }

    /**
     * 左右双旋
     * @param node
     * @return
     */
    private AVLNode<Integer> doubleRotateWithLeft(AVLNode<Integer> node){
        node.left = singleRotateRight(node.left);
        return singleRotateLeft(node);
    }

    /**
     * 右左双旋
     * @param node
     * @return
     */
    private AVLNode<Integer> doubleRotateWithRight(AVLNode<Integer> node){
        node.right = singleRotateLeft(node.right);
        return singleRotateRight(node);
    }

    public AVLNode<Integer> insert(AVLNode<Integer> root,int data){
        if(root == null){
            root = new AVLNode<Integer>(data);
        }else if(data < root.data){
            root.left = insert(root.left,data);
            if(getHeight(root.left)-getHeight(root.right) == 2){
                if(data < root.left.data){
                    root = singleRotateLeft(root);
                }else{
                    root = doubleRotateWithLeft(root);
                }
            }

        }else if(data > root.data){
            root.right = insert(root.right,data);
            if(getHeight(root.right) - getHeight(root.left) == 2){
                if(data < root.right.data){
                    root = doubleRotateWithRight(root);
                }else{
                    root = singleRotateRight(root);
                }
            }
        }
        root.height = Math.max(getHeight(root.left),getHeight(root.right))+1;
        return root;
    }

    public AVLNode<Integer> remove(AVLNode<Integer> root,int data){
        if(root == null){
            return null;
        }
        int result = root.data.compareTo(data);
        if(result < 0){
            root.right = remove(root.right,data);
            if(getHeight(root.left) - getHeight(root.right) == 2){
                AVLNode<Integer> currentNode = root.left;
                if(getHeight(currentNode.right) > getHeight(currentNode.left)){
                    root = singleRotateRight(root);
                }else{
                    root = doubleRotateWithRight(root);
                }
            }
        }else if(result > 0){
            root.left = remove(root.left,data);
            if(getHeight(root.right)-getHeight(root.left) == 2){
                AVLNode<Integer> currentNode = root.right;
                if(getHeight(currentNode.left)>getHeight(currentNode.right)){
                    root = singleRotateLeft(root);
                }else{
                    root = doubleRotateWithLeft(root);
                }
            }
        }
        //要删除的节点有两个孩子
        else if(root.right != null && root.left != null){
            root.data = findMin(root.right).data;
            root.right = remove(root.right,root.data);
        }
        //要删除的节点只有一个孩子或是叶子节点
        else{
            root = root.left != null ? root.left:root.right;
        }
        //更新高度
        if(root != null)
            root.height = Math.max(getHeight(root.left),getHeight(root.right))+1;
        return root;
    }
}
