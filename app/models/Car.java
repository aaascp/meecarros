package models;

import models.validators.annotations.MaxAge;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Car extends ModelEntity {
    private static final String validColors = "branco|preto|verde";

    @Column
    @NotNull
    @Min(1)
    private long userId;

    @Column
    @NotNull
    private String model;

    @Column
    @NotNull
    @MaxAge(value = 30)
    private int year;

    @Column
    @Pattern(regexp = validColors)
    private String color;

    public static String getValidColors() {
        return validColors;
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
