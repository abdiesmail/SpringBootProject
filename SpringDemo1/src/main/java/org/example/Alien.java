package org.example;

public class Alien {

    private int age;
    private Computer com;

    public int getAge() {
        return age;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Alien() {
        System.out.println("constructor");
    }
    public void code() {
        System.out.println("codeing..");
        com.compile();
    }
}
