import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Создан класс, который будет содержать в себе HashMap
public class PhoneBook{

    private static HashMap<String, ArrayList> contacts = new HashMap();

    // Сoздан метод addContact, добавляющий новый контакт в справочник. При проверке
    // осуществляется поиск имени
    // в HashMap, если оно есть, то добавляется номер в ArrayList, если его нет, то
    // содается новая запись в HashMap
public static void addContact(String name, String phoneNumber) {
if (contacts.containsKey(name)) {
    ArrayList phoneNumbers = contacts.get(name);
    phoneNumbers.add(phoneNumber);
    contacts.put(name, phoneNumbers);
}else{
    ArrayList phoneNumbers = new ArrayList();
    phoneNumbers.add(phoneNumber);
    contacts.put(name, phoneNumbers);
}
}
    // Создан метод вывода списка пользователей printContacts, по количеству
    // телефонных номеров
    // в порядке от большего к меньшему

public static void printContacts(){
ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList(contacts.entrySet());
Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
@Override
public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2){
  return o2.getValue().size() - o1.getValue().size();
}
});

for (Map.Entry<String, ArrayList> entry :list){
System.out.println(entry.getKey() + ":" + entry.getValue());
}
}

//Создаем ArrayList из записей, содержащихся в HashMap и сортируем в порядке убывания

public static void main(String[] args) {
    addContact("Иванов", "123-23-23");
    addContact("Петров", "100-10-10");
    addContact("Иванов", "222-22-22");
    addContact("Петров", "333-33-33");
    addContact("Сидоров", "444-44-44");
    addContact("Федоров", "555-55-55");

    printContacts();
   
}
}







