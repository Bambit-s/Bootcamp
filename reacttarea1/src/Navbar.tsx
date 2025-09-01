import React, { useState, useRef, useEffect } from "react";
import "./Navbar.css";

interface DropdownItem {
  label: string;
  href: string;
}

const Dropdown: React.FC = () => {
  const [open, setOpen] = useState(false);
  const dropdownRef = useRef<HTMLDivElement>(null);

  const topItems: DropdownItem[] = [
    { label: "Data", href: "/" },
    { label: "About", href: "/" },
    { label: "Contact", href: "/" },
  ];

  const dropdownItems: DropdownItem[] = [
    { label: "Investor or regulator?", href: "/" },
    { label: "First things to know", href: "/" },
    { label: "Critical Inflection Point", href: "/" },
    { label: "Uneven Disrubution", href: "/" },
    { label: "Risks may Filter up", href: "/" },
  ];

  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target as Node)) {
        setOpen(false);
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);

  return (
    <div className="dropdown" ref={dropdownRef}>
      <div className="dropdown-top-items">
        {topItems.map((item, index) => (
          <a key={index} href={item.href} className="dropdown-top-item">
            {item.label}
          </a>
        ))}
      </div>

      <button className="dropdown-button" onClick={() => setOpen(!open)}>
        Home
      </button>

      {open && (
        <div className="dropdown-menu center-dropdown">
          {dropdownItems.map((item, index) => (
            <a
              key={index}
              href={item.href}
              className="dropdown-item"
              onClick={() => setOpen(false)}
            >
              {item.label}
            </a>
          ))}
        </div>
      )}
    </div>
  );
};

export default Dropdown;
