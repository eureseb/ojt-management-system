import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';
import { CssVarsProvider } from '@mui/joy';
import colors from './themes/colors.jsx';
import { MantineProvider } from '@mantine/core';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <MantineProvider>
      <CssVarsProvider theme={colors}>
        <App />
      </CssVarsProvider>
    </MantineProvider>
  </React.StrictMode>
);
