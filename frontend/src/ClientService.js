const BASE_URL = "http://localhost:8080/clients";

export function getAllClients() {
    return fetch(BASE_URL)
        .then(response => response.json());
}

export function createClient(client) {
    return fetch(BASE_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(client)
    }).then(response => response.json());
}

export function deleteClient(id) {
    return fetch(`${BASE_URL}/${id}`, {
        method: "DELETE"
    });
}
