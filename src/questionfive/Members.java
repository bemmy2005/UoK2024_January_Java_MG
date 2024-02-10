package questionfive;



public class Members {
    protected int employeeID;
    protected String name;
    protected String phone;
    protected double registrationFee;

    public Members(int employeeID, String name, String phone, double registrationFee) {
        this.employeeID = employeeID;
        this.name = name;
        this.phone = phone;
        this.registrationFee = registrationFee;
    }
    public Members() {
    	
    }
    public void insert(int employeeID, String name, String phone, double registrationFee) {
        this.employeeID = employeeID;
        this.name = name;
        this.phone = phone;
        this.registrationFee = registrationFee;
    }
}
