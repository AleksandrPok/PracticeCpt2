package main;

public class Main {
    public static void main(String[] args){
        Student[] students = {new Student("Иван", "Иванович", "Иванов", 17),
                new Student("Петр", "Петрович", "Петров", 16),
                new Student("Николай", "Иванович", "Иванов", 17),
                new Student("Сидор", "Сидорович", "Сидоров", 18),
                new Student("Спиридон", "Николаевич", "Сидоров", 17),
                new Student("Никифор", "Никофорович", "Никифоров", 16),
                new Student("Егор", "Иванович", "Егоров", 17),
                new Student("Павел", "Сидорович", "Петров", 18),
                new Student("Петр", "Иванович", "Павлов", 17),
                new Student("Сильвестр", "Сильвестрович", "Сильвестров", 16),
                new Student("Иван", "Иванович", "Иванов", 17)};

        Group group = new Group("121-13");

        for (Student s: students) {
            try {
                group.add(s);
            } catch (GroupException e) {
                System.out.println(e.getMessage() + ", " + e.getNumber() + "\n");
            }
        }

        System.out.println(group.findStudent("Петров"));
        group.delStudent(4);
        System.out.println(group.toString());
    }
}
