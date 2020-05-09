package com.wufuqiang.leetcode;
//整数转罗马数字
public class L12_IntToRoman {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        if(num<=0) return sb.toString();
        int[] intNums = new int[]{1000,500,100,50,10,5,1};
        char[] romanNums = new char[]{'M','D','C','L','X','V','I'};
        int tmpNum = num;
        for(int i = 0;i<intNums.length && tmpNum>0;i++){
            int cnt = tmpNum / intNums[i] ;
            while(cnt>0){
                sb.append(romanNums[i]);
                cnt-=1;
            }
            tmpNum = tmpNum % intNums[i];
            int[] tmp = new int[]{tmpNum};
            String particular = isParticular(tmp);
            if(!particular.isEmpty()){
                sb.append(particular);
                tmpNum = tmp[0];
            }
        }
        return sb.toString();
    }

    public String isParticular(int[] num){
        if(num[0]>=900 && num[0] < 1000){
            num[0] = num[0]-900;
            return "CM";
        }else if(num[0]>=400 && num[0]<500){
            num[0] = num[0] - 400;
            return "CD";
        }else if(num[0]>=90 && num[0] < 100){
            num[0] = num[0]-90;
            return "XC";
        }else if(num[0]>=40 && num[0] < 50){
            num[0] = num[0] - 40;
            return "XL";
        }else if(num[0]==9){
            num[0] = 0;
            return "IX";
        }else if(num[0]==4){
            num[0] = 0;
            return "IV";
        }else{
            return "";
        }
    }

    public static void main(String[] args) {
        L12_IntToRoman l12 = new L12_IntToRoman();
        String s = l12.intToRoman(9000053);
        System.out.println(s);
    }

}
