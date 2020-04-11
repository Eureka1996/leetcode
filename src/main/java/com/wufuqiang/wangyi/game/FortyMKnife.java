package com.wufuqiang.wangyi.game;

import java.util.*;

public class FortyMKnife {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i =0;i<t;i++){
			int m = scanner.nextInt();
			int l = scanner.nextInt();
			List<Supply> supplies = new ArrayList<>();
			for(int j = 0;j<m;j++){
				for(int z = 0;z<m;z++){
					int s = scanner.nextInt();
					if(s != 0){
						supplies.add(new Supply(j,z,s));
					}
				}
			}
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			for(Supply supply:supplies){
				supply.distance = Math.sqrt(
						Math.pow(Math.abs(x-supply.x),2)+
						Math.pow(Math.abs(y-supply.y),2)
				);
			}
			//升序排序
			Collections.sort(supplies, new Comparator<Supply>() {
				@Override
				public int compare(Supply o1, Supply o2) {
					if(o1.distance>o2.distance){
						return 1;
					}else if(o1.distance < o2.distance){
						return -1;
					}else{
						return 0;
					}
				}
			});

			for(Supply supply:supplies){
				System.out.println("x:"+supply.x+",y:"+supply.y+",distance:"+supply.distance+",knift:"+l);
				if(l >= supply.distance){
					l+=supply.knift;
				}else{
					break;
				}
			}
			System.out.println(l);

		}
		scanner.close();
	}
}

class Supply{
	public int x;
	public int y;
	public int knift;
	public double distance;

	public Supply(int x, int y, int knift) {
		this.x = x;
		this.y = y;
		this.knift = knift;
	}
}
