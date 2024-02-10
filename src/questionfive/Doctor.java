package questionfive;

public class Doctor {
    private int doctorId;
    private String doctorName;
    private String email;
    private String phoneNumber;

    public Doctor(int doctorId, String doctorName, String email, String phoneNumber) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Insert method to insert doctor details
    public void insert(int doctorId, String doctorName, String email, String phoneNumber) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Display method to display doctor details
    public void display() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Doctor Name: " + doctorName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }

    // Getters and setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

