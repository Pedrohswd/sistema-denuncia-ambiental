import './Login.css';
import { useState, React } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../../api/axiosConfig';



function Login() {

    var permission, userName, cpf, phone = null;
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
    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await api.post("/api/login/log", {
                cpf: user.cpf,
                password: user.password
            });

            // Verifica se a autenticação foi bem-sucedida
            if (response.data) {
                // Extraia os dados do usuário da resposta
                const { permission, name, cpf, phone } = response.data;
                localStorage.setItem('cpf', cpf);
                localStorage.setItem('phone', phone);
                localStorage.setItem('name', name);
                localStorage.setItem('permission', permission);
                // Faça o que for necessário com os dados (por exemplo, armazenar em um estado global)
                
                // Redireciona para a página após o login bem-sucedido
                navigate('/');
            } else {
                // Exibe uma mensagem de erro ao usuário (pode ser ajustado conforme necessário)
                console.error("Autenticação falhou");
            }
        } catch (error) {
            // Lógica para lidar com erros de requisição (por exemplo, conexão perdida, timeout, etc.)
            console.error("Erro na requisição:", error);
        }
    };


    return (
        <div>
            <div className="loginMain">

                <div className="loginFormContainer">

                    <h1>AMBIEEP</h1>
                    <form method="post" className='textbox'>
                        <p>CPF:</p>
                        <input type="text" name="cpf" required onChange={handleInput} value={user.cpf} />
                        <p>Senha:</p>
                        <input name="password" required onChange={handleInput} value={user.password} />
                        <br /><br />
                        <button className='btn_entrar'onClick={handleSubmit}>Entrar</button>
                        
                    </form>

                </div>

                <div className='loginFooter'>
                    <button className='btn-c' onClick={() => navigate('/register/user')}>Criar conta</button>
                    <button className='btn-d' onClick={() => navigate('/register/denuncias')}>Criar denuncia anonimamente</button>
                </div>
            </div>
        </div>
    );
}
export default Login;