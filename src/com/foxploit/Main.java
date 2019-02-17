package com.foxploit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        RegisterFile.setData(31, 10);
        System.out.println(RegisterFile.getData(30));
    }
}
