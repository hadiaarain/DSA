import java.util.LinkedList;

public class search {
    public class Student {
        public int rollno;
        public String name;

        public Student(String name, int rollno) {
            this.name = name;
            this.rollno = rollno;
        }
    }

    public boolean searchStudent(LinkedList<Student> students, int rollno, String name) {
        for (Student student : students) {
            if (student.rollno == rollno && student.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        search s = new search();
        LinkedList<Student> students = new LinkedList<>();
        students.add(s.new Student("Alice", 1));
        students.add(s.new Student("Bob", 2));
        students.add(s.new Student("Charlie", 3));

        boolean found = s.searchStudent(students, 2, "Bob");
        System.out.println("Student found: " + found);
    }
}
