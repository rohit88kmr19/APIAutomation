package org.example;

public class BuilderDesignPattern {

    // Change return type of each method as Class type
    // "this" always points to current/calling object. Returning the same to
    // have same reference

    public BuilderDesignPattern Floor1(){
        System.out.println("Stag 1 is Done");
        return this;
    }

    public BuilderDesignPattern Floor2(String parm){
        System.out.println("Stag 2 is Done");
        return this;
    }

    public BuilderDesignPattern Floor3(){
        System.out.println("Stag 3 is Done");
        return this;
    }

    public static void main(String[] args) {
        BuilderDesignPattern bp = new BuilderDesignPattern();
        bp.Floor1().Floor2("pramod").Floor3();

    }
}
