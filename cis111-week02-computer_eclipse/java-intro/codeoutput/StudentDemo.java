class Student {
    private String name;      // fields
    private int credits;

    Student(String name) {    // constructor
        this.name = name;
        this.credits = 0;
    }

    void enroll(int c) {      // method
        credits += c;
    }

    @Override
    public String toString() {
        return name + " (" + credits + " cr)";
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student a = new Student("Zeynep");
        Student b = new Student("Can");
        a.enroll(6);
        a.enroll(4);
        b.enroll(5);
        System.out.println(a);
        System.out.println(b);
    }
}
