import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import MyRouter from './resources/MyRouter';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <MyRouter />
  </React.StrictMode>
);

export default root;
