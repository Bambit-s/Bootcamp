// src/api/User.ts
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