package HomeWork7;


public class Plate {
    private int food;


    public Plate(int food) {
        this.food = food;
    }

//Отнимает кол-во съеденной еды котиком, не дает еде в тарелке уйти в минус
    public boolean decreaseFood(int count) {
        if (food >= count) {
            food -= count;
            return true;
        }
        return false;
    }
//Добавление еды в тарелку
    public void addFood(int add){
        food += add;
    }
//Информация о количестве еды, которая находится в тарелке
    void info() {
        System.out.println("Еды в тарелке осталось = " + food);
    }
}
