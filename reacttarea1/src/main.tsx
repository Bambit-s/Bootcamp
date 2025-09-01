import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import './index.css'
// import App from './App.tsx'
import Navbar from './Navbar.tsx'
import Navbarcities from './NavbarCities.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    {/* <App /> */}
    <Navbar />
    <Navbarcities />
  </StrictMode>,
)
