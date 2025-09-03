// src/pages/Register.tsx
import React, { useState } from "react";
import AuthCard from "../components/AuthCard";
import InputField from "../components/InputField";
import type { RegisterData } from "../api/auth";
import { register } from "../api/auth";

const Register: React.FC = () => {
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
    } catch (err) {
      console.error(err);
      alert("Registration failed");
    }
  };

  return (
    <AuthCard title="Register">
      <form onSubmit={handleSubmit} className="flex flex-col gap-4">
        <InputField type="text" placeholder="Nombre" value={form.nombre} onChange={v => handleChange("nombre", v)} />
        <InputField type="text" placeholder="Apellido" value={form.apellido} onChange={v => handleChange("apellido", v)} />
        <InputField type="number" placeholder="Nro. Cédula" value={form.nro_cedula.toString()} onChange={v => handleChange("nro_cedula", Number(v))} />
        <InputField type="password" placeholder="Contraseña" value={form.contrasena} onChange={v => handleChange("contrasena", v)} />
        <InputField type="text" placeholder="Correo" value={form.correo} onChange={v => handleChange("correo", v)} />
        <InputField type="text" placeholder="Fecha Nacimiento (YYYY-MM-DD)" value={form.fecha_nacimiento} onChange={v => handleChange("fecha_nacimiento", v)} />
        <InputField type="text" placeholder="Fecha Ingreso (YYYY-MM-DD)" value={form.fecha_ingreso} onChange={v => handleChange("fecha_ingreso", v)} />
        <InputField type="text" placeholder="Teléfono" value={form.telefono} onChange={v => handleChange("telefono", v)} />
        <button className="bg-green-500 text-white py-2 rounded hover:bg-green-600">Register</button>
      </form>
    </AuthCard>
  );
};

export default Register;
