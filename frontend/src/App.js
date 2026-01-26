import { getAllClients, createClient, deleteClient, updateClient } from "./ClientService";
import { useEffect, useState } from "react";
import "./App.css";

const apiUrl = process.env.REACT_APP_API_URL || "http://localhost:8080";

function App() {
    const [clients, setClients] = useState([]);
    const [name, setName] = useState("");
    const [contact, setContact] = useState("");
    const [address, setAddress] = useState("");
    const [editingId, setEditingId] = useState(null);

    useEffect(() => {
        refreshClients();
    }, []);

    const refreshClients = () => {
        getAllClients()
            .then(data => {
                console.log("Clients from backend:", data);
                setClients(data);
            })
            .catch(console.error);
    };

    function resetForm() {
        setName("");
        setContact("");
        setAddress("");
        setEditingId(null);
    }

    function handleSubmit() {
        if (!name.trim() || !contact.trim() || !address.trim()) {
            alert("Fields can't be empty");
            return;
        }
        if (name.length < 2 || name.length > 12) {
            alert("Name must be 2-12 letters");
            return;
        }
        if (contact.length < 2 || contact.length > 24) {
            alert("Contact must be 2-24 characters");
            return;
        }
        if (address.length < 2 || address.length > 32) {
            alert("Contact must be 2-24 characters");
            return;
        }

        if (editingId) {
            updateClient(editingId, { name, contact, address }).then(updated => {
                setClients(clients.map(c => c.id === updated.id ? updated : c));
                resetForm();
            });
        } else {
            createClient({ name, contact, address }).then(newClient => {
                setClients([...clients, newClient]);
                resetForm();
            });
        }
    }

    const DownloadButton = ({ client }) => {
        const downloadFile = async () => {
            try {
                const response = await fetch(`${apiUrl}/clients/download/${client.id}`);
                if (!response.ok) throw new Error("Failed to fetch client data");

                const blob = await response.blob();
                const url = window.URL.createObjectURL(blob);
                const link = document.createElement("a");
                link.href = url;
                link.setAttribute("download", `client_${client.id}.csv`);
                document.body.appendChild(link);
                link.click();
                link.remove();
                window.URL.revokeObjectURL(url);
            } catch (err) {
                console.error("Download error:", err);
                alert("Download error.");
            }
        };

        return <button onClick={downloadFile}>Download</button>;
    };

    function handleEdit(client) {
        setEditingId(client.id);
        setName(client.name);
        setContact(client.contact);
        setAddress(client.address);
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
                <input
                    placeholder="Adress"
                    value={address}
                    onChange={e => setAddress(e.target.value)}
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
                            <div>{client.address}</div>
                        </div>
                        <div className="actions">
                            <button onClick={() => handleEdit(client)}>Edit</button>
                            <button className="delete" onClick={() => handleDelete(client.id)}>Delete</button>
                            <DownloadButton client={client} />
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
