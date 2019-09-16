package main;

public class Student extends Human {

    public Student(String firstname, String secondname, String surname, int age) {
        super(firstname, secondname, surname, age);
    }

    @Override
    public String toString() {
        return "Студент " + super.toString();
    }
}
