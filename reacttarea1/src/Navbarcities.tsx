import React, { useState } from "react";
import "./Navbarcities.css";

interface StateData {
  state: string;
  cities: string[];
}

const data: StateData[] = [
  { state: "Alaska", cities: ["Bascom"] },
  { state: "Connecticut", cities: [] },
  { state: "Wisconsin", cities: ["Oretta", "Konterra", "Guthrie"] },
  { state: "Nebraska", cities: ["Jennings", "Harvielt", "Alfarata", "Bluffview", "Escondida"] },
  { state: "Georgia", cities: [] }
];

const StatesDropdown: React.FC = () => {
  const [openState, setOpenState] = useState<string | null>(null);

  const toggleState = (state: string) => {
    setOpenState(openState === state ? null : state);
  };

  return (
    <div className="states-dropdown">
      {data.map((item) => (
        <div key={item.state} className="state-block">
          <button
            className="state-button"
            onClick={() => toggleState(item.state)}
          >
            {item.state}
          </button>

          {openState === item.state && item.cities.length > 0 && (
            <div className="cities-list">
              {item.cities.map((city) => (
                <div key={city} className="city-item">
                  {city}
                </div>
              ))}
            </div>
          )}

          {openState === item.state && item.cities.length === 0 && (
            <div className="cities-list empty">No cities available</div>
          )}
        </div>
      ))}
    </div>
  );
};

export default StatesDropdown;
