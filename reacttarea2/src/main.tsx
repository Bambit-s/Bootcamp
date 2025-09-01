import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'

// import App from './App.tsx'
import Header from './Header.tsx'
import Footer from './Footer.tsx'
import Banner from './Banner.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    {/* <App /> */}
    <Header />
    <Banner />
    <Footer />
  </StrictMode>,
)
