import './RegisterUser.css';
import { useState } from 'react';
import Axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { AiOutlineEyeInvisible } from 'react-icons/ai';
import NavBar from '../../components/NavBar/NavBar';

function RegisterUser() {
 
    const [passwordShown, setPasswordShown] = useState(false);
    const [user, setUser] = useState({
        name: "",
        cpf: "",
        password: "",
        permission: "",
        phone: "",
    });

    const navigate = useNavigate();
    const preventSubmit = (e) => {
        e.preventDefault();
    };
    const handleInput = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value })
    };
    const togglePasswordVisiblity = () => {
        setPasswordShown(passwordShown ? false : true);
    };


    const handleSubmit = async () => {
        // Envia uma requisição para a url com os dados do user
        await Axios.post("http://localhost:8080/api/users/register", {
            cpf: user.cpf,
            password: user.password,
            name: user.name,
            phone: user.phone,
            permission: user.permission

        }).then((response) => {
            alert('Novo usuário cadastrado.');
            navigate('/login');
        })
    };


    return (
        <div>
            <NavBar />
            <div id="addFormContainer">
                {/* Formulário para cadastrar usuário */}
                <h1>CADASTRAR NOVO USUÁRIO</h1>
                <form method="post" onSubmit={preventSubmit} id="addBox" >

                    <input type="text" name="cpf" placeholder="CPF" value={user.cpf} onChange={handleInput} required />
                    <input type="text" name="name" placeholder="Nome" value={user.name} onChange={handleInput} required />
                    <input type="text" name="phone" placeholder="Telefone" value={user.phone} onChange={handleInput} required />
                    <select>
                        <option>DENUNCIANTE</option>
                        <option>ANALISTA</option>
                    </select>
                    <input type={passwordShown ? 'text' : 'password'} name="password" placeholder="Senha" value={user.password} onChange={handleInput} required />
                    <div className='show_pwd_add' onClick={togglePasswordVisiblity}>
                        <AiOutlineEyeInvisible size={25} />
                    </div>
                    <br /><br />
                    <button className='btn_add' onClick={handleSubmit}>Cadastrar</button>
                </form>
            </div >
        </div >

    )
}

export default RegisterUser