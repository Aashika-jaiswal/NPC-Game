package com.example.demo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class NPCService {
    private final Map<String, NPC> npcDatabase = new LinkedHashMap<>();

    public NPCService() {
        // Create our starting character
        npcDatabase.put("1", new NPC("1", "Grom the Blacksmith"));
    }

    public List<NPC> getAllNPCs() {
        return new ArrayList<>(npcDatabase.values());
    }

    public NPC getNPC(String id) {
        return npcDatabase.get(id);
    }

    public NPC recordInteraction(String npcId, String description, int impact, int decay) {
        NPC npc = npcDatabase.get(npcId);
        if (npc != null) {
            npc.getMemories().add(new Memory(description, impact, decay));
        }
        return npc;
    }

    public void advanceTime(int days) {
        for (NPC npc : npcDatabase.values()) {
            npc.getMemories().removeIf(memory -> {
                memory.age(days);
                return memory.getCurrentScore() <= 0; // Delete if forgotten
            });
        }
    }
}