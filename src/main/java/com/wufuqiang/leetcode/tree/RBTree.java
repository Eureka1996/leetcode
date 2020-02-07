package com.wufuqiang.leetcode.tree;

import com.wufuqiang.leetcode.entries.RBNode;

/**
 * @ author wufuqiang
 **/
public class RBTree<T extends Comparable<T>> {
    private final RBNode<T> root;

    //记录节点个数
    private java.util.concurrent.atomic.AtomicLong size =
            new java.util.concurrent.atomic.AtomicLong(0);

    //in overwrite mode,all node's value can not  has same	value
    //in non-overwrite mode,node can have same value, suggest don't use non-overwrite mode.
    private volatile boolean overrideMode=true;

    public RBTree(){
        this.root = new RBNode<T>();
    }

    public RBTree(boolean overrideMode){
        this();
        this.overrideMode=overrideMode;
    }

    public boolean isOverrideMode() {
        return overrideMode;
    }

    public void setOverrideMode(boolean overrideMode) {
        this.overrideMode = overrideMode;
    }

    /**
     * number of tree number
     * @return
     */
    public long getSize() {
        return size.get();
    }
    /**
     * get the root node
     * @return
     */
    private RBNode<T> getRoot(){
        return root.getLeft();
    }

    public T addNode(T value){
        RBNode<T> t = new RBNode<T>(value);
        return addNode(t);
    }

    private T addNode(RBNode<T> node){
        node.setLeft(null);
        node.setRight(null);
        //新插入的节点，初始都有红节点
        node.setRed(true);
        setParent(node,null);
        if(root.getLeft()==null){
            //作为红黑树的第一个节点插入
            root.setLeft(node);
            node.setRed(false);
            size.incrementAndGet();
        }else{
            RBNode<T> x = findParentNode(node);
            int cmp = x.getValue().compareTo(node.getValue());

            //
            if(this.overrideMode && cmp==0){
                T v = x.getValue();
                x.setValue(node.getValue());
                //返回原数据的value值
                return v;
            }else if(cmp==0){
                //要插入的node的value值已经存在，则返回已经存在的value值
                return x.getValue();
            }

            //为插入的node节点设置父亲节点
            setParent(node,x);

            if(cmp>0){
                x.setLeft(node);
            }else{
                x.setRight(node);
            }

            fixInsert(node);
            size.incrementAndGet();
        }
        return null;
    }

    /**
     * 插入之后，对红黑树进行修复
     * @param node 新插入的节点
     */
    private void fixInsert(RBNode<T> node){
        RBNode<T> parent = node.getParent();
        //父亲节点不为null，且父亲节点为红时需要进行修复
        while(parent!=null && parent.isRed()){
            RBNode<T> uncle = getUncle(node);
            if(uncle==null){//need to rotate
                RBNode<T> ancestor = parent.getParent();
                //ancestor is not null due to before before add,tree color is balance
                //父亲节点是祖父节点的左孩子
                if(parent == ancestor.getLeft()){
                    boolean isRight = node == parent.getRight();
                    //node节点是父亲节点的右孩子
                    if(isRight){
                        rotateLeft(parent);
                    }
                    rotateRight(ancestor);

                    if(isRight){
                        node.setRed(false);
                        parent=null;//end loop
                    }else{
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                }
                //父亲节点是祖父节点的右孩子
                else{
                    boolean isLeft = node == parent.getLeft();
                    if(isLeft){
                        rotateRight(parent);
                    }
                    rotateLeft(ancestor);

                    if(isLeft){
                        node.setRed(false);
                        parent=null;//end loop
                    }else{
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                }
            }
            //插入过程中，如果叔父节点存在则必为红节点
            else{
                parent.setRed(false);
                uncle.setRed(false);
                parent.getParent().setRed(true);
                //循环条件
                node=parent.getParent();
                parent = node.getParent();
            }
        }
        getRoot().makeBlack();
        getRoot().setParent(null);
    }

    /**
     * 设置父亲节点
     * @param node
     * @param parent
     */
    private void setParent(RBNode<T> node,RBNode<T> parent){
        if(node!=null){
            node.setParent(parent);
            if(parent==root){
                node.setParent(null);
            }
        }
    }

    /**
     * 获取叔父节点
     * @param node
     * @return
     */
    private RBNode<T> getUncle(RBNode<T> node){
        RBNode<T> parent = node.getParent();
        RBNode<T> ancestor = parent.getParent();
        if(ancestor == null){
            return null;
        }
        if(parent == ancestor.getLeft()){
            return ancestor.getRight();
        }else{
            return ancestor.getLeft();
        }
    }

    /**
     * find the parent node to hold node x,if parent value equals x.value return parent.
     * 找到value值相同的第一个节点
     * 如果没有value相同的，则找到插入node后的父节点
     * @param node
     * @return
     */
    private RBNode<T> findParentNode(RBNode<T> node){
        RBNode<T> dataRoot = getRoot();
        RBNode<T> child = dataRoot;
        while(child != null){
            int cmp = child.getValue().compareTo(node.getValue());
            if(cmp == 0){
                return child;
            }
            if(cmp > 0){
                dataRoot = child;
                child = child.getLeft();
            }else if(cmp < 0){
                dataRoot = child;
                child = child.getRight();
            }
        }
        return dataRoot;
    }

    private void rotateLeft(RBNode<T> node){
        RBNode<T> right = node.getRight();
        //右孩子不存在，无法做左旋操作
        if(right==null){
            throw new java.lang.IllegalStateException("right node is null");
        }
        RBNode<T> parent = node.getParent();
        node.setRight(right.getLeft());
        setParent(right.getLeft(),node);

        right.setLeft(node);
        setParent(node,right);

        if(parent==null){//node pointer to root
            //right  raise to root node
            root.setLeft(right);
            setParent(right,null);
        }else{
            if(parent.getLeft()==node){
                parent.setLeft(right);
            }else{
                parent.setRight(right);
            }
            //right.setParent(parent);
            setParent(right,parent);
        }
    }

    private void rotateRight(RBNode<T> node){
        RBNode<T> left = node.getLeft();
        if(left==null){
            throw new java.lang.IllegalStateException("left node is null");
        }
        RBNode<T> parent = node.getParent();
        node.setLeft(left.getRight());
        setParent(left.getRight(),node);

        left.setRight(node);
        setParent(node,left);

        if(parent==null){
            root.setLeft(left);
            setParent(left,null);
        }else{
            if(parent.getLeft()==node){
                parent.setLeft(left);
            }else{
                parent.setRight(left);
            }
            setParent(left,parent);
        }
    }

    public T find(T value){
        RBNode<T> dataRoot = getRoot();
        while(dataRoot!=null){
            int cmp = dataRoot.getValue().compareTo(value);
            if(cmp<0){
                dataRoot = dataRoot.getRight();
            }else if(cmp>0){
                dataRoot = dataRoot.getLeft();
            }else{
                return dataRoot.getValue();
            }
        }
        return null;
    }

    public T remove(T value){
        RBNode<T> dataRoot = getRoot();
        RBNode<T> parent = root;

        while(dataRoot!=null){
            int cmp = dataRoot.getValue().compareTo(value);
            if(cmp<0){
                parent = dataRoot;
                dataRoot = dataRoot.getRight();
            }else if(cmp>0){
                parent = dataRoot;
                dataRoot = dataRoot.getLeft();
            }else{
                if(dataRoot.getRight()!=null){
                    RBNode<T> min = removeMin(dataRoot.getRight());
                    //x used for fix color balance
                    RBNode<T> x = min.getRight()==null ? min.getParent() : min.getRight();
                    boolean isParent = min.getRight()==null;

                    min.setLeft(dataRoot.getLeft());
                    setParent(dataRoot.getLeft(),min);
                    //判断要删除的是左孩子还是右孩子
                    if(parent.getLeft()==dataRoot){
                        parent.setLeft(min);
                    }else{
                        parent.setRight(min);
                    }
                    setParent(min,parent);

                    boolean curMinIsBlack = min.isBlack();
                    //inherit dataRoot's color
                    //min节点继承要删除节点的颜色
                    min.setRed(dataRoot.isRed());

                    if(min!=dataRoot.getRight()){
                        min.setRight(dataRoot.getRight());
                        setParent(dataRoot.getRight(),min);
                    }
                    //remove a black node,need fix color
                    if(curMinIsBlack){
                        //后继替换节点不是待删除节点的右孩子
                        if(min!=dataRoot.getRight()){
                            fixRemove(x,isParent);
                        }
                        else if(min.getRight()!=null){
                            fixRemove(min.getRight(),false);
                        }else{
                            fixRemove(min,true);
                        }
                    }
                }else{
                    setParent(dataRoot.getLeft(),parent);
                    if(parent.getLeft()==dataRoot){
                        parent.setLeft(dataRoot.getLeft());
                    }else{
                        parent.setRight(dataRoot.getLeft());
                    }
                    //current node is black and tree is not empty
                    if(dataRoot.isBlack() && !(root.getLeft()==null)){
                        RBNode<T> x = dataRoot.getLeft()==null
                                ? parent :dataRoot.getLeft();
                        boolean isParent = dataRoot.getLeft()==null;
                        fixRemove(x,isParent);
                    }
                }
                setParent(dataRoot,null);
                dataRoot.setLeft(null);
                dataRoot.setRight(null);
                if(getRoot()!=null){
                    getRoot().setRed(false);
                    getRoot().setParent(null);
                }
                size.decrementAndGet();
                return dataRoot.getValue();
            }
        }
        return null;
    }
    /**
     * fix remove action
     * 1. 待删除的节点的兄弟节点是红色的节点。
     * 2. 待删除的节点的兄弟节点是黑色的节点，且兄弟节点的子节点都是黑色的。
     * 3. 待调整的节点的兄弟节点是黑色的节点，且兄弟节点的左子节点是红色的，右节点是黑色的(兄弟节点在右边)，如果兄弟节点在左边的话，就是兄弟节点的右子节点是红色的，左节点是黑色的。
     * 4. 待调整的节点的兄弟节点是黑色的节点，且右子节点是是红色的(兄弟节点在右边)，如果兄弟节点在左边，则就是对应的就是左节点是红色的。
     * @param node
     * @param isParent
     */
    private void fixRemove(RBNode<T> node,boolean isParent){
        RBNode<T> cur = isParent ? null : node;
        boolean isRed = isParent ? false : node.isRed();
        RBNode<T> parent = isParent ? node : node.getParent();

        while(!isRed && !isRoot(cur)){
            RBNode<T> sibling = getSibling(cur,parent);
            //sibling is not null,due to before remove tree color is balance

            //if cur is a left node
            boolean isLeft = parent.getRight()==sibling;
            if(sibling.isRed() && !isLeft){//case 1
                //cur in right
                parent.makeRed();
                sibling.makeBlack();
                rotateRight(parent);
            }else if(sibling.isRed() && isLeft){
                //cur in left
                parent.makeRed();
                sibling.makeBlack();
                rotateLeft(parent);
            }else if(isBlack(sibling.getLeft()) && isBlack(sibling.getRight())){//case 2
                sibling.makeRed();
                cur = parent;
                isRed = cur.isRed();
                parent=parent.getParent();
            }else if(isLeft && !isBlack(sibling.getLeft())
                    && isBlack(sibling.getRight())){//case 3
                sibling.makeRed();
                sibling.getLeft().makeBlack();
                rotateRight(sibling);
            }else if(!isLeft && !isBlack(sibling.getRight())
                    && isBlack(sibling.getLeft()) ){
                sibling.makeRed();
                sibling.getRight().makeBlack();
                rotateLeft(sibling);
            }else if(isLeft && !isBlack(sibling.getRight())){//case 4
                sibling.setRed(parent.isRed());
                parent.makeBlack();
                sibling.getRight().makeBlack();
                rotateLeft(parent);
                cur=getRoot();
            }else if(!isLeft && !isBlack(sibling.getLeft())){
                sibling.setRed(parent.isRed());
                parent.makeBlack();
                sibling.getLeft().makeBlack();
                rotateRight(parent);
                cur=getRoot();
            }
        }
        if(isRed){
            cur.makeBlack();
        }
        if(getRoot()!=null){
            getRoot().setRed(false);
            getRoot().setParent(null);
        }

    }

    /**
     * find the successor node
     * @param node current node's right node
     * @return
     */
    private RBNode<T> removeMin(RBNode<T> node){
        //find the min node
        RBNode<T> parent = node;
        while(node!=null && node.getLeft()!=null){
            parent = node;
            node = node.getLeft();
        }
        //remove min node
        if(parent==node){
            return node;
        }

        parent.setLeft(node.getRight());
        setParent(node.getRight(),parent);

        //don't remove right pointer,it is used for fixed color balance
        //node.setRight(null);
        return node;
    }

    private boolean isRoot(RBNode<T> node){
        return root.getLeft() == node && node.getParent()==null;
    }

    private boolean isBlack(RBNode<T> node){
        return node==null || node.isBlack();
    }

    //get sibling node
    private RBNode<T> getSibling(RBNode<T> node,RBNode<T> parent){
        parent = node==null ? parent : node.getParent();
        if(node==null){
            return parent.getLeft()==null ? parent.getRight() : parent.getLeft();
        }
        if(node==parent.getLeft()){
            return parent.getRight();
        }else{
            return parent.getLeft();
        }
    }
}
