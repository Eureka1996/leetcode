package com.wufuqiang.leetcode;

import jdk.nashorn.internal.ir.CallNode;

public class MS16_03_Intersection {
    public static void main(String[] args) {
        double [] result = intersection(new int[]{0,0},new int[]{1,-1},new int[]{0,0},new int[]{-1,1});
//        System.out.println(result[0]+","+result[1]);
    }
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        LineSegament line1 = new LineSegament(start1[0],start1[1],end1[0],end1[1]);
        LineSegament line2 = new LineSegament(start2[0],start2[1],end2[0],end2[1]);
        double[] point = line1.getPoint(line2);
        return point;
    }
}

class LineSegament{
    public double k;
    public double b;
    public double x1;
    public double y1;
    public double x2;
    public double y2;
    public boolean flag = false;

    public LineSegament(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        sortPoint();
        calc();
    }

    public void sortPoint(){
        if(x1>x2){
            double tmp = x1;
            x1 = x2;
            x2 = tmp;
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }else if(x1 == x2){
            if(y1 > y2){
                double tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
        }
    }

    public void calc(){
        if(x1 == x2){
            flag = true;
        }else{
            k = (y2-y1)/(x2-x1);
            b = y1 - k * x1;
        }
    }

    public double[] getPoint(LineSegament line){
        double x = 0 ;
        double y = 0 ;
        boolean isInside = true;
        if(this.flag == true && line.flag == true){
            if(this.x1 == line.x1){
                if(this.y2 < line.y1 || line.y2 < this.y1 ){
                    isInside = false;
                }else{
                    x = this.x1;
                    if(this.y1 >= line.y1){
                        y = this.y1;
                    }else{
                        y = line.y1;
                    }
                }
            }else{
                isInside = false;
            }
        }else if(this.flag == true && line.flag == false){
            x = this.x1;
            y = line.k * x + line.b;
            if(!(this.inside(x,y) && line.inside(x,y))){
                isInside = false;
            }
        }else if(this.flag == false && line.flag == true){
            x = line.x1;
            y = x*this.k+this.b;
            if(!(this.inside(x,y) && line.inside(x,y))){
                isInside = false;
            }
        }else{
            if(this.k == line.k){
                if(this.x1*line.k+line.b == this.y1){
                    if(this.inside(line.x1,line.y1)){
                        x = line.x1;
                        y = line.y1;
                    }else if(line.inside(this.x1,this.y1)){
                        x = this.x1;
                        y = this.y1;
                    }else{
                        isInside = false;
                    }
                }else{
                    isInside = false;
                }

            }else{
                y = (this.b*line.k-line.b*this.k)/(line.k-this.k);
                x = (line.b-this.b)/(this.k-line.k);
                if(!(this.inside(x,y) && line.inside(x,y))){
                    isInside = false;
                }
            }
        }
        if(isInside){
            return new double[]{x,y};
        }else{
            return new double[]{};
        }
    }

    public boolean inside(double x,double y){
        return x>= x1 && x<=x2 ;
    }
}
