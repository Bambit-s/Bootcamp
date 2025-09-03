// src/components/AuthPanel.tsx
import React, { useState, useEffect } from "react";

export interface User {
    id: number;
    username: string;
    nombre: string;
    apellido: string;
    correo: string;
    telefono: string;
    id_rol: number;
    id_cargo: number;
    id_equipo: number;
    token: string;
}

interface AuthPanelProps {
    token: string | null;
    setToken: (token: string | null) => void;
}

const AuthPanel: React.FC<AuthPanelProps> = ({ token, setToken }) => {
    const [user, setUser] = useState<User | null>(null);
    const [loading, setLoading] = useState(true);
    const [editMode, setEditMode] = useState(false);
    const [formData, setFormData] = useState<Partial<User>>({});

    useEffect(() => {
        if (token) {
            fetchUserData();
        } else {
            setLoading(false);
        }
    }, [token]);

    const fetchUserData = async () => {
        try {
            const response = await fetch("http://localhost:8080/user/me", {
                method: "GET",
                headers: {
                    "Authorization": `Bearer ${token}`,
                    "Content-Type": "application/json",
                },
            });

            if (response.ok) {
                const userData = await response.json();
                setUser(userData);
                setFormData(userData); // сразу заполняем форму
            } else {
                localStorage.removeItem("token");
                setToken(null);
            }
        } catch (error) {
            console.error("Error fetching user data:", error);
        } finally {
            setLoading(false);
        }
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleUpdate = async () => {
        if (!token) return;

        try {
            const response = await fetch("http://localhost:8080/user/update", {
                method: "POST",
                headers: {
                    "Authorization": `Bearer ${token}`,
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                const updatedUser = await response.json();
                setUser(updatedUser);
                setEditMode(false);
            } else {
                console.error("Failed to update user");
            }
        } catch (error) {
            console.error("Error updating user:", error);
        }
    };

    const handleLogout = () => {
        localStorage.removeItem("token");
        setToken(null);
        setUser(null);
    };

    if (!token) return null;
    if (loading) return <div>Loading user data...</div>;

    return (
        <div>
            <h1>Welcome, {user?.nombre} {user?.apellido}!</h1>
            <p>{user?.correo}</p>
            <p>Role: {user?.id_rol} • Team: {user?.id_equipo}</p>

            {editMode ? (
                <div>
                    <input
                        name="nombre"
                        value={formData.nombre || ""}
                        onChange={handleChange}
                        placeholder="Nombre"
                    />
                    <input
                        name="apellido"
                        value={formData.apellido || ""}
                        onChange={handleChange}
                        placeholder="Apellido"
                    />
                    <input
                        name="correo"
                        value={formData.correo || ""}
                        onChange={handleChange}
                        placeholder="Correo"
                    />
                    <input
                        name="telefono"
                        value={formData.telefono || ""}
                        onChange={handleChange}
                        placeholder="Telefono"
                    />
                    <button onClick={handleUpdate}>Save</button>
                    <button onClick={() => setEditMode(false)}>Cancel</button>
                </div>
            ) : (
                <button onClick={() => setEditMode(true)}>Edit Profile</button>
            )}

            <button onClick={handleLogout}>Logout</button>
        </div>
    );
};


export default AuthPanel;