import { useEffect, useState } from "react";

function App() {
    const [clients, setClients] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/clients")
            .then(response => response.json())
            .then(data => setClients(data))
            .catch(error => console.error(error));
    }, []);

    return (
        <div>
            <h1>Clients</h1>

            <ul>
                {clients.map(client => (
                    <li key={client.id}>
                        {client.name} — {client.contact}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
