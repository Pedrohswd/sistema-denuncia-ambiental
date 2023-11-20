import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from '../pages/Login/Login';

function MyRouter() {
    return (
        <BrowserRouter>
            <Routes>
                {/* Rotas sem proteção */}
                <Route path='/login' element={<Login />} />
            </Routes>
        </BrowserRouter>
    );
}
export default MyRouter;;