import { getAllClients, createClient, deleteClient, updateClient } from "./ClientService";
import { useEffect, useState } from "react";
import "./App.css";

const apiUrl = process.env.REACT_APP_API_URL || "http://localhost:8080";

fetch(`${apiUrl}/api/endpoint`)
    .then(res => res.json())
    .then(data => console.log(data));


function App() {
    const [clients, setClients] = useState([]);
    const [name, setName] = useState("");
    const [contact, setContact] = useState("");
    const [editingId, setEditingId] = useState(null);

    useEffect(() => {
        getAllClients()
            .then(setClients)
            .catch(console.error);
    }, []);

    function resetForm() {
        setName("");
        setContact("");
        setEditingId(null);
    }

    function handleSubmit() {
        if (!name.trim() || !contact.trim()) {
            alert("Fields can't be empty");
            return;
        }

        if (name.length < 2 || name.length > 12) {
            alert("Name can't be shorter then 2 letters, or longer than 12")
            return;
        }

        if (contact.length < 2 || contact.length > 24) {
            alert("Contact can't be shorter then 2, or longer than ")
            return;
        }


        if (editingId) {
            updateClient(editingId, { name, contact }).then(updated => {
                setClients(clients.map(c => c.id === updated.id ? updated : c));
                resetForm();
            });
        } else {
            createClient({ name, contact }).then(newClient => {
                setClients([...clients, newClient]);
                resetForm();
            });
        }
    }

    function handleEdit(client) {
        setEditingId(client.id);
        setName(client.name);
        setContact(client.contact);
    }

    function handleDelete(id) {
        deleteClient(id).then(() => {
            setClients(clients.filter(c => c.id !== id));
        });
    }

    return (
        <div className="container">
            <h1>Clients</h1>

            <div className="form">
                <h2>{editingId ? "Edit client" : "Add client"}</h2>
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
                <button className="main" onClick={handleSubmit}>
                    {editingId ? "Update" : "Add"}
                </button>
                {editingId && (
                    <button className="cancel" onClick={resetForm}>
                        Cancel
                    </button>
                )}
            </div>

            <ul className="clients-list">
                {clients.map(client => (
                    <li key={client.id} className="client-card">
                        <div>
                            <strong>{client.name}</strong>
                            <div>{client.contact}</div>
                        </div>
                        <div className="actions">
                            <button onClick={() => handleEdit(client)}>Edit</button>
                            <button className="delete" onClick={() => handleDelete(client.id)}>❌</button>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
