package geekbrains.homeWork6;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    void run(int lengthObstacle) {
        if (lengthObstacle <= 500) {
            super.run(lengthObstacle);
        } else System.out.println("Собака пробежит 500м и устанет!");
    }

    @Override
    void swimming(int lengthObstacle) {
        if (lengthObstacle <= 10) {
            super.swimming(lengthObstacle);
        } else System.out.println("Собака проплывет 10м и устанет!");
    }
}
