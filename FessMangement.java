import java.util.*;

public class FessMangement {

    static Scanner sc = new Scanner(System.in);
    static Fessinfo head = null;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== FEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Fees");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateFees();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }

    // Add Student
    static void addStudent() {

        System.out.print("Admission No: ");
        int admno = sc.nextInt();

        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Class: ");
        int cls = sc.nextInt();

        System.out.print("Phone Number: ");
        int phno = sc.nextInt();

        System.out.print("Fees: ");
        int fees = sc.nextInt();

        Fessinfo newNode = new Fessinfo(admno, name, cls, phno, fees);

        if (head == null) {
            head = newNode;
        } else {
            Fessinfo temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }

        System.out.println("Student Added Successfully.");
    }

    // Update Fees
    static void updateFees() {

        System.out.print("Enter Admission Number: ");
        int adm = sc.nextInt();

        Fessinfo temp = head;

        while (temp != null) {

            if (temp.admno == adm) {
                System.out.print("Enter New Fees: ");
                temp.fess = sc.nextInt();
                System.out.println("Fees Updated Successfully.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student Not Found.");
    }

    // Display
    static void display() {

        if (head == null) {
            System.out.println("No Records Found.");
            return;
        }

        Fessinfo temp = head;

        while (temp != null) {

            System.out.println("---------------------------");
            System.out.println("Admission No : " + temp.admno);
            System.out.println("Name         : " + temp.name);
            System.out.println("Class        : " + temp.cls);
            System.out.println("Phone        : " + temp.phno);
            System.out.println("Fees         : " + temp.fess);

            temp = temp.next;
        }
    }

    // Search
    static void searchStudent() {

        System.out.print("Enter Admission Number: ");
        int adm = sc.nextInt();

        Fessinfo temp = head;

        while (temp != null) {

            if (temp.admno == adm) {

                System.out.println("Student Found");
                System.out.println("Admission No : " + temp.admno);
                System.out.println("Name         : " + temp.name);
                System.out.println("Class        : " + temp.cls);
                System.out.println("Phone        : " + temp.phno);
                System.out.println("Fees         : " + temp.fess);

                return;
            }

            temp = temp.next;
        }

        System.out.println("Student Not Found.");
    }
}

class Fessinfo {

    int admno;
    String name;
    int cls;
    int phno;
    int fess;
    Fessinfo next;

    Fessinfo(int admno, String name, int cls, int phno, int fess) {
        this.admno = admno;
        this.name = name;
        this.cls = cls;
        this.phno = phno;
        this.fess = fess;
        this.next = null;
    }
}