package com.wufuqiang.test;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;
import java.util.regex.Pattern;

public class NormalTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		new Thread().start();
//		FutureTask<String> task = new F utureTask<>(new Callable<String>() {
//			@Override
//			public String call() throws Exception {
//				return "Hello World";
//			}
//		});
//		new Thread(task).start();
//		task.get();
////		testStrCharAt();
//		hashMapTest2();
//		testHashMap();
//		String s1 = new String("abcde");
//		String s2 = new String("abcde");
//		boolean equals = s1.equals(s2);
//		boolean b = s1 == s2;
//		System.out.println(equals+","+b);
//		String str = "Ncat: Version 7.50 ( https://nmap.org/ncat )\nNcat: Connected to 10.108.182.184:800.\nNcat: Idle timeout expired (2000 ms).\n";
//		str = "Ncat: Version 7.50 ( https://nmap.org/ncat ) Ncat: Connected to 10.108.182.183:800. Ncat: Idle timeout expired (2000 ms).";
//		String expect = "Idle timeout|succeeded";
//		System.out.println(findRegex( expect,str));
//
//		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(4));
//		threadPoolExecutor.submit(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("wufuqiang");
//			}
//		});

		int[] subarray = ArrayUtils.subarray(new int[]{2, 3, 4, 5}, 1, 2);
		System.out.println(subarray.length);
		int res = (int) Math.round(((double) 8) / 5);
		System.out.println(res);
		System.out.println(((double) 8) / 5);
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
	}

	public static boolean findRegex(String reg,String content){
		Pattern ptn = Pattern.compile(reg,Pattern.MULTILINE | Pattern.DOTALL);
		if(ptn.matcher(content).find()){
			return true;
		}
		return false;
	}

	public static void testHashMap(){
//		Map<Integer,Student> map = new HashMap<>();
//		Student stu1 = new Student("wufq",20);
//		map.put(1,stu1);
//		stu1.setAge(30);
//		Student student = map.get(1);
//		System.out.println(student.getAge());

		Map<Student,Student> stuMap = new HashMap<>();
		Student key = new Student("wufq",21);
		Student key2 = new Student("wufq",21);
		Student value = new Student("wufq-value",22);
		stuMap.put(key,value);
		Student student1 = stuMap.get(key);
		Student student3 = stuMap.get(key2);

		System.out.println(student1.getName()+","+student1.getAge());
		System.out.println("key2:"+student3.getName()+","+student3.getAge());

		System.out.println("hash code key:"+key.hashCode());
		key.setAge(31);
		key.setName("wufuqiang");

		for(Map.Entry<Student,Student> entry : stuMap.entrySet()){
			System.out.println("key:"+entry.getKey().getName()+","+entry.getKey().getAge());
			System.out.println("value:"+entry.getValue().getName()+","+entry.getValue().getAge());
			System.out.println("----------------------");
		}

		System.out.println("hash code key:"+key.hashCode());
		Student student2 = stuMap.get(key2);

//		key.setName("wufuqiang");
		System.out.println(student2.getName()+","+student2.getAge());



	}

	public static void hashMapTest2(){
		HashMap<Student,Student> studentHashMap = new HashMap<>();
		Student key = new Student("key-wufq",20);
		Student value = new Student("value-wufq",21);
		studentHashMap.put(key,value);

		for(Map.Entry<Student,Student> entry : studentHashMap.entrySet()){
			System.out.println("key:"+entry.getKey().getName()+","+entry.getKey().getAge());
			System.out.println("value:"+entry.getValue().getName()+","+entry.getValue().getAge());
			System.out.println("----------------------");
		}

		key.setName("key-wufuqiang");
		key.setAge(30);
		System.out.println("########################");
		for(Map.Entry<Student,Student> entry : studentHashMap.entrySet()){
			System.out.println("key:"+entry.getKey().getName()+","+entry.getKey().getAge());
			System.out.println("value:"+entry.getValue().getName()+","+entry.getValue().getAge());
			System.out.println("---------------------------");
		}


	}



	public void set(){

	}

	public static void testStrCharAt(){
		String str = "wwwwwwwwwwwwww";
		int i = str.indexOf('.');
		System.out.println(i);
	}
}
