package com.wufuqiang.company.baidu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//https://blog.csdn.net/light_14/article/details/43939401
public class GetNum2020032901 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		Node[] nodes = new Node[n];
		for(int i =0 ;i<n;i++){
			Node node = new Node();
			node.a = scanner.nextInt();
			nodes[i] = node;
		}
		for(Node node:nodes){
			node.b = scanner.nextInt();
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.a>o2.a){
					return -1;
				}else if(o1.a < o2.a){
					return 1;
				}else{
					return 0;
				}
			}
		});

		int[][] dp = new int[n+1][m+1];
		for(int i = 0 ;i<n;i++){
			for(int j = 1;j<=m;j++){
				dp[i+1][j] = Math.max(dp[i][j],dp[i][j-1]+nodes[i].a-nodes[i].b*(j-1));
				System.out.print(String.format("%d(%d,(%d+%d-%d=%d))\t",dp[i+1][j],dp[i][j],dp[i][j-1],nodes[i].a,nodes[i].b*(j-1),dp[i][j-1]+nodes[i].a-nodes[i].b*(j-1)));

			}
			System.out.println();
		}
//		for(int i = 0 ; i <= n ;i++){
//			for(int j = 0;j <=m;j++){
//				System.out.print(dp[i][j]+"\t");
//			}
//			System.out.println();
//		}
	}
}

class Node{
	public int a;
	public int b;
}
