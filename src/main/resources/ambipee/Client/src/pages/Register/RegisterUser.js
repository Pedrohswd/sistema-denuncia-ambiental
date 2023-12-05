import './RegisterUser.css';
import { useEffect, useState } from 'react';
import Axios from 'axios';
import api from '../../api/axiosConfig';
import { useNavigate } from 'react-router-dom';
import { AiOutlineEyeInvisible } from 'react-icons/ai';
import NavBar from '../../components/NavBar/NavBar';

function RegisterUser() {

    const [passwordShown, setPasswordShown] = useState(false);
    var permissao = localStorage.getItem('permission');


    const [user, setUser] = useState({
        cpf: "",
        name: "",
        password: "",
        phone: "",
        permission: "",
    });
    const getUser = async () => {
        try {
            const response = await api.get("/api/users/1");
            setUser(response.data);
            console.log(response.data);

        } catch (error) {
            console.log(error);
        }

    }
    useEffect(() =>{
        getUser();
    },[])


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
        await api.post("api/users/register", {
            cpf: user.cpf,
            password: user.password,
            name: user.name,
            phone: user.phone,
            permission: user.permission

        }).then((response) =>{
            return response.data
        }).catch((error) =>{
            console.log(error);
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
                    <input type={passwordShown ? 'text' : 'password'} name="password" placeholder="Senha" value={user.password} onChange={handleInput} required />
                    <div className='show_pwd_add' onClick={togglePasswordVisiblity}>
                        <AiOutlineEyeInvisible size={25} />
                    </div>
                    <select className={permissao === 'ANALISTA' ? 'sel-a' : 'sel-d'} value={user.permission} onChange={handleInput}>
                        <option value='DENUNCIANTE'>DENUNCIANTE</option>
                        <option value='ANALISTA'>ANALISTA</option>
                    </select>
                    <br /><br />
                    <button className='btn_add' onClick={handleSubmit}>CADASTRAR</button>
                </form>
            </div >
        </div >

    )
}

export default RegisterUser