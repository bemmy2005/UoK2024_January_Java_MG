package questionfive;

class Kids extends Members {
    private double discount;

    public Kids(int employeeID, String name, String phone, double registrationFee, double discount) {
        super(employeeID, name, phone, registrationFee);
        this.discount = discount;
    }
    public Kids() {
    	
    }
    public void insert(int employeeID, String name, String phone, double registrationFee, double discount) {
        super.insert(employeeID, name, phone, registrationFee);
        this.discount = discount;
    }

    public void display() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Registration Fee: " + registrationFee);
        System.out.println("Discount: " + discount);
    }
}