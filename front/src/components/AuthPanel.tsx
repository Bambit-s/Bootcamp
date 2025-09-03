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
            } else {
                console.error("Failed to fetch user data");
                localStorage.removeItem("token");
                setToken(null);
            }
        } catch (error) {
            console.error("Error fetching user data:", error);
        } finally {
            setLoading(false);
        }
    };

    const handleLogout = () => {
        localStorage.removeItem("token");
        setToken(null);
        setUser(null);
    };

    if (!token) return null;

    if (loading) {
        return (
            <div>Loading user data...</div>
        );
    }

    return (

        <div>
            <h1>
                Welcome, {user?.nombre} {user?.apellido}!
            </h1>
            <p>{user?.correo}</p>
            <p>
                Role: {user?.id_rol} • Team: {user?.id_equipo}
            </p>
            <span>
                {user?.telefono && `Tel: ${user.telefono}`}
            </span>
            <button
                onClick={handleLogout}
            >
                Logout
            </button>
        </div>
    );
};

export default AuthPanel;