import React from 'react'
import NavBar from '../../components/NavBar/NavBar';
import { useEffect, useState } from 'react';
import api from '../../api/axiosConfig';

function Home() {
    const [user, setUser] = useState({
        name: "",
        cpf: "",
        password: "",
        permission: "",
        phone: "",
    });
    var cpf = localStorage.getItem('cpf');
    const getUser = async () => {
        try {
            const response = await api.get(`/api/user/cpf/${cpf}`);

            setUser(response.data);
            console.log(user);

        } catch (error) {
            console.log(error);
        }

    }
    useEffect(() =>{
        getUser();
    },[])

    return (
        <div>
            <NavBar />
            <div>
                
            </div>
        </div>
    )
}

export default Home