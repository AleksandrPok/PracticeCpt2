package main;

public class Group {
    Student[] students = new Student[0];
    String groupName;

    public Group(String groupName){
        this.groupName = groupName;
    }

    public void add(Student newStudent) throws GroupException{
        if (students.length == 10) {
            throw new GroupException("В группе достаточно студентов", 1);
        } else {
            Student[] buf = new Student[students.length+1];
            buf[buf.length-1] = newStudent;
            for (int i = 0; i < students.length; i++) {
                buf[i] = students[i];
            }
            students = buf;
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

    public String findStudent(String surname){
        String result = "Студент не найден";
        for (Student s: students) {
            if (s.toString().contains(surname)) {
                result += s.toString() + "\n";
            }
        }
        return result.substring(17);
    }

    @Override
    public String toString(){
        Student[] buf = students;
        Student bufCell;
        String group = "";
        for (int i = buf.length-1; i >= 1; i--) {
            for (int j = 0; j < i; j++)
                if (needSwap(buf[j].toString().substring(8).toCharArray(), buf[j + 1].toString().substring(8).toCharArray())) {
                    bufCell = buf[j];
                    buf[j] = buf[j + 1];
                    buf[j + 1] = bufCell;
                }
        }
        for (Student s: buf){
            if (s != null){
                group += s.toString().substring(8) + "\n";
            }
        }
        return "Группа " + groupName + "\n" + group;
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

}

class GroupException extends Exception{
    private int number;
    public int getNumber(){return number;}
    public GroupException(String message, int num){
        super(message);
        number=num;
    }
}