package models;

public class Car {

    private long id;
    private long userId;
    private String model;
    private int year;
    private String color;

    public Car() {}

    public Car(long id, long userId, String model, int year, String color) {
        this.id = id;

        this.userId = userId;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String print() {
        return String.format(
                "\nUser: %d\nModel:%s\nYear: %d\nColor: %s",
                this.getUserId(),
                this.getModel(),
                this.getYear(),
                this.getColor());
    }
}
