package main;

import java.io.*;

public class Group {
    Student[] students = new Student[0];
    String groupName;

    public Group(){}

    public Group(String groupName){
        this.groupName = groupName;
    }

    public void add(Student newStudent) throws GroupException{
        if (students.length == 10) {
            throw new GroupException("В группе достаточно студентов", 1);
        } else {
            students = addR(students, newStudent);
        }
    }

    public void delStudent(int index){
        if ((index-1>0) & (index-1<students.length) & (students.length != 0)){
            Student[] buf = new Student[students.length-1];
            for (int i = 0; i < students.length; i++) {
                if (i < index-1){
                    buf[i] = students[i];
                }
                if (i > index -1){
                    buf[i-1] = students[i];
                }
            }
            students = buf;
        } else {
            System.out.println("Введен некорректный индекс или в группе нет студентов");
        }
    }

    public Student[] findStudent(String surname){
        Student[] found = new Student[0];
        for (Student s: students) {
            if (s.getSurname().contains(surname)) {
                found = addR(found, s);
            }
        }
        return found.length>0 ? found : null;
    }

    private Student[] addR(Student[] s, Student student){
        Student[] buf = new Student[s.length+1];
        buf[buf.length-1] = student;
        System.arraycopy(s, 0, buf, 0, s.length);
        return buf;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Группа " + groupName);
        sb.append(System.lineSeparator());
        for (Student s : sort()) {
            sb.append(s.toString().substring(8));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private Student[] sort(){
        Student[] buf = students;
        Student bufCell;
        for (int i = buf.length-1; i >= 1; i--) {
            for (int j = 0; j < i; j++)
                if (needSwap(buf[j].toString().substring(8).toCharArray(), buf[j + 1].toString().substring(8).toCharArray())) {
                    bufCell = buf[j];
                    buf[j] = buf[j + 1];
                    buf[j + 1] = bufCell;
                }
        }
        return buf;
    }

    private boolean needSwap(char[] a, char[] b){
        int j;
        if (a.length>b.length){
            j = b.length;
        } else {
            j = a.length;
        }
        for (int i = 0; i < j; i++) {
            if (a[i] > b[i]){
                return true;
            } else {
                if (a[i]< b[i]){
                    return false;
                }
            }
        }
        return false;
    }

    public Student[] getStudents() {
        return students;
    }

    public void saveGroup(){
        try (FileWriter writer = new FileWriter("C://Users/"+ System.getProperty("user.name") +"/Desktop/group.txt"))
        {
            writer.write(toString());
            writer.flush();
        } catch (IOException ex){
            System.out.println("Что-то не так с записью в файл");
        }
    }

    public void readGroup(){
        try (FileReader fileReader = new FileReader("C://Users/"+ System.getProperty("user.name") +"/Desktop/group.txt"))
        {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()){
                String[] buf = bufferedReader.readLine().split(" ");
                    if (buf[0].equals("Группа")){
                        setGroupName(buf[1]);
                    } else {
                        try {
                            add(new Student(buf[1], buf[2], buf[0], Integer.parseInt(buf[4]), buf[6]));
                        } catch (GroupException e) {
                            System.out.println(e.getMessage() + ", " + e.getNumber());
                        }
                    }
            }
        } catch (IOException ex){
            System.out.println("Что-то не так с чтением файла");
        }
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

class GroupException extends Exception{
    private int number;
    public int getNumber(){return number;}
    public GroupException(String message, int num){
        super(message);
        number=num;
    }
}