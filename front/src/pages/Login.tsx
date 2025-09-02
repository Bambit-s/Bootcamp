// src/pages/Login.tsx
import React, { useState } from "react";
import AuthCard from "../components/AuthCard";
import InputField from "../components/InputField";
import { login } from "../api/auth";

const Login: React.FC = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const token = await login({ username, password });
      localStorage.setItem("token", token);
      alert("Login successful!");
    } catch (err) {
      console.error(err);
      alert("Login failed");
    }
  };

  return (
    <AuthCard title="Login">
      <form onSubmit={handleSubmit} className="flex flex-col gap-4">
        <InputField type="text" placeholder="Username" value={username} onChange={setUsername} />
        <InputField type="password" placeholder="Password" value={password} onChange={setPassword} />
        <button className="bg-blue-500 text-white py-2 rounded hover:bg-blue-600">Login</button>
      </form>
    </AuthCard>
  );
};

export default Login;
