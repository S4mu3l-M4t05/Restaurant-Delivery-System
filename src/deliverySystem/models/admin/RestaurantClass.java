package deliverySystem.models.admin;

public class RestaurantClass {

	private String id;
		private String name;
	    private String address;
	    private String phoneNumber;
	    private String deliveryArea;
	    
//	    Opening time for Sunday
	    private String openningHourSU;
	    private String openningMinSU;
//	    Opening time for Monday
	    private String openningHourMO;
	    private String openningMinMO;
//	    Opening time for Tuesday
	    private String openningHourTU;
	    private String openningMinTU;
//	    Opening time for Wednesday
	    private String openningHourWE;
	    private String openningMinWE;
//	    Opening time for Thursday
	    private String openningHourTH;
	    private String openningMinTH;
//	    Opening time for Friday
	    private String openningHourFR;
	    private String openningMinFR;
//	    Opening time for Saturday
	    private String openningHourSA;
	    private String openningMinSA;
	    
//	    Closing time for Sunday
	    private String closingHourSU;
	    private String closingMinSU;
//	    Closing time for Monday
	    private String closingHourMO;
	    private String closingMinMO;
//	    Closing time for Tuesday
	    private String closingHourTU;
	    private String closingMinTU;
//	    Closing time for Wednesday
	    private String closingHourWE;
	    private String closingMinWE;
//	    Closing time for Thursday
	    private String closingHourTH;
	    private String closingMinTH;
//	    Closing time for Friday
	    private String closingHourFR;
	    private String closingMinFR;
//	    Closing time for Saturday
	    private String closingHourSA;
	    private String closingMinSA;
	    
	    private String status;
	    private String manager_id;
	    

	    

	    public RestaurantClass(String id,String name,String address, String phoneNumber,
	    		String openningHourSU,String openningMinSU,String closingHourSU,String closingMinSU,
	    		String openningHourMO,String openningMinMO,String closingHourMO,String closingMinMO,
	    		String openningHourTU,String openningMinTU,String closingHourTU,String closingMinTU,
	    		String openningHourWE,String openningMinWE,String closingHourWE,String closingMinWE,
	    		String openningHourTH,String openningMinTH,String closingHourTH,String closingMinTH,
	    		String openningHourFR,String openningMinFR,String closingHourFR,String closingMinFR,
	    		String openningHourSA,String openningMinSA,String closingHourSA,String closingMinSA,
	    		String deliveryArea,String status,String manager_id ) {
	   
	    	this.id = id;
	        this.name = name;
	        this.address = address;
	        this.phoneNumber = phoneNumber;
	        this.openningHourSU = openningHourSU;
	        this.openningMinSU = openningMinSU;
	        this.closingHourSU = closingHourSU;
	        this.closingMinSU = closingMinSU;
	        
	        this.openningHourMO = openningHourMO;
	        this.openningMinMO = openningMinMO;
	        this.closingHourMO = closingHourMO;
	        this.closingMinMO = closingMinMO;
	        
	        this.openningHourTU = openningHourTU;
	        this.openningMinTU = openningMinTU;
	        this.closingHourTU = closingHourTU;
	        this.closingMinTU = closingMinTU;
	        
	        this.openningHourWE = openningHourWE;
	        this.openningMinWE = openningMinWE;
	        this.closingHourWE = closingHourWE;
	        this.closingMinWE = closingMinWE;
	        
	        this.openningHourTH = openningHourTH;
	        this.openningMinTH = openningMinTH;
	        this.closingHourTH = closingHourTH;
	        this.closingMinTH = closingMinTH;
	        
	        this.openningHourFR = openningHourFR;
	        this.openningMinFR = openningMinFR;
	        this.closingHourFR = closingHourFR;
	        this.closingMinFR = closingMinFR;
	        
	        this.openningHourSA = openningHourSA;
	        this.openningMinSA = openningMinSA;
	        this.closingHourSA = closingHourSA;
	        this.closingMinSA = closingMinSA;
	        
	        this.deliveryArea = deliveryArea;
	        this.status = status;
	        this.manager_id = manager_id;
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



		public RestaurantClass( String id, String name2){
	        this.id = id;
	        this.name = name2;
	    }




		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}




		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}




		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}




		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}




		/**
		 * @return the phoneNumber
		 */
		public String getPhoneNumber() {
			return phoneNumber;
		}




		/**
		 * @param phoneNumber the phoneNumber to set
		 */
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}




		/**
		 * @return the deliveryArea
		 */
		public String getDeliveryArea() {
			return deliveryArea;
		}




		/**
		 * @param deliveryArea the deliveryArea to set
		 */
		public void setDeliveryArea(String deliveryArea) {
			this.deliveryArea = deliveryArea;
		}




		/**
		 * @return the openningHourSU
		 */
		public String getOpenningHourSU() {
			return openningHourSU;
		}




		/**
		 * @param openningHourSU the openningHourSU to set
		 */
		public void setOpenningHourSU(String openningHourSU) {
			this.openningHourSU = openningHourSU;
		}




		/**
		 * @return the openningMinSU
		 */
		public String getOpenningMinSU() {
			return openningMinSU;
		}




		/**
		 * @param openningMinSU the openningMinSU to set
		 */
		public void setOpenningMinSU(String openningMinSU) {
			this.openningMinSU = openningMinSU;
		}




		/**
		 * @return the openningHourMO
		 */
		public String getOpenningHourMO() {
			return openningHourMO;
		}




		/**
		 * @param openningHourMO the openningHourMO to set
		 */
		public void setOpenningHourMO(String openningHourMO) {
			this.openningHourMO = openningHourMO;
		}




		/**
		 * @return the openningMinMO
		 */
		public String getOpenningMinMO() {
			return openningMinMO;
		}




		/**
		 * @param openningMinMO the openningMinMO to set
		 */
		public void setOpenningMinMO(String openningMinMO) {
			this.openningMinMO = openningMinMO;
		}




		/**
		 * @return the openningHourTU
		 */
		public String getOpenningHourTU() {
			return openningHourTU;
		}




		/**
		 * @param openningHourTU the openningHourTU to set
		 */
		public void setOpenningHourTU(String openningHourTU) {
			this.openningHourTU = openningHourTU;
		}




		/**
		 * @return the openningMinTU
		 */
		public String getOpenningMinTU() {
			return openningMinTU;
		}




		/**
		 * @param openningMinTU the openningMinTU to set
		 */
		public void setOpenningMinTU(String openningMinTU) {
			this.openningMinTU = openningMinTU;
		}




		/**
		 * @return the openningHourWE
		 */
		public String getOpenningHourWE() {
			return openningHourWE;
		}




		/**
		 * @param openningHourWE the openningHourWE to set
		 */
		public void setOpenningHourWE(String openningHourWE) {
			this.openningHourWE = openningHourWE;
		}




		/**
		 * @return the openningMinWE
		 */
		public String getOpenningMinWE() {
			return openningMinWE;
		}




		/**
		 * @param openningMinWE the openningMinWE to set
		 */
		public void setOpenningMinWE(String openningMinWE) {
			this.openningMinWE = openningMinWE;
		}




		/**
		 * @return the openningHourTH
		 */
		public String getOpenningHourTH() {
			return openningHourTH;
		}




		/**
		 * @param openningHourTH the openningHourTH to set
		 */
		public void setOpenningHourTH(String openningHourTH) {
			this.openningHourTH = openningHourTH;
		}




		/**
		 * @return the openningMinTH
		 */
		public String getOpenningMinTH() {
			return openningMinTH;
		}




		/**
		 * @param openningMinTH the openningMinTH to set
		 */
		public void setOpenningMinTH(String openningMinTH) {
			this.openningMinTH = openningMinTH;
		}




		/**
		 * @return the openningHourFR
		 */
		public String getOpenningHourFR() {
			return openningHourFR;
		}




		/**
		 * @param openningHourFR the openningHourFR to set
		 */
		public void setOpenningHourFR(String openningHourFR) {
			this.openningHourFR = openningHourFR;
		}




		/**
		 * @return the openningMinFR
		 */
		public String getOpenningMinFR() {
			return openningMinFR;
		}




		/**
		 * @param openningMinFR the openningMinFR to set
		 */
		public void setOpenningMinFR(String openningMinFR) {
			this.openningMinFR = openningMinFR;
		}




		/**
		 * @return the openningHourSA
		 */
		public String getOpenningHourSA() {
			return openningHourSA;
		}




		/**
		 * @param openningHourSA the openningHourSA to set
		 */
		public void setOpenningHourSA(String openningHourSA) {
			this.openningHourSA = openningHourSA;
		}




		/**
		 * @return the openningMinSA
		 */
		public String getOpenningMinSA() {
			return openningMinSA;
		}




		/**
		 * @param openningMinSA the openningMinSA to set
		 */
		public void setOpenningMinSA(String openningMinSA) {
			this.openningMinSA = openningMinSA;
		}




		/**
		 * @return the closingHourSU
		 */
		public String getClosingHourSU() {
			return closingHourSU;
		}




		/**
		 * @param closingHourSU the closingHourSU to set
		 */
		public void setClosingHourSU(String closingHourSU) {
			this.closingHourSU = closingHourSU;
		}




		/**
		 * @return the closingMinSU
		 */
		public String getClosingMinSU() {
			return closingMinSU;
		}




		/**
		 * @param closingMinSU the closingMinSU to set
		 */
		public void setClosingMinSU(String closingMinSU) {
			this.closingMinSU = closingMinSU;
		}




		/**
		 * @return the closingHourMO
		 */
		public String getClosingHourMO() {
			return closingHourMO;
		}




		/**
		 * @param closingHourMO the closingHourMO to set
		 */
		public void setClosingHourMO(String closingHourMO) {
			this.closingHourMO = closingHourMO;
		}




		/**
		 * @return the closingMinMO
		 */
		public String getClosingMinMO() {
			return closingMinMO;
		}




		/**
		 * @param closingMinMO the closingMinMO to set
		 */
		public void setClosingMinMO(String closingMinMO) {
			this.closingMinMO = closingMinMO;
		}




		/**
		 * @return the closingHourTU
		 */
		public String getClosingHourTU() {
			return closingHourTU;
		}




		/**
		 * @param closingHourTU the closingHourTU to set
		 */
		public void setClosingHourTU(String closingHourTU) {
			this.closingHourTU = closingHourTU;
		}




		/**
		 * @return the closingMinTU
		 */
		public String getClosingMinTU() {
			return closingMinTU;
		}




		/**
		 * @param closingMinTU the closingMinTU to set
		 */
		public void setClosingMinTU(String closingMinTU) {
			this.closingMinTU = closingMinTU;
		}




		/**
		 * @return the closingHourWE
		 */
		public String getClosingHourWE() {
			return closingHourWE;
		}




		/**
		 * @param closingHourWE the closingHourWE to set
		 */
		public void setClosingHourWE(String closingHourWE) {
			this.closingHourWE = closingHourWE;
		}




		/**
		 * @return the closingMinWE
		 */
		public String getClosingMinWE() {
			return closingMinWE;
		}




		/**
		 * @param closingMinWE the closingMinWE to set
		 */
		public void setClosingMinWE(String closingMinWE) {
			this.closingMinWE = closingMinWE;
		}




		/**
		 * @return the closingHourTH
		 */
		public String getClosingHourTH() {
			return closingHourTH;
		}




		/**
		 * @param closingHourTH the closingHourTH to set
		 */
		public void setClosingHourTH(String closingHourTH) {
			this.closingHourTH = closingHourTH;
		}




		/**
		 * @return the closingMinTH
		 */
		public String getClosingMinTH() {
			return closingMinTH;
		}




		/**
		 * @param closingMinTH the closingMinTH to set
		 */
		public void setClosingMinTH(String closingMinTH) {
			this.closingMinTH = closingMinTH;
		}




		/**
		 * @return the closingHourFR
		 */
		public String getClosingHourFR() {
			return closingHourFR;
		}




		/**
		 * @param closingHourFR the closingHourFR to set
		 */
		public void setClosingHourFR(String closingHourFR) {
			this.closingHourFR = closingHourFR;
		}




		/**
		 * @return the closingMinFR
		 */
		public String getClosingMinFR() {
			return closingMinFR;
		}




		/**
		 * @param closingMinFR the closingMinFR to set
		 */
		public void setClosingMinFR(String closingMinFR) {
			this.closingMinFR = closingMinFR;
		}




		/**
		 * @return the closingHourSA
		 */
		public String getClosingHourSA() {
			return closingHourSA;
		}




		/**
		 * @param closingHourSA the closingHourSA to set
		 */
		public void setClosingHourSA(String closingHourSA) {
			this.closingHourSA = closingHourSA;
		}




		/**
		 * @return the closingMinSA
		 */
		public String getClosingMinSA() {
			return closingMinSA;
		}




		/**
		 * @param closingMinSA the closingMinSA to set
		 */
		public void setClosingMinSA(String closingMinSA) {
			this.closingMinSA = closingMinSA;
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
	    /**
		 * @return the manager_id
		 */
		public String getManager_id() {
			return manager_id;
		}



		/**
		 * @param manager_id the manager_id to set
		 */
		public void setManager_id(String manager_id) {
			this.manager_id = manager_id;
		}


	
	    
	}


