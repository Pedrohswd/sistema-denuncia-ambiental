import './Login.css';
import { useState, React } from 'react';
import Axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { FaLock } from 'react-icons/fa';
import { AiOutlineEyeInvisible } from 'react-icons/ai';

function Login() {

    var accessToken, msg, permission, userName, cpf, phone = null;
    const [user, setUser] = useState({
        cpf: "",
        password: "",
        permission: "",
        userName: "",
        phone: ""
    });
    const [passwordShown, setPasswordShown] = useState(false);
    const navigate = useNavigate();
    const togglePasswordVisiblity = () => {
        setPasswordShown(passwordShown ? false : true);
    };
    const handleInput = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
    };
    const preventSubmit = (e) => {
        e.preventDefault();
    };
/* const handleSubmit = async () => {
        await Axios.post(process.env.REACT_APP_CLIENT_LOGIN, {
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
    }; */

    return (
        <div>
            <div id="loginMain">
                <h1>AMBIEEP</h1>
                <div id="loginFormContainer">
                    <form method="post" onSubmit={preventSubmit} id="textbox" >

                        <div id='icon_container'>
                            <input type="number" name="cpf" placeholder="CPF" value={user.cpf} onChange={handleInput} required />
                        </div>
                        <div id='icon_container'>
                            <FaLock color='rgb(183,158,135)' size={20} />
                            <input type={passwordShown ? 'text' : 'password'} name="password" placeholder="Senha" value={user.password} onChange={handleInput} required />
                            <div onClick={togglePasswordVisiblity}>
                                <AiOutlineEyeInvisible color='white' size={25} />
                            </div>
                        </div>
                        <br /><br />
                        <button className='btn_entrar' onClick={handleSubmit}>Entrar</button>

                    </form>
                </div>
                <div id='loginFooter'>
                    <a onClick={CriarContaAlert}>Como cria uma conta</a>
                    <br></br>
                    <a href={PoliticaPrivacidadeValori} target="_blank" >Política de privacidade</a>
                    <br></br>
                    <a href='/confirmEmail' target="_blank" >Esqueci minha senha</a>
                </div>
            </div>
        </div>
    );
}
export default Login;