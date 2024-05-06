package deliverySystem.models.deliveryman;

import java.util.ArrayList;
import java.util.List;

public class ViewDeliveriesModel {

    private List<String> deliveryData;

    public ViewDeliveriesModel() {
     
        deliveryData = new ArrayList<>();
        // Populate with some dummy data
        deliveryData.add("Delivery #1");
        deliveryData.add("Delivery #2");
        deliveryData.add("Delivery #3");
    }

  
    public List<String> getDeliveryData() {
        return deliveryData;
    }
  
   
}
