import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private double GPA;

    public boolean equals(Student other){
        if(this.lastName.equals(other.lastName))
            return this.firstName.equals(other.firstName);
        return false;
    }

    public Student() {
        firstName = null;
        lastName = null;
    }

    public Student(String F, String L) {
        firstName = F;
        lastName = L;
    }

    public Student(String F, String L, int A) {
        firstName = F;
        lastName = L;
        age = A;
    }

    public Student(String F,String L, int A, double G) {
        firstName = F;
        lastName = L;
        age = A;
        GPA = G;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}