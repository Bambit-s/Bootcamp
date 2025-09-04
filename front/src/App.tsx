import React from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Profile from "./pages/Profile";

const App: React.FC = () => {
  const [token, setToken] = React.useState<string | null>(localStorage.getItem("token"));

  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login setToken={setToken} />} />
        <Route path="/register" element={<Register />} />
        <Route
          path="/user/me"
          element={token ? <Profile /> : <Navigate to="/login" replace />}
        />
        <Route path="*" element={<Navigate to={token ? "/user/me" : "/login"} replace />} />
      </Routes>
    </Router>
  );
};

export default App;
