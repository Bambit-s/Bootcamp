import type { LoginData, RegisterData } from "../types";

const BASE_URL = "http://localhost:8080";

export const login = async (data: LoginData): Promise<string> => {
  const res = await fetch(`${BASE_URL}/auth/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Login failed");
  const json = await res.json();
  return json.token;
};

export const register = async (data: RegisterData) => {
  const res = await fetch(`${BASE_URL}/auth/register`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Register failed");
  return await res.json();
};
