import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import './index.css'
//import App from './App.jsx'

import AppRoutes from './routes/AppRoutes'

// Importar o bootstrap

import 'bootstrap/dist/css/bootstrap.min.css'



createRoot(document.getElementById('root')).render(
  <StrictMode>
      <AppRoutes/>
  </StrictMode>,
)
