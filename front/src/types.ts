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
  token?: string;
}

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
