import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        sms.loadFromFile();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (sms.searchStudent(id) != null) {
                        System.out.println("ID already exists!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    if (name.isEmpty() || course.isEmpty() || age <= 0) {
                        System.out.println("Invalid input!");
                        break;
                    }

                    sms.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    sms.removeStudent(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    Student s = sms.searchStudent(sc.nextInt());
                    System.out.println(s != null ? s : "Student not found!");
                    break;

                case 4:
                    sms.displayStudents();
                    break;

                case 5:
                    System.out.print("Enter ID to edit: ");
                    sms.editStudent(sc.nextInt(), sc);
                    break;

                case 6:
                    sms.saveToFile();
                    System.out.println("Data saved. Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}