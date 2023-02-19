package com.inf.sp5.singleton;

public class StatelessService {
    //private int price;
    public int order(String name, int price){
        System.out.println("name = "+name+" price = "+ price);
        return price;  //중복되지 않도록 바로 return
    }
}
