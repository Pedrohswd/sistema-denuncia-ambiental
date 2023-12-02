import './Login.css';
import { useState, React } from 'react';
import { useNavigate } from 'react-router-dom';
import { FaLock } from 'react-icons/fa';
import { AiOutlineEyeInvisible } from 'react-icons/ai';
import api from '../../api/axiosConfig';



function Login() {

    var accessToken, msg, permission, userName, cpf, phone = null;
    const navigate = useNavigate();
    const [passwordShown, setPasswordShown] = useState(false);
    const togglePasswordVisiblity = () => {
        setPasswordShown(passwordShown ? false : true);
    };
    const [user, setUser] = useState({
        cpf: "",
        password: "",
        permission: "", 
        userName: "",
        phone: ""
    });
    const handleInput = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
    };
    const preventSubmit = (e) => {
        e.preventDefault();
    };
    const handleSubmit = async () => {
            await api.post("/api/login/autenticate", {
            cpf: user.cpf,
            password: user.password

        }).then((response) => {
            if (response.data.status === true) {
                accessToken = response.data.cpf;
                permission = response.data.permission;
                userName = response.data.userName;
                cpf = response.data.cpf;
                phone = response.data.phone;

                localStorage.setItem('accessToken', accessToken);
                localStorage.setItem('cpf', cpf);
                localStorage.setItem('permission', permission);
                localStorage.setItem('userName', userName);
                localStorage.setItem('phone', phone);
                navigate('/');
            } else {
                msg = response.data.msg;
                if (msg === 'wrongPassword') alert('Senha incorreta. Verifique seus dados e tente novamente.');
                if (msg === 'wrongCPF') alert('Usuário não encontrado. Verifique seus dados e tente novamente.');
            }
        })
    }; 


    return (
        <div>
            <div className="loginMain">

                <div className="loginFormContainer">

                    <h1>AMBIEEP</h1>
                    <form method="post" className='textbox'>
                        <p>CPF:</p>
                        <input type="text" name="cpf" required onChange={handleInput}/>
                        <p>Senha:</p>
                        <input name="password" required onChange={handleInput}/>
                        <br /><br />
                        <button className='btn_entrar' onSubmit={handleSubmit}>Entrar</button>
                    </form>

                </div>

                <div className='loginFooter'>
                    <button className='btn-c' onClick={() => navigate('/register/user')}>Criar conta</button>
                    <button className='btn-d'onClick={() => navigate('/register/denuncia')}>Criar denuncia anonimamente</button>
                </div>
            </div>
        </div>
    );
}
export default Login;