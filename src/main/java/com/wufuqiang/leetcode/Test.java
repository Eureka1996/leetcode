package com.wufuqiang.leetcode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.*;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 11:09
 **/
public class Test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNextInt()){
//            System.out.println(in.nextInt());
//        }
//        LinkedList<Integer> stack = new LinkedList<Integer>();
////        stack.add(1);
////        stack.add(2);
////        stack.addFirst(3);
////        stack.add(4);
////        stack.push(5);
////        System.out.println("poll:"+stack.pollFirst());
////        System.out.println("last:"+stack.pollLast());
////        for(Integer item:stack){
////            System.out.println(item);
////        }
//        List<String> list = new ArrayList<String>(3);
////        list.add("wu");
////        list.add("fu");
////        list.add("qiang");
//        System.out.println(list);
//        list.set(1,"yu");
//        System.out.println(list);
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()){
//            String s = scanner.nextLine();
//        }
//        testSet();
//        testString();
//        testRandom();
        testListJoin();
    }

    public static void testString(){
        String str ="/a//b////c/d//././/../";
        String[] strs = str.split("/");
        for(String s:strs){
            System.out.println("^^^"+s+"****");
        }
    }

    public static void testJson() throws JSONException {
        File file = new File("");
        JSONObject jsonObject = new JSONObject(file);
        jsonObject.getJSONObject("").getJSONArray("");
        jsonObject.getJSONObject("").toString();
    }

    public static void testSet(){
        Set<List<Integer>> set = new HashSet<>();
        set.add(Arrays.<Integer>asList(0,1,9));
        set.add(Arrays.<Integer>asList(0,1,9));
        System.out.println(set.contains(Arrays.<Integer>asList(0,1,9)));


        for(List<Integer> s : set){
            for(int i : s ){
                System.out.print(i+"\t");
            }
            System.out.println();
        }

        Set<Integer> intSet = new HashSet<>();
        intSet.add(5);
        intSet.add(6);
        for(int i : intSet){
            System.out.println(i);
        }
        System.out.println("-------------------");
        intSet.remove(5);
        intSet.remove(15);

        for(int i : intSet){
            System.out.println(i);
        }
    }

    public static void testRandom(){
        Random random = new Random();
        for(int i =0 ; i < 3 ;i++){
            System.out.println(random.nextInt(10));
        }
    }

    public static void testEmoji(){
        String str1 = "爱中国人ߘ°ߤÉ";
        System.out.println(str1+"\t"+"from");
    }

    public static void testListJoin(){
        List<String> list = new ArrayList<>();
        list.add("wu");
        list.add("fu");
        list.add("qiang");
        String join = String.join(",", list);
        System.out.println(join);
    }
}
