package deliverySystem.models.admin;


import java.util.ArrayList;
import java.util.List;

public class DeliveryMan {
	private String name;
    private String username;
    private String password;
    private String telephone;
    private List<String> deliveryAreas;

    public DeliveryMan(String name ,String username, String password, String telephone) {
    	this.name=name;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.deliveryAreas = new ArrayList<>();
    }

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<String> getDeliveryAreas() {
        return deliveryAreas;
    }

    public void addDeliveryArea(String area) {
        deliveryAreas.add(area);
    }

    public void removeDeliveryArea(String area) {
        deliveryAreas.remove(area);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
