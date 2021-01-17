package test;

public class Test {

}
interface Flyable {
    void fly();
    void flyUp();
}
interface Swimable {
    void swim();
    void swimUp();
}
interface Walkable {
    int i = 5;
    void walk();
    void run();
}
interface Lifeable extends Flyable, Swimable, Walkable {
    void life();
}
abstract class Animal {

}
class Bird  extends Animal implements Lifeable {
    @Override
    public void fly() {
    }
    @Override
    public void flyUp() {
    }
    @Override
    public void swim() {
    }
    @Override
    public void swimUp() {
    }
    @Override
    public void walk() {
    }
    @Override
    public void run() {
    }
    @Override
    public void life() {
    }
    void flyAway(Flyable f) {

    }
    void swimAway(Swimable s) {

    }
    void runAway(Walkable w) {

    }
    void exist(Lifeable l) {

    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.flyAway(bird);
        bird.runAway(bird);
        bird.swimAway(bird);
        bird.exist(bird);


    }
}


