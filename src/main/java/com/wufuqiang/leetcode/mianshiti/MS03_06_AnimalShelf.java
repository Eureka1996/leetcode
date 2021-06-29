package com.wufuqiang.leetcode.mianshiti;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-30 00:35
 */
public class MS03_06_AnimalShelf {
    public static void main(String[] args) {

    }
}
class AnimalShelf {

    private LinkedList<int[]> queueDog = null;
    private LinkedList<int[]> queueCat = null;
    private int maxIndex = 0;


    public AnimalShelf() {
        queueDog = new LinkedList<>();
        queueCat = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        int[] animalWithNum = new int[3];
        animalWithNum[0] = animal[0];
        animalWithNum[1] = animal[1];
        animalWithNum[2] = maxIndex;
        maxIndex+=1;
        if(animalWithNum[1] == 0){
            queueCat.offerLast(animalWithNum);
        }else{
            queueDog.offerLast(animalWithNum);
        }
    }

    public int[] dequeueAny() {
        if(queueDog.isEmpty()){
            return dequeueCat();
        }else if(queueCat.isEmpty()){
            return dequeueDog();
        }else{
            int[] any = queueCat.peekFirst()[2]<queueDog.peekFirst()[2]?queueCat.pollFirst():queueDog.pollFirst();
            return new int[]{any[0],any[1]};
        }
    }

    public int[] dequeueDog() {
        if(!queueDog.isEmpty()){
            int[] dog = queueDog.pollFirst();
            return new int[]{dog[0],dog[1]};
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueCat() {
        if(!queueCat.isEmpty()){
            int[] cat = queueCat.pollFirst();
            return new int[]{cat[0],cat[1]};
        }
        return new int[]{-1,-1};
    }
}
