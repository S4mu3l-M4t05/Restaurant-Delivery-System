package deliverySystem.models.deliveryman;

public class DeliveryManClass {
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private String deliveryArea;
    private String status;

    // Constructor
    public DeliveryManClass(String username, String password, String name, String phoneNumber, String deliveryArea, String status) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.deliveryArea = deliveryArea;
        this.status = status;
    }
    public DeliveryManClass(String username ,String name, String phoneNumber, String deliveryArea) {
    	this.username=username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.deliveryArea = deliveryArea;
        //this.status = status;
    }
    public DeliveryManClass(String username , String status) {
    	this.username=username;
        this.status = status;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }
}
