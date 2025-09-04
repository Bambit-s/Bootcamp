import React from "react";

interface AuthCardProps {
  title: string;
  children: React.ReactNode;
}

const AuthCard: React.FC<AuthCardProps> = ({ title, children }) => (
  <div className="auth-form">
    <h2 className="text-lg font-bold mb-4">{title}</h2>
    {children}
  </div>
);

export default AuthCard;
