// src/api/auth.ts
export interface AuthData {
  username: string;
  password: string;
}

export const login = async (data: AuthData) => {
  const res = await fetch("http://localhost:8080/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Login failed");
  const json = await res.json();
  return json.token;
};

export const register = async (data: AuthData) => {
  const res = await fetch("http://localhost:8080/auth/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Register failed");
  return await res.json();
};

export const getMe = async (token: string) => {
  const res = await fetch("http://localhost:8080/user/me", {
    headers: { Authorization: `Bearer ${token}` },
  });
  if (!res.ok) throw new Error("Unauthorized");
  return await res.json();
};
