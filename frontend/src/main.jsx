import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';
import { CssVarsProvider } from '@mui/joy';
import colors from './themes/colors.jsx';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <CssVarsProvider theme={colors}>
      <App />
    </CssVarsProvider>
  </React.StrictMode>
);
