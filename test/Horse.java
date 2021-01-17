package test;

import innerclass.Animal;

public class Horse {
    private class Turkey implements Animal{
        @Override
        public void eat() {
            System.out.println("horse eat");
        }
    }
    public Animal animal() {
        return new Turkey();
    }
}
