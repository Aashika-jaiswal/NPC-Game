# 🧠 NPC Memory Engine

A full-stack application that simulates dynamic NPC (Non-Player Character) memory and relationship systems. Instead of static dialogue arrays, NPCs in this engine remember interactions, hold grudges, and gradually forget events over time based on an importance-weighted decay model.

## ✨ Features

- **Weighted Memory Decay:** Interactions are assigned an "Impact Score" and a "Decay Rate." Minor insults are forgotten quickly, while major transgressions are remembered for years.
- **Dynamic Attitude Shifts:** An NPC's overall attitude (Neutral, Annoyed, Angry, Hostile) is calculated in real-time based on their cumulative grudge score.
- **Time Simulation:** A temporal engine allows developers to pass in-game days, automatically aging and pruning expired memories from the database.
- **Decoupled Architecture:** Clean separation between the React Vite frontend and the Java Spring Boot REST API.

## 🛠️ Tech Stack

**Frontend:**
- React 18
- Vite
- CSS3 (Custom Variables & Grid Layout)
- Lucide React (UI Icons)

**Backend:**
- Java
- Spring Boot (Web, REST)
- Maven
- In-Memory Data Structures (Designed for easy database swapping later)

## 📂 Project Structure

```text
NPC-Game/
├── backend/
│   └── demo/                 # Spring Boot application
│       ├── pom.xml           # Maven dependencies
│       └── src/main/java/... # Controllers, Models, and Services
│
└── frontend/                 # React application
    ├── package.json          # Node dependencies
    ├── vite.config.js        # Vite configuration
    └── src/                  # React components and CSS
        ├── App.jsx           # Main UI logic and API fetching
        └── main.jsx          # React entry point



```

## 🚀 Getting Started

### Prerequisites
- Node.js (v18+ recommended)
- Java Development Kit (JDK) 17 or higher
- Git

### 1. Clone the Repository
To test this project locally, first clone the repository from GitHub:
```bash
git clone [https://github.com/Aashika-jaiswal/NPC-Game.git](https://github.com/Aashika-jaiswal/NPC-Game.git)
cd NPC-Game

