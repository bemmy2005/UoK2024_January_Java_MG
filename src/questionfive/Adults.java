package questionfive;

class Adults extends Members {
    private double discount;
   
    public Adults(int employeeID, String name, String phone, double registrationFee, double discount) {
        super(employeeID, name, phone, registrationFee);
        this.discount = discount;
    }

    public Adults() {  	
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

