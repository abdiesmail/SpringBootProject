package org.example;

public class Desktop implements Computer{
    public Desktop(){
        System.out.println("constructor desktop");
    }
    public void compile(){
        System.out.println("Compiling in desktop");
    }
}
