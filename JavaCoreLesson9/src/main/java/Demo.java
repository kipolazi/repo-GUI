import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
//Задание перое
        System.out.println("Задание первое: ");
//        Тут я создал студентов и курсы к ним через вложенный цикл и поместил в лист
        List<Student> students = getListStudentAndCourse(5, 5);
//        Тут я отфильтровал по уникальности через переопределение equals и distinct, помнстил в лист и распечатал в консоль уникальные курсы
        students.stream().flatMap(student -> student.getCourseList().stream()).distinct().collect(Collectors.toList()).forEach(course -> System.out.println(course.getName()));

//Задание второе
        System.out.println("Задание второе: ");
//        Тут отсортировал по убыванию кол-ва курсов
        students.stream().sorted((( o1, o2) -> o1.getCourseList().size() - o2.getCourseList().size())).limit(3).collect(Collectors.toList()).forEach(student -> System.out.println(student.getName()));

//Задание третье
        System.out.println("Задание третье: ");
//        Тут я создал объект класса course
        Course course = new Course("course4");
//        Тут я отфильтровал список студентов по наличию в них созданого выше объекта, добавил в лист и распечатал  консоль
        students.stream().filter(student -> student.getCourseList().contains(course)).collect(Collectors.toList()).forEach(student -> System.out.println(student.getName()));



    }
    private static List<Student> getListStudentAndCourse(int s, int c) {
        ArrayList<Student> result = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            ArrayList<Course> courses = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                courses.add(new Course("course" + j));
            }
            result.add(new Student("student" + i, courses));
        }
        return result;
    }

}