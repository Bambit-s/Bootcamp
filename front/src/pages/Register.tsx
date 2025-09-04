import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthCard from "../components/AuthCard";
import InputField from "../components/InputField";
import type { RegisterData } from "../api/auth";
import { register } from "../api/auth";

interface RegisterProps {
  setToken?: (token: string) => void; // если захотим сразу логинить после регистрации
}

const Register: React.FC<RegisterProps> = ({ setToken }) => {
  const navigate = useNavigate();
  const [form, setForm] = useState<RegisterData>({
    nombre: "",
    apellido: "",
    nro_cedula: 0,
    contrasena: "",
    id_rol: 1,
    fecha_ingreso: "",
    correo: "",
    id_cargo: 1,
    id_equipo: 1,
    fecha_nacimiento: "",
    telefono: "",
  });

  const handleChange = (field: keyof RegisterData, value: string | number) => {
    setForm(prev => ({ ...prev, [field]: value }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await register(form);
      alert("Registration successful!");
      navigate("/login"); // редирект на логин
    } catch {
      alert("Registration failed");
    }
  };

  return (
    <AuthCard title="Register">
      <form onSubmit={handleSubmit} className="auth-form flex flex-col gap-2">
        <InputField type="text" placeholder="Nombre" value={form.nombre} onChange={v => handleChange("nombre", v)} />
        <InputField type="text" placeholder="Apellido" value={form.apellido} onChange={v => handleChange("apellido", v)} />
        <InputField type="number" placeholder="Nro. Cédula" value={form.nro_cedula.toString()} onChange={v => handleChange("nro_cedula", Number(v))} />
        <InputField type="password" placeholder="Contraseña" value={form.contrasena} onChange={v => handleChange("contrasena", v)} />
        <InputField type="text" placeholder="Correo" value={form.correo} onChange={v => handleChange("correo", v)} />
        <InputField type="date" placeholder="Fecha Nacimiento" value={form.fecha_nacimiento} onChange={v => handleChange("fecha_nacimiento", v)} />
        <InputField type="date" placeholder="Fecha Ingreso" value={form.fecha_ingreso} onChange={v => handleChange("fecha_ingreso", v)} />
        <InputField type="text" placeholder="Teléfono" value={form.telefono} onChange={v => handleChange("telefono", v)} />
        <button type="submit" className="btn btn-login mt-2">Register</button>
      </form>
    </AuthCard>
  );
};

export default Register;
