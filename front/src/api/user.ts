import type { User } from "../types";

const BASE_URL = "http://localhost:8080";

export const getMe = async (token: string): Promise<User> => {
  const res = await fetch(`${BASE_URL}/user/me`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  if (!res.ok) throw new Error("Unauthorized");
  return await res.json();
};

export const getAllUsers = async (token: string): Promise<User[]> => {
  const res = await fetch(`${BASE_URL}/user/all`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  if (!res.ok) throw new Error("Failed to fetch users");
  return await res.json();
};

export const updateUser = async (token: string, data: Partial<User>): Promise<User> => {
  const res = await fetch(`${BASE_URL}/user/update`, {
    method: "POST",
    headers: {
      "Authorization": `Bearer ${token}`,
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Failed to update user");
  return await res.json();
};
