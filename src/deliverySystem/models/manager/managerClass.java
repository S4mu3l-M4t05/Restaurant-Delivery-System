package deliverySystem.models.manager;

public class managerClass {

	private String id;
	private String username;
	private String password;
	private String restaurant_id;
	private String status;

	public managerClass(String id, String username, String password, String restaurant_id, String status) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.restaurant_id = restaurant_id;
		this.status = status;

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the restaurant_id
	 */
	public String getRestaurant_id() {
		return restaurant_id;
	}

	/**
	 * @param restaurant_id the restaurant_id to set
	 */
	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
