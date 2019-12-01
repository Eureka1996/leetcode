package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.heap.MaxHeap;

public class L1046_LastStoneWeight {
    private int data[];
    private int size;

    public int lastStoneWeight(int[] stones) {
        MaxHeap maxHeap = new MaxHeap(stones, stones.length);
        while(maxHeap.getSize() >= 2){
            int one = maxHeap.deleteMax();
            int another = maxHeap.deleteMax();
            if(one != another){
                int newStore = Math.abs(one - another);
                maxHeap.insert(newStore);
            }
        }
        int result = 0;
        if(maxHeap.getSize()==1){
            result = maxHeap.deleteMax();
        }
        return result;
    }

    public int lastStoneWeight02(int[] stones) {

        this.size = stones.length;
        this.data = new int[stones.length+1];

        for(int i = 0 ; i < size ; i++){
            data[i+1] = stones[i];
        }
        for(int i = size ; i >= 1 ; i--){
            shiftDown(i);
        }

        while(this.size >= 2){

            int one = deleteMax();
            int another = deleteMax();
            if(one != another){
                int newStore = Math.abs(one - another);
                insert(newStore);
            }
        }
        int result = 0;
        if(this.size==1){
            result = deleteMax();
        }
        return result;
    }

    public void insert(int value){
        this.data[size+1] = value;
        size+=1;
        int index = size;
        while(index>1 && this.data[index] > this.data[index/2]){
            int tmp = data[index];
            data[index] = data[index/2];
            data[index/2] = tmp;
            index = index/2;
        }
    }

    public int deleteMax(){
        int max = this.data[1];
        this.data[1] = this.data[size];
        size-=1;
        shiftDown(1);
        return max;
    }



    public void shiftDown(int index){
        while(2*index <= this.size){
            int newIndex = 2*index;
            if(newIndex+1<=size && this.data[newIndex] < data[newIndex+1]){
                newIndex += 1;
            }
            if(data[index] >= data[newIndex]){
                break;
            }
            int tmp = data[index];
            data[index]= data[newIndex];
            data[newIndex] =tmp;
            index = newIndex;
        }
    }



}
