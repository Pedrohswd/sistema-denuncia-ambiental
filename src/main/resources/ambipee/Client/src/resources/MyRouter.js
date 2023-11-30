import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from '../pages/Login/Login';
import Home from '../pages/Home/Home';
import RegisterUser from '../pages/Register/RegisterUser';
import RegisterDenuncia from '../pages/Register/RegisterDenuncia';
import Denuncias from '../pages/Denuncias/Denuncias';

function MyRouter() {
    return (
        <BrowserRouter>
            <Routes>
                {/* Rotas sem proteção */}
                <Route path='/login' element={ <Login /> } />
                <Route path='/' element={ <Home/> } />
                <Route path='/register/user' element={ <RegisterUser/> } />
                <Route path='/denuncias' element={ <Denuncias/> }  />
                <Route path='/register/denuncias' element={ <RegisterDenuncia/> } />
            </Routes>
        </BrowserRouter>
    );
}
export default MyRouter;