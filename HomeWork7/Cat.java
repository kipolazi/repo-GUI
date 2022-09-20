package HomeWork7;

public class Cat {
    public String name;
    private int appetite;
    private int satiety;


    public Cat(String name, int appetite, int satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;

    }

    public boolean eat(Plate count) {
//Здесь котик кушает, и если ему хватает еды, то он наедается
        if (count.decreaseFood(appetite)) {
            satiety = appetite;
            System.out.println("Кот <" + name + "> покушал, его сытость = " + satiety);
//Тут выводится инфа о том, что котику не хватило еды в тарелке,  и что он не насытился
        } else if (!count.decreaseFood(appetite)) {
            System.out.println("Коту <" + name + "> не хватило еды, его сытость = " + satiety);
        }
        return false;
    }

}
