package barangaydocumentrequest;

import java.util.Scanner;

public class BarangayDocumentRequestSystem {
    static Scanner sc = new Scanner(System.in);
    static Request[] requests = new Request[100];
    static int numRequests = 0;

    public static void addRequest() {
        System.out.print("\nEnter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!isUniqueID(id)) {
            System.out.println("ID already exists. Please try a different one.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        String gender;
        while (true) {
            System.out.print("Enter Gender (Male/Female): ");
            gender = sc.nextLine();
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                break;
            } else {
                System.out.println("Invalid gender. Please enter 'Male' or 'Female'.");
            }
        }

        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String contactNumber = sc.nextLine();
        System.out.print("Enter Document Type: ");
        String documentType = sc.nextLine();

        if (!isUniquePhoneNumber(contactNumber)) {
            System.out.println("This phone number is already registered.");
            return;
        }

        requests[numRequests] = new Request(id, name, gender, address, contactNumber, documentType);
        numRequests++;
        System.out.println("\nRequest added successfully!");
    }

    public static void viewRequests() {
        if (numRequests == 0) {
            System.out.println("No requests to display.");
        } else {
            for (int i = 0; i < numRequests; i++) {
                requests[i].displayRequest();
            }
        }
    }

    public static void updateRequest() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numRequests; i++) {
            if (requests[i].id == id) {
                System.out.print("Enter new Name: ");
                requests[i].name = sc.nextLine();

                String gender;
                while (true) {
                    System.out.print("Enter new Gender (Male/Female): ");
                    gender = sc.nextLine();
                    if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                        requests[i].gender = gender;
                        break;
                    } else {
                        System.out.println("Invalid gender. Please enter 'Male' or 'Female'.");
                    }
                }

                System.out.print("Enter new Address: ");
                requests[i].address = sc.nextLine();
                System.out.print("Enter new Contact Number: ");
                requests[i].contactNumber = sc.nextLine();
                System.out.print("Enter new Document Type: ");
                requests[i].documentType = sc.nextLine();

                System.out.println("\nRequest updated successfully!");
                return;
            }
        }
        System.out.println("ID not found. Please check and try again.");
    }

    public static void deleteRequest() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < numRequests; i++) {
            if (requests[i].id == id) {
                found = true;
                for (int j = i; j < numRequests - 1; j++) {
                    requests[j] = requests[j + 1];
                }
                requests[numRequests - 1] = null;
                numRequests--;
                System.out.println("\nRequest deleted successfully!");
                 break;
            }
        }

        if (!found) {
            System.out.println("ID not found. Please check and try again.");
        }
    }

    public static boolean isUniqueID(int id) {
        for (int i = 0; i < numRequests; i++) {
            if (requests[i].id == id) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniquePhoneNumber(String contactNumber) {
        for (int i = 0; i < numRequests; i++) {
            if (requests[i].contactNumber.equals(contactNumber)) {
                return false;
            }
        }
        return true;
    }
}


