/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

2. Создать массив из 5 сотрудников.
Пример:
// вначале объявляем массив объектов
Person[] persArray = new Person[5];
// потом для каждой ячейки массива задаем объект
persArray[0] = new Person("Ivanov Ivan", "Engineer",
               "ivivan@mailbox.com", "892312312", 30000, 30);
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить
информацию об аттракционах, времени их работы и стоимости.
*/
public class Lesson_4 {
    public static void main(String[] args) {
        //1.
        Employee person = new Employee("Ivanov Ivan Ivanovich", "driver", "shumaxer@mail.ru",
                "87778766766", 30000, 40);
        person.info();
        //2.
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", "iavan@mail.ru",
                "89277275555", 40000, 35);
        persArray[1] = new Employee("Petrov Petr", "Driver", "petro@mail.ru",
                "88908086572", 30000, 45);
        persArray[2] = new Employee("Sidorova Maria", "Cook", "sidr@mail.ru",
                "89677244565", 30000, 40);
        persArray[3] = new Employee("Sidorov Marat", "Security", "sidrMart@mail.ru",
                "89677244566", 20000, 45);
        persArray[4] = new Employee("Gagarin Uriy", "CEO", "firstNah@mail.ru",
                "80001114321", 500000, 42);
        persArray[4].info();
        //3.
        Park.Attraction[] attractionsArray = new Park.Attraction[3];
        attractionsArray[0] = new Park.Attraction("Cars", "10:00 - 22:30", "500");
        attractionsArray[1] = new Park.Attraction("Trampoline", "10:00 - 21:00", "700");
        attractionsArray[2] = new Park.Attraction("Tashnilovka carousel", "10:00 - 22:30", "100");
        attractionsArray[2].info();
    }
}