package exercise4;

/*4. Создай класс со следующим содержимым: (СМ. СКРИНШОТ)
4.1. Необходимо узнать средний возраст студентов мужского пола;
4.2. Кому из студентов грозит получение повестки в этом году при условии,
что призывной возраст установлен в диапазоне от 18 до 27 лет;*/

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class Main {
    private enum Gender {
        MAN,
        WOMAN
    }
    
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;
        
        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        
        public String getName() {
            return name;
        }
        
        public Integer getAge() {
            return age;
        }
        
        public Gender getGender() {
            return gender;
        }
        
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    "}";
        }
        
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }
        
        public int HashCode() {
            return Objects.hash(name, age, gender);
        }
        
        public static void main(String[] args) {
            Collection<Student> students = Arrays.asList(
                    new Student("Дмитрий", 17, Gender.MAN),
                    new Student("Максим", 17, Gender.MAN),
                    new Student("Екатерина", 18, Gender.WOMAN),
                    new Student("Михаил", 28, Gender.MAN)
            );
            
            double averageAge = students.stream()
                    .filter(student -> student.getGender().equals(Gender.MAN))
                    .mapToInt(Student::getAge)
                    .average()
                    .orElse(0);
            System.out.println("Средний возраст студентов мужского пола: " + averageAge);
            
            students.stream().filter(student -> student.getGender().equals(Gender.MAN)
                            && student.getAge() >= 18 && student.getAge() <= 27)
                    .forEach(student -> System.out.println("Студенту " + student.getName() +
                            " грозит получение повестки в этом году."));
        }
    }
}