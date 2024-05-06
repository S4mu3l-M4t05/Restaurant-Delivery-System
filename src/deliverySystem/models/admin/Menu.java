package deliverySystem.models.admin;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<MenuItem> items;

	public Menu() {
		this.items = new ArrayList<>();
	}

	public void addItem(MenuItem item) {
		items.add(item);
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void displayMenu() {
		System.out.println("Menu Items:");
		for (MenuItem item : items) {
			System.out.println(item);
		}
	}
}
