package com.wufuqiang.leetcode.heap;

public class MaxHeap {
    private int data[];
    private int size ;
    private int capacity;

    public MaxHeap(int maxSize){
        //数组索引为0的位置不放元素,方便找到子节点
        this.data = new int[maxSize+1];
        this.size = 0;
        this.capacity = maxSize;
    }

    public MaxHeap(int arr[],int maxSize){
        this.data = new int[maxSize+1];
        this.size = arr.length;
        this.capacity = maxSize;
        for(int i = 0;i<arr.length;i++){
            this.data[i+1] = arr[i];
        }
        for(int i = this.size ; i >= 1 ; i--){
            shiftDown(i);
        }
    }

    /**
     * 元素上移
     * @param index
     */
    private void shiftUp(int index){
        while(index > 1 && data[index]>data[index/2]){
            int tmp = data[index/2];
            data[index/2] = data[index];
            data[index] = tmp;
            index = index/2;
        }
    }

    public void insert(int d){
        if(size == capacity){
            System.out. println("堆已满");
            return;
        }
        data[size+1] = d;
        size+=1;
        shiftUp(size);
    }

    public int deleteMax(){
        int t = data[1];
        data[1] = data[size];
        size-=1;
        shiftDown(1);
        return t;
    }

    private void shiftDown(int index) {
        while(2*index <= size){
            int childIndex = 2*index;
            if(childIndex+1<=size && data[childIndex]<data[childIndex+1]){
                childIndex+=1;
            }
            if(data[index]>data[childIndex]){
                break;
            }
            int tmp = data[index];
            data[index] = data[childIndex];
            data[childIndex] = tmp;
            index = childIndex;
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
