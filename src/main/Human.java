package main;

public class Human {
    private String firstname;
    private String secondname;
    private String surname;
    private int age;
    private String male;

    public Human(String firstname, String secondname, String surname, int age, String male){
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.age = age;
        this.male = male;
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

    public String getMale() {
        return male;
    }

    @Override
    public String toString(){
        return surname + " " + firstname + " " + secondname + " возраст " + age + " пол " + male;
    }
}
