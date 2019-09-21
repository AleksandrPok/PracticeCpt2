package main;

public class Human {
    private String firstname;
    private String secondname;
    private String surname;
    private int age;

    public Human(String firstname, String secondname, String surname, int age){
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return surname + " " + firstname + " " + secondname + " возраст " + age;
    }
}
