import com.sun.source.tree.IfTree;

import java.util.HashMap;
import java.util.Map;


public class NumberPhone {
    private HashMap<String, String> familyPhone = new HashMap<>();

    // Здесь мы просто реализовали добавление в хэшмепу ключа и значения через метод put, в который передаем данные из вхождения метода add
    public void add(String phone, String family) {
        familyPhone.put(phone, family);
    }

    //    В этом методе изначально проверяем наличие фамилии среди всех значений, если такова присутсвует выполняем блок кода. В самом методе вводим промежуточную переменную result. Далее для того чтобы пройтись по хэшмэппе - мы получаем множество значений ключей, и уже циклом ходим пон ним. У каждого ключа получаем значеие и складываем его в промеж. переменную valueKey. Далее методом equals проверяем текущее значение с введеным нами во вхождении метода. И если значения совпадают - записываем их в переменную result.
    public String get(String family) {
        if (familyPhone.containsValue(family)) {
            String result = "Номер телефона: ";
            for (String key : familyPhone.keySet()) {
                String valueKey = familyPhone.get(key);
                if (valueKey.equals(family)) {
                    result = result + key + "; ";
                }
            }
            return result;
        } else return "Такой фамилии нет в списке контактов!";
    }
}
