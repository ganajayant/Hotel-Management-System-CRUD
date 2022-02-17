package OtherClasses;

public class Rooms {
    private int RoomNo = 0;
    private String Type;
    private double CostPerHour;
    private int Capacity;
    private String Vacancy;

    public Rooms(String Type, double CostPerHour, int Capacity, String Vacancy) {
        this.Type = Type;
        this.CostPerHour = CostPerHour;
        this.Capacity = Capacity;
        this.Vacancy = Vacancy;
    }

    public Rooms(int RoomNo, String Type, double CostPerHour, int Capacity, String Vacancy) {
        this.RoomNo = RoomNo;
        this.Type = Type;
        this.CostPerHour = CostPerHour;
        this.Capacity = Capacity;
        this.Vacancy = Vacancy;
    }

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int roomNo) {
        this.RoomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Type: " + Type + " Cost Per Hour: " + CostPerHour + " Capacity: " + Capacity + " Vacancy: " + Vacancy;
    }

    public String getType() {
        return Type;
    }

    public double getCostPerHour() {
        return CostPerHour;
    }

    public int getCapacity() {
        return Capacity;
    }

    public String getVacancy() {
        return Vacancy;
    }
}
