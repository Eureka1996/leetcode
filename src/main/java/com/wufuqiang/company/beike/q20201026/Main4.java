package com.wufuqiang.company.beike.q20201026;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int i = 0;i<T;i++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] ta = new int[m];
			Node[] a = new Node[m];
			Node[] b = new Node[m];
			for(int j = 0;j<m;j++){
				int vala = sc.nextInt();
				int valb = sc.nextInt();
				ta[j] = vala;
				Node  an = new Node(vala,j);
				Node  bn = new Node(valb,j);
				a[j] = an;
				b[j] = bn;

			}
			soluve(ta,a,b,n);
		}



		sc.close();
	}

	public static void soluve(int[] ta,Node[] a,Node[] b,int n){
		Arrays.sort(a, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.val>o2.val){
					return -1;
				}else if(o1.val<o2.val){
					return 1;
				}else{
					return 0;
				}
			}
		});
		Arrays.sort(b, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.val>o2.val){
					return -1;
				}else if(o1.val<o2.val){
					return 1;
				}else{
					return 0;
				}
			}
		});
		HashSet<Integer> set = new HashSet<>();

		int sum = 0;
		int ai = 0;
		int bi = 0;
		while(n>0){

			if(a[ai].val >= b[bi].val && ai < a.length){
				sum+=a[ai].val;
				set.add(a[ai].i);
				ai++;
				n--;
			}else{
				if(set.contains((Integer) (b[bi].i))){
					sum+=(n*(b[bi].val));
					break;
				}else{
					sum+=(ta[b[bi].i]);
					n--;
					sum+=(n*(b[bi].val));
					break;
				}

			}
		}


		System.out.println(sum);

	}
}

class Node{
	public int val;
	public int i;

	public Node(int val, int i) {
		this.val = val;
		this.i = i;
	}
}
