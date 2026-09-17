package com.example.demo;
import java.util.ArrayList;
import java.util.List;

public class NPC {
    private String id;
    private String name;
    private List<Memory> memories = new ArrayList<>();

    public NPC(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getTotalGrudgeScore() {
        return memories.stream().mapToInt(Memory::getCurrentScore).sum();
    }

    public String getAttitude() {
        int score = getTotalGrudgeScore();
        if (score == 0) return "Neutral";
        if (score < 50) return "Annoyed";
        if (score < 200) return "Angry";
        return "Hostile";
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Memory> getMemories() { return memories; }
}