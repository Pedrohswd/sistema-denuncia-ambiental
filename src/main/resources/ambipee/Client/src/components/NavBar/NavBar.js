
import './NavBar.css';
import { useNavigate } from 'react-router-dom';
import { FaNewspaper, FaSignOutAlt, FaUserPlus } from 'react-icons/fa';
import { NavLink } from "react-router-dom";
import { BsFillMegaphoneFill } from "react-icons/bs";
import { FaHouse } from "react-icons/fa6";
import { TbReportMoney } from 'react-icons/tb';

function NavBar() {
    const navigate = useNavigate();
    const permission = localStorage.getItem('permission');
    const [user, setUser] = useState({
        cpf: "",
        password: "",
        permission: "",
        userName: "",
        phone: ""
    });
    const logOut = () => {
        localStorage.clear();        
        navigate('/login');
    };
    return (
        <div className='header'>
            <nav>
                <div className='links nav-top'>
                    <NavLink to='/' className='nav-link'>
                        <FaHouse color='white' />
                        <span className='span'>Denuncias</span>
                    </NavLink>
                    <NavLink to='/register/denuncias' className='nav-link'>
                        <BsFillMegaphoneFill color='white' />
                        <span className='span'>Registrar Denúncias</span>
                    </NavLink>
                    <NavLink to="/register/user" className="nav-link">
                        <FaUserPlus color='white' />
                        <span className='span'>Cadastrar usuário </span>
                    </NavLink>
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