package main;

public class Student extends Human {

    public Student(String firstname, String secondname, String surname, int age, String male) {
        super(firstname, secondname, surname, age, male);
    }

    @Override
    public String toString() {
        return "Студент " + super.toString();
    }
}
