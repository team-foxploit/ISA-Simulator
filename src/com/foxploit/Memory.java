package com.foxploit;

public abstract class Memory {

    protected abstract String getData(int addr);

    protected abstract void setData(int addr, String data);

    protected abstract void setData(int addr, int data);
}
