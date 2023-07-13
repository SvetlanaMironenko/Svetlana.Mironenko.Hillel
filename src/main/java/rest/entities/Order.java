package rest.entities;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Order {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;

    private String status;

    private boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", shipDate=" + shipDate +
                ", status='" + status + '\'' +
                ", complete=" + complete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return petId == order.petId
                && quantity == order.quantity
                && complete == order.complete
                && Objects.equals(convertToDateToCompare(shipDate), convertToDateToCompare(order.shipDate))
                && Objects.equals(status, order.status);
    }

    private String convertToDateToCompare(String strDateInISO) {
        DateTimeFormatter formatOfISODate = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime zdt = ZonedDateTime.parse(strDateInISO, formatOfISODate);
        DateTimeFormatter ourDateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return zdt.withZoneSameInstant(ZonedDateTime.now().getZone()).format(ourDateTimeFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, quantity, shipDate, status, complete);
    }
}
