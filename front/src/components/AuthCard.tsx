// src/components/AuthCard.tsx
import React from "react";

interface AuthCardProps {
  title: string;
  children: React.ReactNode;
}

const AuthCard: React.FC<AuthCardProps> = ({ title, children }) => {
  return (
    <div className="">
      <h2 className="">{title}</h2>
      {children}
    </div>
  );
};

export default AuthCard;
