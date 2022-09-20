package HomeWork7;

public class CatsFoodApp {
    public static void main(String[] args) {
        Plate plate = new Plate(33);
        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Мурзик", 15, 0);
        catArray[1] = new Cat("Васек", 8, 0);
        catArray[2] = new Cat("Киселечек", 7, 0);
        catArray[3] = new Cat("Мусик", 2, 0);
        catArray[4] = new Cat("Кекс", 7, 0);

        for (int i = 0; i < catArray.length; i++) {
            catArray[i].eat(plate);
        }
        plate.info();
        plate.addFood(10);
        plate.info();

    }
}




