import {getAllClients, createClient, deleteClient} from "./ClientService";
import {useEffect, useState} from "react";

function App() {
    const [clients, setClients] = useState([]);
    const [name, setName] = useState("");
    const [contact, setContact] = useState("");

    useEffect(() => {
        getAllClients()
            .then(data => setClients(data))
            .catch(error => console.error(error));
    }, []);
    const [, set] = useState();
    function handleCreateClient() {
        createClient({ name, contact })
            .then(newClient => {
                setClients([...clients, newClient]);
                setName("");
                setContact("");
            });
    }


    function handleDeleteClient(id) {
        deleteClient(id).then(() => {
            setClients(clients.filter(client => client.id !== id));
        });
    }


    return (
        <div style={{ padding: "20px" }}>
            <h1>Clients</h1>

            <h2>Add client</h2>

            <input
                placeholder="Name"
                value={name}
                onChange={e => setName(e.target.value)}
            />

            <input
                placeholder="Contact"
                value={contact}
                onChange={e => setContact(e.target.value)}
            />

            <button onClick={handleCreateClient}>Add</button>

            <hr />

            <ul>
                {clients.map(client => (
                    <li key={client.id}>
                        {client.name} — {client.contact}
                        <button onClick={() => handleDeleteClient(client.id)}>❌</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
