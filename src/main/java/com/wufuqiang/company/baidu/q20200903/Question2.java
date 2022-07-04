package com.wufuqiang.company.baidu.q20200903;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int n = 0;
		int m = 0;
		int regionCount = 0;
		for(int i = 0;i<T;i++){
			n = scanner.nextInt();
			m = scanner.nextInt();
			int[] allCow = new int[n];
			for(int j = 0;j<m;j++){
				regionCount = scanner.nextInt();
				for(int z = 0;z<regionCount;z++){
					int left = scanner.nextInt();
					int right = scanner.nextInt();
					if(left == right){
						allCow[left-1]+=1;
					}else{
						for(int ii = left ;ii<=right;ii++){
							allCow[ii-1]+=1;
						}
					}
				}

			}
			int count = 0;
			List<String> res = new ArrayList<>();
			for(int t = 0;t<allCow.length;t++){
				if(allCow[t] == m) {
					count++;
					res.add(t+1+"");
				}
			}
			System.out.println(count);
			Collections.sort(res);
			for(int ii = 0 ;ii<res.size();ii++){
				System.out.print(res.get(ii));
				if(ii != res.size()-1){
					System.out.println(" ");
				}
			}
		}

		scanner.close();

	}

}
