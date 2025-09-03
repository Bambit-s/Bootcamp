// src/api/auth.ts
export interface LoginData {
  correo: string;
  contrasena: string;
}

export interface RegisterData {
  nombre: string;
  apellido: string;
  nro_cedula: number;
  contrasena: string;
  id_rol: number;
  fecha_ingreso: string; // YYYY-MM-DD
  correo: string;
  id_cargo: number;
  id_equipo: number;
  fecha_nacimiento: string; // YYYY-MM-DD
  telefono: string;
}

export const login = async (data: LoginData) => {
  const res = await fetch("http://localhost:8080/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Login failed");
  const json = await res.json();
  return json.token;
};

export const register = async (data: RegisterData) => {
  const res = await fetch("http://localhost:8080/auth/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Register failed");
  return await res.json();
};

// export const getMe = async (token: string) => {
//   const res = await fetch("http://localhost:8080/user/me", {
//     headers: { Authorization: `Bearer ${token}` },
//   });
//   if (!res.ok) throw new Error("Unauthorized");
//   return await res.json();
// };
