package deliverySystem.models.admin;

public class MenuItem {
	private String itemName;
	private double price;

	public MenuItem(String itemName, double price) {
		this.itemName = itemName;
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return itemName + " - $" + price;
	}
}
