package geekbrains.homeWork6;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        countCat++;
    }

    @Override
    void run(int lengthObstacle) {
        if (lengthObstacle <= 200) {
            super.run(lengthObstacle);
        } else System.out.println("Кот пробежит 200м и устанет!");
    }

    @Override
    void swimming(int lengthObstacle) {
        System.out.println("Кот не умеет плавать!");
    }

}
