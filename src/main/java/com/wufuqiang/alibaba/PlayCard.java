package com.wufuqiang.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayCard {


	public static void main(String[] args) {
		int[][] cards = flagCards(getCards());
		printCards(cards);
		System.out.println(playCards(cards));
		printCards(cards);
	}

	public static int[][] getCards(){
		Scanner scan = new Scanner(System.in);
		int[][] cards = new int[8][10];
		for(int i = 0 ; i < 10 ;i++){
			int count = scan.nextInt();
			for(int j = 0 ;j<2*count;j+=2){
				cards[j][i] = 1;
			}
		}
		return cards;
	}

	public static void printCards(int[][] cards){
		int row = cards.length;
		int column = cards[0].length;
		for(int i = 0 ; i < row;i++){
			for(int j = 0; j<column;j++){
				System.out.print(cards[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public static int [][] flagCards(int[][] cards){
		for(int i = 0;i<8;i+=2){
			for(int j = 1;j<10;j++){
				if(cards[i][j] == 1){
					cards[i][j] = cards[i][j-1] + 1;
				}
			}
		}
		return cards;
	}

	public static int playCards(int[][] cards){
		int count = 0;
		int row = cards.length;
		int column = cards[0].length;

		for(int i = row-2 ; i >= 0 ;i-=2){
			for(int j = 9 ;j >=0 ;j--){
				if(cards[i+1][j] != 0){
					continue;
				}
				if(cards[i][j] >= 5){
					boolean flag = canPlayWith4(cards, i, j);
					if(flag){
						flagPlayMethod(cards,i,j,4);
						j = j - 5+1;
						count+=1;
					}else{
						int next = i+3;
						if(next<=7 && cards[next][j] != 1){
							//按根的方式出
							count+=1;
							flagPlayMethod(cards,i,j,1);
						}else{
							//按对的方式出
							flagPlayMethod(cards,i,j,2);
						}
					}
				}else if(cards[i][j] >=3){
					boolean flag = canPlayWith3(cards, i, j);
					if(flag){
						j = j - 3 + 1;
						flagPlayMethod(cards,i,j,3);
						flagPlayMethod(cards,i-2,j,3);
						count+=1;
					}else{
						int next = i+3;
						if(next<=7 && cards[next][j] != 1){
							//按根的方式出
							count+=1;
							flagPlayMethod(cards,i,j,1);
						}else{
							//按对的方式出
							flagPlayMethod(cards,i,j,2);
						}
					}

				}else if(cards[i][j] > 0){
					int next = i+3;
					if(next<=7 && cards[next][j] != 1){
						//按根的方式出
						count+=1;
						flagPlayMethod(cards,i,j,1);
					}else{
						//按对的方式出
						flagPlayMethod(cards,i,j,2);
					}
				}
			}
		}

		return count;
	}

	public static void flagPlayMethod(int[][] cards,int i , int j , int method){
		if(method==1){
			cards[i+1][j] = 1;
		}else if(method == 2){
			cards[i+1][j] = 2;
		}else if(method == 3){
			cards[i+1][j] = 3;
			cards[i+1][j-1] = 3;
			cards[i+1][j-2] = 3;
		}else if(method == 5){
			cards[i+1][j] = 4;
			cards[i+1][j-1] = 4;
			cards[i+1][j-2] = 4;
			cards[i+1][j-3] = 4;
			cards[i+1][j-4] = 4;
		}
	}

	public static boolean canPlayWith3(int[][] cards,int i ,int j){
		int row = i -2;
		if(row < 0){
			return false;
		}
		boolean flag = true;
		for(int z = 9;z>=0;z--){
			if(cards[row][z] >= 5){
				if(z-4<=j && z-4>j-2){
					return false;
				};
				z=z-5+1;
			}
		}
		return flag;
	}

	public static boolean canPlayWith4(int[][] cards,int i ,int j){
		boolean flag = true;
		for(int z = j ;z >=j-4;z--){
			if(cards[i+1][z] == 3){
				return false;
			}
		}
		return flag;
	}
}
