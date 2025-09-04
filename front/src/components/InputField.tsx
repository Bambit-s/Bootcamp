import React from "react";

interface InputFieldProps {
  type: string;
  placeholder: string;
  value: string | number;
  onChange: (value: string) => void;
}

const InputField: React.FC<InputFieldProps> = ({ type, placeholder, value, onChange }) => (
  <input
    type={type}
    placeholder={placeholder}
    value={value}
    onChange={(e) => onChange(e.target.value)}
    className="p-2 border rounded w-full"
  />
);

export default InputField;
