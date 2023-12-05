import React, { useEffect, useState } from 'react';
import api from '../../api/axiosConfig';
import NavBar from '../../components/NavBar/NavBar';
import './RegisterDenuncia.css';

function RegisterDenuncia() {
    const [categorias, setCategorias] = useState([]);
    const [categoriaSelecionada, setCategoriaSelecionada] = useState('');
    const [subcategorias, setSubcategorias] = useState([]);
    const [denuncia, setDenuncia] = useState({
        user: '',
        description: '',
        category: '',
        dateFact: '',
        author: '',
        address: '',
        situation: 'CRIADA'
    });

    const handleInput = (e) => {
        setDenuncia({ ...denuncia, [e.target.name]: e.target.value });
    };

    const atualizarOpcoes = async () => {
        try {
            const response = await api.get(`/api/category/list/${categoriaSelecionada}`);
            const data = response.data;
            setSubcategorias(data);
        } catch (error) {
            console.error('Erro ao buscar subcategorias:', error);
        }
    };

    useEffect(() => {
        atualizarOpcoes();
    }, [categoriaSelecionada]);

    return (
        <div>
            <NavBar />
            <div className='rd-pg'>
                <form className='reg-denun'>
                    <h1>Cadastro de Denúncia</h1>

                    <label htmlFor="categoria">Escolha a categoria:</label>
                    <select
                        id="categoria"
                        value={categoriaSelecionada}
                        onChange={(e) => setCategoriaSelecionada(e.target.value)}
                    >
                        <option value="">Selecione...</option>
                        <option value='FAUNA'>FAUNA</option>
                        <option value='FLORA'>FLORA</option>
                        <option value='POLUICAO'>POLUÍÇÃO</option>
                        <option value='ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL'>ODENAMENTO URBANO E PATRIMÔNIO CULTURAL</option>
                        <option value='ADMINISTRACAO_AMBIENTAL'>ADMINISTRAÇÃO AMBIENTAL</option>
                    </select>

                    <label htmlFor="subcategoria">Escolha a subcategoria:</label>
                    <select id="subcategoria" value={denuncia.category} onChange={handleInput} name="category">
                        <option value="">Selecione...</option>
                        {subcategorias.map((subcategoria) => (
                            <option key={subcategoria.id} value={subcategoria.description}>
                                {subcategoria.description}
                            </option>
                        ))}
                    </select>

                    {/* Adicione um botão ou evento para acionar a atualização das subcategorias */}
                    <button type="button" onClick={atualizarOpcoes}>Atualizar Subcategorias</button>

                    <label>Endereço*</label>
                    <input type='text' required name='address' onChange={handleInput}></input>
                    <label>Estado*</label>
                    <select className='s-et' required name='estado' id='state'>
                        {/* ... Opções de estado ... */}
                    </select>
                    <label>Município*</label>
                    <select required name='municipio'>
                        <option>Sim</option>
                    </select>
                    <label>Descrição*</label>
                    <textarea required placeholder='Descreva o que está sendo denunciado'></textarea>
                    <label>Data do ocorrido</label>
                    <input type='date'></input>
                    <label>Imagem</label>
                    <input type='file' name='image'></input>
                    <label>Denunciante</label>
                    <input type='text'></input>
                    <button type='submit'>Enviar Denúncia</button>
                </form>
            </div>
        </div>
    );
}

export default RegisterDenuncia;