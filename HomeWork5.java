//Первый пункт ДЗ
class HomeWork5 {
    private String family;
    private String name;
    private String middleName;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

//Второй пункт ДЗ
    public HomeWork5(String family, String name, String middleName, String post, String email, String phone, int salary, int age) {
        this.family = family;
        this.name = name;
        this.middleName = middleName;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }

    public HomeWork5() {
    }

    public static void main(String[] args) {
        HomeWork5 homeWork5 = new HomeWork5("Сидоров", "Иван", "Иванович", "Тестер 2.0", "ivanov@mail.ru", "89675555555", 15000, 20);
        HomeWork5 homeWork5Two = new HomeWork5("Иванов", "Иван", "Иванович", "Тестер", "ivanov@mail.ru", "89674444444", 55000, 25);
        homeWork5.info();
        homeWork5Two.info();
        System.out.println("****************************************************************************************************** \n");
        HomeWork5.infoAge40();

    }

//3 пункт ДЗ
    public void info() {
        System.out.println("ФИО: " + family + " " + name + " " + middleName + "\n Должность: " + post + "\n Почта: " + email + "\n Номер телефона: " + phone + "\n ЗП: " + salary + "\n Возраст: " + age + "\n");

    }

    public static void infoAge40() {
//4 пункт ДЗ
        HomeWork5[] personArray = new HomeWork5[5];
        personArray[0] = new HomeWork5("Федоров", "Иван", "Федорович", "Тестер 3.0", "ivanov@mail.ru", "89676666666", 20000, 46);
        personArray[1] = new HomeWork5("Гришин", "Иван", "Федорович", "Тестер 4.0", "ivanov@mail.ru", "89677777777", 90000, 29);
        personArray[2] = new HomeWork5("Степанов", "Иван", "Федорович", "Тестер 5.0", "ivanov@mail.ru", "89678888888", 80000, 39);
        personArray[3] = new HomeWork5("Аркашин", "Иван", "Федорович", "Тестер 6.0", "ivanov@mail.ru", "89679999999", 21000, 40);
        personArray[4] = new HomeWork5("Авдеев", "Иван", "Федорович", "Тестер 7.0", "ivanov@mail.ru", "89670000000", 100000, 83);
//5 пункт ДЗ
        for (int i = 0; i < personArray.length; i++) {
            if (personArray[i].age > 40) {
                personArray[i].info();
            }
        }

    }

}
