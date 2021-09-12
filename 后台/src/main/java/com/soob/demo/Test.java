package com.soob.demo;

import com.soob.demo.controller.*;
import com.soob.demo.utils.*;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Test {
    String dir="src/main/history.txt";//txt路径
    File file=new File(dir);
    public static void main(String[] args) {
       Test t=new Test();
       t.writeHistory();
    }
    public void writeHistory(){
        try{
            FileWriter fileWritter = new FileWriter(file,true);
            for(int i=1;i<=10000;i++){
                fileWritter.write("2m"+i+" ");
            }
            fileWritter.close();
            System.out.println("writed Success");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
