package com.inf.sp5.singleton;

public class SingletonService {

    //static 객체 생성
    private static final SingletonService instance = new SingletonService();

    //싱글톤 객체 return
    public static SingletonService getInstance(){
        return instance;
    }

    //싱글톤으로만 객체생성 할 수 있도록 막음(생성자를 쓰지 못하도록 private)
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
