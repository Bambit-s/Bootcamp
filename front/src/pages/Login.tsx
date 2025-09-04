import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthCard from "../components/AuthCard";
import InputField from "../components/InputField";
import { login } from "../api/auth";

interface LoginProps {
  setToken: (token: string) => void;
}

const Login: React.FC<LoginProps> = ({ setToken }) => {
  const [correo, setCorreo] = useState("");
  const [contrasena, setContrasena] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const token = await login({ correo, contrasena });
      localStorage.setItem("token", token);
      setToken(token); // обновляем состояние App
      navigate("/user/me");
    } catch {
      alert("Login failed");
    }
  };

  return (
    <AuthCard title="Login">
      <form onSubmit={handleSubmit} className="flex flex-col gap-2">
        <InputField type="text" placeholder="Correo" value={correo} onChange={setCorreo} />
        <InputField type="password" placeholder="Contraseña" value={contrasena} onChange={setContrasena} />
        <button className="btn btn-login">Login</button>
      </form>
    </AuthCard>
  );
};

export default Login;
