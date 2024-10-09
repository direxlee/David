package barangaydocumentrequest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--==| Barangay Document Request System |==--\n");
            System.out.println("1. Add Request");
            System.out.println("2. View Requests");
            System.out.println("3. Update Request");
            System.out.println("4. Delete Request");
            System.out.println("5. Exit");
            System.out.print("\nChoose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    BarangayDocumentRequestSystem.addRequest();
                    break;
                case 2:
                    BarangayDocumentRequestSystem.viewRequests();
                    break;
                case 3:
                    BarangayDocumentRequestSystem.updateRequest();
                    break;
                case 4:
                    BarangayDocumentRequestSystem.deleteRequest();
                    break;
                case 5:
                    System.out.println("Thank you! Exiting...");
                    break;
                default:
                    System.out.println("Oops! Invalid choice, please try again.");
            }
        } while (choice != 5);
    }
}
