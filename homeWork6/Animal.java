package geekbrains.homeWork6;

public class Animal {
    private String name;
    static int countCat, countDog, countAnimal;


    public Animal(String name) {
        this.name = name;
        countAnimal++;
    }


    void run(int lengthObstacle) {
        System.out.println(name + " пробежал " + lengthObstacle + " м");
    }

    void swimming(int lengthObstacle) {
        System.out.println(name + " проплыл  " + lengthObstacle + " м");
    }
}
