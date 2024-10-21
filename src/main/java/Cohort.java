import java.util.ArrayList;
// higher level *abstraction* for a list
// of students of class Person
public class Cohort {
    ArrayList<Person> studentData = new ArrayList<>();

    public void addStudent(Person student) {
        this.studentData.add(student);
    }
    public ArrayList<Person> listOfStudents() {
        return studentData;
    }
}