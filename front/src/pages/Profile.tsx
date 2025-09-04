import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import type { User } from "../types";
import { getMe, getAllUsers, updateUser } from "../api/user";

const Profile: React.FC = () => {
  const [user, setUser] = useState<User | null>(null);
  const [allUsers, setAllUsers] = useState<User[]>([]);
  const [formData, setFormData] = useState<Partial<User>>({});
  const [editMode, setEditMode] = useState(false);
  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  useEffect(() => {
    if (!token) {
      navigate("/login");
      return;
    }

    const fetchData = async () => {
      try {
        const me = await getMe(token);
        setUser(me);
        setFormData(me);

        // только для ролей 1 и 2 загружаем всех пользователей
        if (me.id_rol === 1 || me.id_rol === 2) {
          const users = await getAllUsers(token);
          setAllUsers(users);
        }
      } catch (err) {
        console.error(err);
        localStorage.removeItem("token");
        navigate("/login");
      }
    };

    fetchData();
  }, [token, navigate]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleUpdate = async () => {
    if (!token) return;
    try {
      const updated = await updateUser(token, formData);
      setUser(updated);
      setEditMode(false);
      // only for user with rol 1 or 2 
      if (updated.id_rol === 1 || updated.id_rol === 2) {
        const users = await getAllUsers(token);
        setAllUsers(users);
      }
    } catch (err) {
      console.error("Update failed", err);
    }
  };

  const handleLogout = () => {
    localStorage.removeItem("token");
    setUser(null);
    setAllUsers([]);
    navigate("/login");
  };

  if (!user) return <p>Loading...</p>;

  return (
    <div className="p-4">
      <h1>
        Welcome, {user.nombre} {user.apellido}
      </h1>
      <p>{user.correo}</p>

      {editMode ? (
        <div className="flex flex-col gap-2 max-w-xs">
          <input
            name="nombre"
            value={formData.nombre || ""}
            onChange={handleChange}
            placeholder="Nombre"
            className="p-2 border rounded"
          />
          <input
            name="apellido"
            value={formData.apellido || ""}
            onChange={handleChange}
            placeholder="Apellido"
            className="p-2 border rounded"
          />
          <input
            name="correo"
            value={formData.correo || ""}
            onChange={handleChange}
            placeholder="Correo"
            className="p-2 border rounded"
          />
          <input
            name="telefono"
            value={formData.telefono || ""}
            onChange={handleChange}
            placeholder="Teléfono"
            className="p-2 border rounded"
          />
          <div className="flex gap-2 mt-2">
            <button onClick={handleUpdate} className="btn btn-login">
              Save
            </button>
            <button onClick={() => setEditMode(false)} className="btn btn-cancel">
              Cancel
            </button>
          </div>
        </div>
      ) : (
        <button onClick={() => setEditMode(true)} className="btn btn-login mt-2">
          Edit Profile
        </button>
      )}

      <button onClick={handleLogout} className="btn btn-logout mt-2">
        Logout
      </button>

      {/* Список всех пользователей только для ролей 1 и 2 */}
      {(user.id_rol === 1 || user.id_rol === 2) && (
        <>
          <hr className="my-4" />
          <h3>All Users</h3>
          <ul className="list-disc ml-4">
            {allUsers.map((u) => (
              <li key={u.id}>
                {u.nombre} {u.apellido} ({u.correo})
              </li>
            ))}
          </ul>
        </>
      )}
    </div>
  );
};

export default Profile;
