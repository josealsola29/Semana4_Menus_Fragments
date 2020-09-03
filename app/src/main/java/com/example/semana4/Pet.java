package com.example.semana4;

public class Pet {
    private String petName;
    private int petPoints;
    private int petImage;

    public Pet(String petName, int petPoints, int petImage) {
        this.petName = petName;
        this.petPoints = petPoints;
        this.petImage = petImage;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetPoints() {
        return petPoints;
    }

    public void setPetPoints(int petPoints) {
        this.petPoints = petPoints;
    }

    public int getPetImage() {
        return petImage;
    }

    public void setPetImage(int petImage) {
        this.petImage = petImage;
    }
}
