package models;

import models.validators.MaxAge;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Car {
    private static final String validColors = "branco|preto|verde";

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @Column
    @NotNull
    @Min(1)
    private long userId;

    @Column
    @NotNull
    private String model;

    @Column
    @NotNull
    @MaxAge(value=30)
    private int year;

    @Column
    @Pattern(regexp = validColors)
    private String color;

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
        this.color = color.toLowerCase();
    }

    public String print() {
        return String.format(
                "\nID:%d\nUser: %d\nModel:%s\nYear: %d\nColor: %s",
                this.getId(),
                this.getUserId(),
                this.getModel(),
                this.getYear(),
                this.getColor());
    }
}
