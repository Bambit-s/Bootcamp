// src/pages/Register.tsx
import React, { useState } from "react";
import AuthCard from "../components/AuthCard";
import InputField from "../components/InputField";
import { register } from "../api/auth";

const Register: React.FC = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await register({ username, password });
      alert("Registration successful!");
    } catch (err) {
      console.error(err);
      alert("Registration failed");
    }
  };

  return (
    <AuthCard title="Register">
      <form onSubmit={handleSubmit} className="flex flex-col gap-4">
        <InputField type="text" placeholder="Username" value={username} onChange={setUsername} />
        <InputField type="password" placeholder="Password" value={password} onChange={setPassword} />
        <button className="bg-green-500 text-white py-2 rounded hover:bg-green-600">Register</button>
      </form>
    </AuthCard>
  );
};

export default Register;
