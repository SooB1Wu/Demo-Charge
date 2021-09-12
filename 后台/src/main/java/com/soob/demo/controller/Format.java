package com.soob.demo.controller;

import com.soob.demo.utils.DtReq;
import com.soob.demo.utils.DtRes;
import com.soob.demo.utils.ObjSend;


import java.util.ArrayList;
import java.util.List;

public class Format {

    public DtReq formatReq(String req){
        DtReq data=new DtReq();
        String[] s=req.split("\"");
        String[] z=s[3].split(" ");
        String[] a=s[7].split(" ");
        String c=s[11];
//
//        System.out.println("3:  "+s[3]);
//        System.out.println("7:  "+s[7]);

        data.Z=new ArrayList<>(getList(z));
        data.A=new ArrayList<>(getList(a));
        data.C=Integer.valueOf(c);
        //print(req,data);
        return data;
    }

    public static List<List<Integer>> getList(String[] s){
        List <List<Integer>> res=new ArrayList<>();
        for(String str:s) {
            if(str.length()==0)
                continue;
            String[] cs = str.split("m");
            List<Integer> cache = new ArrayList<>();
            for(String c:cs){
                if(c.equals("")||c.equals(" ")||c.equals("m")) {
                    continue;
                }
                else {
                    cache.add(Integer.valueOf(c));
                }
            }
            res.add(cache);
        }
        return res;
    }

    //格式化objsend
    public ObjSend formatSend(DtRes res){
        ObjSend objSend=new ObjSend();
        StringBuffer z1=new StringBuffer();
        StringBuffer z2=new StringBuffer();
        String flag=res.TF.toString();
//        while(!res.Z1.isEmpty()){
//            z1.append(res.Z1.poll().toString()+",");
//        }
//        while(!res.Z2.isEmpty()){
//            z2.append(res.Z2.poll().toString()+",");
//        }
        for(List<Integer> ls:res.Z1)
            z1.append(ls.toString()+",");
        for(List<Integer> ls:res.Z2)
            z2.append(ls.toString()+",");
        if(z1.length()!=0)
            z1.deleteCharAt(z1.length()-1);
        if(z2.length()!=0)
            z2.deleteCharAt(z2.length()-1);
        z1.insert(0,'[');
        z1.append(']');
        z2.insert(0,'[');
        z2.append(']');
        objSend.z1=z1.toString();
        objSend.z2=z2.toString();
        objSend.flag=flag;
        return objSend;
    }

    public static void print(String s,DtReq data){
        System.out.println(s);
        System.out.println("C:"+data.C);
        System.out.println("Z:"+data.Z);
        System.out.println("A:"+data.A);
    }
}
