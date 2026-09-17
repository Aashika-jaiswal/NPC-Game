package com.example.demo;
import java.util.UUID;

public class Memory {
    private String id;
    private String description;
    private int initialImpact;
    private int decayRate;
    private int daysElapsed;

    public Memory(String description, int initialImpact, int decayRate) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.initialImpact = initialImpact;
        this.decayRate = decayRate;
        this.daysElapsed = 0;
    }

    public int getCurrentScore() {
        return Math.max(0, initialImpact - (decayRate * daysElapsed));
    }
    
    public void age(int days) {
        this.daysElapsed += days;
    }

    // Getters for Spring Boot to convert to JSON
    public String getId() { return id; }
    public String getDescription() { return description; }
    public int getInitialImpact() { return initialImpact; }
    public int getDecayRate() { return decayRate; }
    public int getDaysElapsed() { return daysElapsed; }
}