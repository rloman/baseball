package eu.qnh.baseball.model;

import java.io.Serializable;

public class Ball implements Serializable {

    private double size;
    private double weight;


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "size=" + size +
                ", weight=" + weight +
                '}';
    }
}
