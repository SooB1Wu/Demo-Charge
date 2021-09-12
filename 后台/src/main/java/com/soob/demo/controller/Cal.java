package com.soob.demo.controller;

import com.soob.demo.utils.*;

import java.util.*;

public class Cal {

    public DtRes splitZ(DtReq req){
        DtRes res=new DtRes();
        for(int i=0;i<req.Z.size();i++) {
            if(req.Z.get(i).get(1)>=req.C) {
                res.Z1.add(new ArrayList<>(req.Z.get(i)));
                req.set.add(req.Z.get(i).get(1));
            }
            else{
                res.Z2.add(new ArrayList<>(req.Z.get(i)));
            }
        }
        return res;
    }

    public DtRes insertA(DtReq req,DtRes res){
        for(List<Integer> ls:req.A){
            if(ls.get(1)<req.C){//p<C,插入Z2中
                res.Z2.add(new ArrayList<>(ls));
                res.TF.add(false);
            }
            else if(!req.set.contains(ls.get(1))){//Z1不存在p
                res.Z1.add(new ArrayList<>(ls));
                res.TF.add(true);
            }
            else{//存在p
                res.Z2.add(new ArrayList<>(ls));
                res.TF.add(false);
            }
        }
        Comparator<List<Integer>> cmp = (ls1, ls2) -> {
            if (ls1.get(1)==ls2.get(1))
                return ls1.get(0)-ls2.get(0);//以a作参考
            return ls1.get(1)- ls2.get(1);//以p作参考
        };
        Collections.sort(res.Z1,cmp);
        Collections.sort(res.Z2,cmp);
        return res;
    }
    public DtRes insertA_force(DtReq req,DtRes res){
        for(List<Integer> ls:req.A){
            if(ls.get(1)<req.C){//p<C,插入Z2中
                int index=find(res.Z2,ls);
//                int index=findf(res.Z2,ls);
                res.Z2.add(index,new ArrayList<>(ls));
                res.TF.add(false);
            }
            else if(!req.set.contains(ls.get(1))){//Z1不存在p
                int index=find(res.Z1,ls);
//                int index=findf(res.Z1,ls);
                res.Z1.add(index,new ArrayList<>(ls));
                res.TF.add(true);
            }
            else{//存在p
                int index=find(res.Z2,ls);
//                int index=findf(res.Z2,ls);
                res.Z2.add(index,new ArrayList<>(ls));
                res.TF.add(false);
            }
        }
        return res;
    }
    private static int find(List<List<Integer>> Z1,List<Integer> ls){
        int p=ls.get(1);
        int l=0;
        int r=Z1.size()-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(Z1.get(mid).get(1)==p)
                return mid;
            else if(Z1.get(mid).get(1)>p)
                r=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
    public static boolean contains(Set<Integer> set,int num){
        return set.contains(num);
    }

    private static int findf(List<List<Integer>> Z1,List<Integer> ls){
        int p=ls.get(1);
        for(int i=0;i<Z1.size();i++){
            if(Z1.get(i).get(1)>p)
                return i;
        }
        return Z1.size();
    }




}
