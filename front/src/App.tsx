// src/App.tsx
import React from "react";
import Login from "./pages/Login";
import Register from "./pages/Register";
import AuthPanel from "./components/AuthPanel";

const App: React.FC = () => {
  const [token, setToken] = React.useState<string | null>(localStorage.getItem("token"));

  return (
    <div className="p-4">
      <AuthPanel token={token} setToken={setToken} />

      {!token ? (
        <div className="flex gap-8">
          <Login />
          <Register />
        </div>
      ) : (
        <h2 className="mt-8">You are logged in!</h2>
      )}
    </div>
  );
};

export default App;