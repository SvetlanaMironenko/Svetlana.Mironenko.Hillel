package api;

import org.testng.Assert;
import org.testng.annotations.Test;
import rest.PetStoreController;
import rest.entities.Order;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class PetStoreApiTests {

    @Test
    public void addNewPetTest() throws IOException {
        PetStoreController postController = new PetStoreController();
        postController.createNewPetWithJson();
    }

    @Test
    public void getPetTest() throws IOException {
        PetStoreController postController = new PetStoreController();
        postController.getPetById(10);
    }

    @Test
    public void addOrderTest() throws IOException {
        PetStoreController postController = new PetStoreController();
        postController.addOrder();
    }

    @Test
    public void addOrderTestGson() throws IOException {
        PetStoreController postController = new PetStoreController();
        Order order = new Order();
        order.setId(10);
        order.setPetId(198772);
        order.setQuantity(7);
        ZonedDateTime zdt = ZonedDateTime.now();
        order.setShipDate(zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        order.setStatus("approved");
        order.setComplete(true);

        Order newOrder = postController.addOrderWithGson(order);
        Assert.assertEquals(order, newOrder, "Order is not created successfully");
        Assert.assertFalse(newOrder.getId() == 0);
    }

}
