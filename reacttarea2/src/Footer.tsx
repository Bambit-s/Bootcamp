// import React from "react";
import "./footer.css";

interface HeadData {
  head: string;
  data: string[];
  way: string[];
}

const datas: HeadData[] = [
  { head: "Products", data: ["ICM", "DMS", "CRM"], way: ["/icm", "/dms", "/crm"] },
  { head: "Resourses", data: ["Case Studies", "FAQ's", "Newsletter", "Release Notes", "Developer's Guide"], way: ["/case-studies", "/faqs", "/newsletter", "/release-notes", "/developers-guide"] },
  { head: "Company", data: ["About", "Our Experts", "Teams", "Demo", "Privacy Policy"], way: ["/about", "/experts", "/teams", "/demo", "/privacy"] },
  { head: "Contact Us", data: ["facebook", "linkedIn", "twitter"], way: ["https://facebook.com", "https://linkedin.com", "https://twitter.com"] },
];

function Footer() {
  return (
    <footer>
      {datas.map((section, index) => (
        <div key={index}>
          <h3>{section.head}</h3>
          <ul>
            {section.data.map((item, i) => (
              <li key={i}>
                <a href={section.way[i]}>{item}</a>
              </li>
            ))}
          </ul>
        </div>
      ))}
    </footer>
  );
}

export default Footer;