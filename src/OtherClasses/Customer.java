package OtherClasses;

public class Customer {
    private String Name;
    private String CustomerPh;
    private String PaymentStatus;
    private double Amount;
    private int RoomAllocated;

    public Customer(String Name, String CustomerPh, String paymentStatus, double Amount, int RoomAllocated) {
        this.Name = Name;
        this.CustomerPh = CustomerPh;
        this.PaymentStatus = paymentStatus;
        this.Amount = Amount;
        this.RoomAllocated = RoomAllocated;
    }

    @Override
    public String toString() {
        return "Name: " + Name + " Payment Status: " + PaymentStatus;
    }

    public String getName() {
        return Name;
    }

    public String getCustomerPh() {
        return CustomerPh;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public double getAmount() {
        return Amount;
    }

    public int getRoomAllocated() {
        return RoomAllocated;
    }
}