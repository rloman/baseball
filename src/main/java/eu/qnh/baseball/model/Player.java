package eu.qnh.baseball.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String position;
    private int shirtNumber;

    public Player() {

    }

    // for testing purposes only
    public Player(long id) {
        this.id = id;
    }

    @ManyToOne
    private Team team;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shirtNumber=" + shirtNumber +
                '}';
    }
}
