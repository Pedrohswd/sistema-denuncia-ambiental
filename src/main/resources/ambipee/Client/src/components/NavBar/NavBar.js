
import './NavBar.css';
import { useNavigate } from 'react-router-dom';
import { FaNewspaper, FaSignOutAlt, FaCalendarAlt, FaUserPlus } from 'react-icons/fa';
import { NavLink } from "react-router-dom";
import { TbBrandGoogleAnalytics, TbReportMoney } from 'react-icons/tb';

function NavBar() {
    const navigate = useNavigate();
    const department = localStorage.getItem('department');
    const logOut = () => {
        localStorage.clear();
        navigate('/login');
    };

    return (
        <div className='header'>
            <nav>
                <div className='links nav-top'>
                    <NavLink to='/denuncias' className='nav-link'>
                        <TbBrandGoogleAnalytics color='white' />
                        <span className='span'>Denúncias</span>
                    </NavLink>
                    <NavLink to="/calendar" className="nav-link">
                        <FaCalendarAlt color='white' />
                        <span className='span'>Cadastrar usuário </span>
                    </NavLink>
                    {/* Condição para esconder a opção do menu lateral */}
                    {department === 'estrategiaeprodutos' || department === 'diretoria' || department === 'financeiro' ? <NavLink to="/financeiro" className="nav-link">
                        <TbReportMoney color='white' />
                        <span className='span'>Financeiro</span>
                    </NavLink> : <p></p>}
                    <NavLink to="/login" className='logoutButton' onClick={logOut}>
                        <FaSignOutAlt color='white' />
                        <span className='span'>Sair</span>
                    </NavLink>
                </div>
            </nav >
        </div>
    )
}

export default NavBar;