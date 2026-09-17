import { useState, useEffect } from 'react';
import { Flame, Frown, ShieldAlert } from 'lucide-react';
import './App.css';

function App() {
  const [npc, setNpc] = useState(null);

  const fetchNPC = async () => {
    try {
      const res = await fetch('http://localhost:8080/api/npcs/1');
      const data = await res.json();
      setNpc(data);
    } catch (error) {
      console.error("Backend error:", error);
    }
  };

  useEffect(() => {
    fetchNPC();
  }, []);

  const handleAction = async (description, impact, decay) => {
    await fetch('http://localhost:8080/api/npcs/1/events', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ description, impact, decay })
    });
    fetchNPC();
  };

  const passTime = async (days) => {
    await fetch('http://localhost:8080/api/npcs/tick', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ days })
    });
    fetchNPC();
  };

  if (!npc) return <div className="container"><h2>Connecting to Java backend...</h2><p>Make sure your Spring Boot server is running.</p></div>;

  return (
    <div className="container">
      <header>
        <h1>{npc.name}</h1>
        <div className={`status-badge ${npc.attitude.toLowerCase()}`}>
           {npc.attitude} (Grudge: {npc.totalGrudgeScore})
        </div>
      </header>

      <div className="grid">
        <section className="actions">
          <h2>Player Actions</h2>
          <button onClick={() => handleAction("Minor Insult", 20, 5)}>
            <Frown size={16}/> Minor Insult
          </button>
          <button onClick={() => handleAction("Stole Sweetroll", 50, 2)}>
            <ShieldAlert size={16}/> Steal Sweetroll
          </button>
          <button onClick={() => handleAction("Burned Farm", 1000, 1)} className="danger">
            <Flame size={16}/> Burn Farm
          </button>
          <br/>
          <button onClick={() => passTime(1)} className="time-btn">Pass 1 Day</button>
          <button onClick={() => passTime(30)} className="time-btn">Pass 30 Days</button>
        </section>

        <section className="memories">
          <h2>Active Memories</h2>
          {npc.memories.length === 0 ? (
            <p className="empty">The NPC's mind is clear. No grudges held.</p>
          ) : (
            <ul className="memory-list">
              {npc.memories.map(m => (
                <li key={m.id}>
                  <div className="memory-info">
                    <strong>{m.description}</strong>
                    <span>Score: {m.currentScore}</span>
                  </div>
                  <div className="memory-meta">
                    Fades at {m.decayRate} pts/day (Forgotten in {Math.ceil(m.currentScore / m.decayRate)} days)
                  </div>
                </li>
              ))}
            </ul>
          )}
        </section>
      </div>
    </div>
  );
}

export default App;