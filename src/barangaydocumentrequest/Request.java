package barangaydocumentrequest;

public class Request {
    int id;
    String name;
    String gender;
    String address;
    String contactNumber;
    String documentType;

    public Request(int id, String name, String gender, String address, String contactNumber, String documentType) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.contactNumber = contactNumber;
        this.documentType = documentType;
    }

    public void displayRequest() {
        System.out.println("-----------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Document Type: " + documentType);
        System.out.println("-----------------------------");
    }
}
