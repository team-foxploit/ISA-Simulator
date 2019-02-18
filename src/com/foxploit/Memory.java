package com.foxploit;

public abstract class Memory {

    protected abstract int getData(int addr);

    protected abstract void setData(int addr, int data);
}
