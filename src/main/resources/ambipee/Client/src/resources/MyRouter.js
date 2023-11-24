import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from '../pages/Login/Login';
import Home from '../pages/Home/Home';
import RegisterUser from '../pages/Register/RegisterUser';

function MyRouter() {
    return (
        <BrowserRouter>
            <Routes>
                {/* Rotas sem proteção */}
                <Route path='/login' element={ <Login /> } />
                <Route path='/' element={ <Home/> } />
                <Route path='/register/user' element={ <RegisterUser/> } />
            </Routes>
        </BrowserRouter>
    );
}
export default MyRouter;;