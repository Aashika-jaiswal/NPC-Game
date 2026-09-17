package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/npcs")
@CrossOrigin(origins = "http://localhost:5173") 
public class NPCController {

    private final NPCService npcService;

    public NPCController(NPCService npcService) {
        this.npcService = npcService;
    }

    @GetMapping
    public List<NPC> getAll() {
        return npcService.getAllNPCs();
    }

    @GetMapping("/{id}")
    public NPC getNPC(@PathVariable String id) {
        return npcService.getNPC(id);
    }

    @PostMapping("/{id}/events")
    public NPC addEvent(@PathVariable String id, @RequestBody Map<String, Object> payload) {
        String desc = (String) payload.get("description");
        int impact = (int) payload.get("impact");
        int decay = (int) payload.get("decay");
        return npcService.recordInteraction(id, desc, impact, decay);
    }

    @PostMapping("/tick")
    public void advanceTime(@RequestBody Map<String, Integer> payload) {
        int days = payload.getOrDefault("days", 1);
        npcService.advanceTime(days);
    }
}