package main;

public class Main {
    public static void main(String[] args){
        Student[] students = {new Student("Иван", "Иванович", "Иванов", 17, "м"),
                new Student("Петр", "Петрович", "Петров", 16, "м"),
                new Student("Николай", "Иванович", "Иванов", 18, "м"),
                new Student("Сидор", "Сидорович", "Сидоров", 17, "м"),
                new Student("Спиридон", "Николаевич", "Сидоров", 17, "м"),
                new Student("Никифор", "Никофорович", "Никифоров", 16, "м"),
                new Student("Егор", "Иванович", "Егоров", 17, "м"),
                new Student("Павел", "Сидорович", "Петров", 16, "м"),
                new Student("Петр", "Иванович", "Павлов", 18, "м"),
                new Student("Сильвестр", "Сильвестрович", "Сильвестров", 16, "м"),
                new Student("Иван", "Иванович", "Иванов", 17, "м")};

        Group group = new Group("121-13");

        for (Student s: students) {
            try {
                group.add(s);
            } catch (GroupException e) {
                System.out.println(e.getMessage() + ", " + e.getNumber());
            }
        }

        try {
            for (Student s: group.findStudent("Сидоров")) {
                System.out.println(s);
            }
        } catch (NullPointerException ex){
            System.out.println("Студент не найден");
        }

        group.delStudent(4);
        System.out.println(group.toString());

        Commissar commissar = () -> {
            Student[] fitStudents = new Student[0];
            for (Student s : group.getStudents()) {
                if ((s.getAge() >= 18) & (s.getMale().equals("м"))){
                    Student[] buf = new Student[fitStudents.length+1];
                    buf[buf.length-1] = s;
                    System.arraycopy(fitStudents, 0, buf, 0, fitStudents.length);
                    fitStudents = buf;
                }
            }
            return fitStudents;
        };

        commissarCame(commissar.isFit());
        group.saveGroup();


//======Эти строки читают файл group.txt с рабочего стола
//        Group group1 = new Group();
//        group1.readGroup();
//        System.out.println(group1.toString());
    }

    private static void commissarCame(Student[] cc){
        if (cc.length > 0){
            System.out.println("Годен");
            for (Student s: cc) {
                System.out.println(s);
            }
        } else {
            System.out.println("Нет годных к призыву");
        }
    }
}
