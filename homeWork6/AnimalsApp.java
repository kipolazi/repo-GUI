package geekbrains.homeWork6;

public class AnimalsApp extends Animal {

    public AnimalsApp(String name) {
        super(name);
    }

    public static void main(String[] args) {

        Cat cat = new Cat("Мурзик");
        Dog dog = new Dog("Барсик");
        Cat cat1 = new Cat("Мася");
        Dog dog1 = new Dog("Рекс");
        dog.swimming(85);
        dog.run(425);
        cat.run(154);
        cat.swimming(35);
        System.out.println("Общее количество животных = " + countAnimal + "\n" + "Количество котиков = " + countCat + "\n" + "Количество песиков = " + countDog);

    }
}
