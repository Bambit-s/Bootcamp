// import React from "react";
import "./Banner.css";

function Banner() {
  return (
    <div className="banner">
      <div className="banner-content">
        <h1>
          Work less,<br />
          achieve more.
        </h1>
        <div className="banner-right">
          <p>
            Our technology is the key to unlocking higher sales and better service. 
            We stand behind it with a satisfaction guarantee - try it risk-free and 
            see the results for yourself!
          </p>
          <button className="banner-button">GET STARTED</button>
        </div>
      </div>
    </div>
  );
}

export default Banner;