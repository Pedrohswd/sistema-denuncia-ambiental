import React, { useEffect, useState } from 'react'
import api from '../../api/axiosConfig';
import NavBar from '../../components/NavBar/NavBar';
import './RegisterDenuncia.css';
import { useFetcher } from 'react-router-dom';

function RegisterDenuncia() {

    const [denuncia, setDenuncia] = useState({
        user:'',
        description: '',
        category:'',
        dateFact:'',
        author: '',
        address:'',
        situation:'CRIADA'
    })
    const options = [
        { value: '', text: '--Escolha uma Opção--' },
        { value: 'FAUNA', text: 'Destruir ou danificar florestas de preservação permanente, independentemente do estágio de formação.' },
        { value: 'FLORA', text: 'Flora' },
        { value: 'POLUICAO', text: 'Poluição' },
        { value: 'ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL', text: 'Ordenamento Urbano e Patrimônio Cultural' },
        { value: 'ADMINISTRACAO_AMBIENTAL', text: 'Administração' },
    ];
    const [selected, setSelected] = useState([options[0].value]);
    const handleChange = event => {
        console.log(event.target.value);
        setSelected(event.target.value);
    };

    return (
        <div>
            <NavBar />
            <div className='rd-pg'>
                <form className='reg-denun'>
                    <h1>Cadastro de Denúncia</h1>

                    <label>Categoria*</label>
                    <select className='s-ctg' required name='category' id='category' onChange={handleChange}>
                        <option value='FAUNA' >FAUNA</option>
                        <option value='FLORA'>FLORA</option>
                        <option value='POLUICAO'>POLUÍÇÃO</option>
                        <option value='ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL'>ODENAMENTO URBANO E PATRIMÔNIO CULTURAL</option>
                        <option value='ADMINISTRACAO_AMBIENTAL'>ADMINISTRAÇÃO AMBIENTAL</option>
                    </select>
                    <label>Subcategoria*</label>
                    <select value={selected} onChange={handleChange}>
                        {options.map(option => (
                            <option key={option.value} value={option.value}>
                                {option.text}
                            </option>
                        ))}
                    </select>
                    <select className='flora-subctg' required name='subcategory'>
                        <option value='FAUNA' >
                            Destruir ou danificar florestas de preservação permanente, independentemente do
                            estágio de formação.
                        </option>
                        <option value='FLORA'>Pesca ilegal, predatória ou por meio de explosivos, ou susbstâncias que em contato com a água produzem efeito semelhante. Assim como transportar ou comercializar espécies provenientes de tais atos.</option>
                        <option value='POLUICAO'>Caça ilegal  ou predatória de animais em extinção ou fora de época, bem como entrar em locais de conservação portando instrumentos próprios para a atividade.</option>
                        <option value='ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL'>Ferir, praticar maus tratos, abuso ou mutilação de qualquer animal silvestre.</option>
                        <option value='ADMINISTRACAO_AMBIENTAL'>Experiências que possam causar dor e sofrimento aos animais.</option>
                        <option value='ADMINISTRACAO_AMBIENTAL'>Emissão de efluentes, substâncias tóxicas ou outro meio proibido que possa provocar a morte ou extinção de espécies aquáticas.</option>
                    </select>
                    <label>Endereço*</label>
                    <input type='text' required name='endereco'></input>
                    <label>Estado*</label>
                    <select className='s-et' required name='estado' id='state' onChange={handleChange}>
                        <option value='AC'>AC</option>
                        <option value='AL'>AL</option>
                        <option value='AP'>AP</option>
                        <option value='AM'>AM</option>
                        <option value='BA'>BA</option>
                        <option value='CE'>CE</option>
                        <option value='DF'>DF</option>
                        <option value='ES'>ES</option>
                        <option value='GO'>GO</option>
                        <option value='MA'>MA</option>
                        <option value='MT'>MT</option>
                        <option value='MS'>MS</option>
                        <option value='MG'>MG</option>
                        <option value='PA'>PA</option>
                        <option value='PB'>PB</option>
                        <option value='PR'>PR</option>
                        <option value='PE'>PE</option>
                        <option value='PI'>PI</option>
                        <option value='RJ'>RJ</option>
                        <option value='RN'>RN</option>
                        <option value='RO'>RO</option>
                        <option value='RR'>RR</option>
                        <option value='SC'>SC</option>
                        <option value='SP'>SP</option>
                        <option value='SE'>SE</option>
                        <option value='TO'>TO</option>
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
    )
}

export default RegisterDenuncia