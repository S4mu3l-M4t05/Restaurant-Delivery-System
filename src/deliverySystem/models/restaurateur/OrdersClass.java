package deliverySystem.models.restaurateur;

public class OrdersClass {
	private int orderId;
	private int clientId;
	private int restaurantId;
	private String status;
	private int deliverymanId;
	private String deliveryTime;
	private String orderDetail;
	private String postalCode;
	private String address;

	// Constructor
	public OrdersClass(int orderId, int clientId, int restaurantId, String status, int deliverymanId,
			String deliveryTime, String orderDetail, String postalCode, String address) {
		this.orderId = orderId;
		this.clientId = clientId;
		this.restaurantId = restaurantId;
		this.status = status;
		this.deliverymanId = deliverymanId;
		this.deliveryTime = deliveryTime;
		this.orderDetail = orderDetail;
		this.postalCode = postalCode;
		this.address = address;

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	// Getters and Setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDeliverymanId() {
		return deliverymanId;
	}

	public void setDeliverymanId(int deliverymanId) {
		this.deliverymanId = deliverymanId;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	@Override
	public String toString() {
		return "Order ID: " + orderId + ", Status: " + status + ", Delivery Time: " + deliveryTime;
	}

}
