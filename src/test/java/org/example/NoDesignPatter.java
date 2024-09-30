package org.example;

public class NoDesignPatter {

    public void step1(){
            System.out.println("Step 1");
        }

        public void step2(){
            System.out.println("Step 2");
        }

        public void step3(String param1){
            System.out.println("Step 3");
        }

        public static void main(String[] args) {
            NoDesignPatter np = new NoDesignPatter();
            np.step1();
            np.step2();
            np.step3("Pramod");
    }

}
