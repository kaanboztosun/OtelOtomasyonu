package entity;

public class Odalar {

    private String room_number;
    private String type;
    private String capacity;
    private String available;

    public Odalar(String room_number, String type, String capacity, String available) {
        this.room_number = room_number;
        this.type = type;
        this.capacity = capacity;
        this.available = available;
    }

    public Odalar() {
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return room_number + "," + type + "," + capacity + "," + available;
    }

}

