import React, { useEffect, useState } from 'react';
import api from '../../api/axiosConfig';
import NavBar from '../../components/NavBar/NavBar';
import './RegisterDenuncia.css';

function RegisterDenuncia() {

    var cpf = localStorage.getItem('cpf');
    var id = localStorage.getItem('id');
    var role = localStorage.getItem('role')

    const [categorias, setCategorias] = useState([]);
    const [categoriaSelecionada, setCategoriaSelecionada] = useState('');
    const [subcategorias, setSubcategorias] = useState([]);

    const [estado, setEstado] = useState('');
    const [municipio, setMunicipio] = useState('');

    const [image, setImage] = useState({
        imgBase64: "",
        nProtocol: ""
    })

    const [categoryDenun, setCategoryDenun] = useState({
        id: 0,
        description: '',
    })
    const [address, setAddress] = useState({
        street: "",
        state: "",
        county: "",
        latitude: 0,
        longitude: 0,
    }
    );
    const [user, setUser] = useState({
        name: "",
        cpf: "",
        password: "",
        permission: "",
        phone: "",
    });
    const [denuncia, setDenuncia] = useState({
        nProtocol: "",
        user: {
            id: id,
            cpf: cpf
        },
        description: '',
        category: {
            id: 0,
            description: ""
        },
        dateFact: '',
        address: {
            street: "",
            state: "",
            county: "",
            latitude: 0,
            longitude: 0
        },
        author: "",
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

    const handleSubmit = async () => {
        console.log(denuncia)
        // Envia uma requisição para a url com os dados do user
        await api.post("/api/denunciation/create", {
            nProtocol: "",
            user: {
                id: id,
                cpf: cpf,
                name: "",
                phone: "",
                role: role
            },
            photos: [],
            category: {
                id: denuncia.category,
                name: "",
                type: ""
            },
            description: denuncia.description,
            dateFact: denuncia.dateFact,
            author: denuncia.author,
            situation: 'CRIADA',
            address: {
                street: denuncia.address.street,
                state: denuncia.address.state,
                county: denuncia.address.county,
                latitude: denuncia.address.latitude,
                longitude: denuncia.address.longitude
            }
        }).then((response) => {
            if (response.data) {
                denuncia.nProtocol = response.data
                image.nProtocol = response.data
                console.log(denuncia.nProtocol)
                imageSubmit();
            }
        }).catch((error) => {
            console.log(error);
        })
    };

    const imageSubmit = async () => {
        // Envia uma requisição para a url com os dados do user
        await api.post("/api/photos/insert", {
            imgBase64: image.imgBase64,
            nProtocol: image.nProtocol

        }).then((response) => {
            return response.data
        }).catch((error) => {
            console.log(error);
        })
    };

    const handleImageChange = (e) => {
        const file = e.target.files[0];

        if (file) {
            const reader = new FileReader();

            reader.onloadend = () => {
                // Obtém o resultado da leitura como um data URL (base64)
                const base64Image = reader.result;
                setImage({ ...image, imgBase64: base64Image });
            };

            // Lê o conteúdo do arquivo como uma URL de dados (base64)
            reader.readAsDataURL(file);
        }
    };

    useEffect(() => {
        atualizarOpcoes();
    }, [categoriaSelecionada]);

    const getUser = async () => {
        try {
            const response = await api.get(`/api/user/cpf/${cpf}`);

            setUser(response.data);
            console.log(user);

        } catch (error) {
            console.log(error);
        }

    }
    useEffect(() => {
        getUser();
    }, [])

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
                    <select
                        id="subcategoria"
                        value={denuncia.category}
                        onChange={(e) => {
                            handleInput(e); // Para atualizar o estado 'category' na sua 'denuncia'
                            const selectedCategoryId = e.target.value;
                            console.log(selectedCategoryId); // Aqui você pode acessar o id selecionado
                        }}
                        name="category"
                    >
                        <option value="">Selecione...</option>
                        {subcategorias.map((subcategoria) => (
                            <option key={subcategoria.id} value={subcategoria.id}>
                                {subcategoria.description}
                            </option>
                        ))}
                    </select>
                    console.log(subcategoria.id)

                    {/* Adicione um botão ou evento para acionar a atualização das subcategorias */}
                    <button type="button" onClick={atualizarOpcoes}>Atualizar Subcategorias</button>


                    <fieldset>
                        <legend>Endereço*</legend>
                        <label>Logradouro</label>
                        <input type='text' name='address' onChange={handleInput} value={denuncia.address.street}></input>
                        <label>Latitude*</label>
                        <input type='text' required name='latitude' onChange={handleInput} value={denuncia.address.latitude}></input>
                        <label>Longitude*</label>
                        <input type='text' required name='latitude' onChange={handleInput} value={denuncia.address.longitude}></input>
                        <label>Estado*</label>
                        <select id='estado' value={denuncia.address.state} onChange={(e) => setEstado(e.target.value)}>
                            <option value='GO'>GO</option>
                        </select>
                        <label>Município*</label>
                        <select required name='municipio' onChange={handleInput} value={denuncia.address.county}>
                            <option value='Abadia de Goiás'>Abadia de Goiás</option>
                            <option value='Abadiânia'>Abadiânia</option>
                            <option value='Acreúna'>Acreúna</option>
                            <option value='Adelândia'>Adelândia</option>
                            <option value='Água Fria de Goiás'>Água Fria de Goiás</option>
                            <option value='Água Limpa'>Água Limpa</option>
                            <option value='Águas Lindas de Goiás'>Águas Lindas de Goiás</option>
                            <option value='Alexânia'>Alexânia</option>
                            <option value='Aloândia'>Aloândia</option>
                            <option value='Alto Horizonte'>Alto Horizonte</option>
                            <option value='Alto Paraíso de Goiás'>Alto Paraíso de Goiás</option>
                            <option value='Alvorada do Norte'>Alvorada do Norte</option>
                            <option value='Amaralina'>Amaralina</option>
                            <option value='Americano do Brasil'>Americano do Brasil</option>
                            <option value='Amorinópolis'>Amorinópolis</option>
                            <option value='Anápolis'>Anápolis</option>
                            <option value='Anhanguera'>Anhanguera</option>
                            <option value='Anicuns'>Anicuns</option>
                            <option value='Aparecida de Goiânia'>Aparecida de Goiânia</option>
                            <option value='Aparecida do Rio Doce'>Aparecida do Rio Doce</option>
                            <option value='Aporé'>Aporé</option>
                            <option value='Araçu'>Araçu</option>
                            <option value='Aragarças'>Aragarças</option>
                            <option value='Aragoiânia'>Aragoiânia</option>
                            <option value='Araguapaz'>Araguapaz</option>
                            <option value='Arenópolis'>Arenópolis</option>
                            <option value='Aruanã'>Aruanã</option>
                            <option value='Aurilândia'>Aurilândia</option>
                            <option value='Avelinópolis'>Avelinópolis</option>
                            <option value='Baliza'>Baliza</option>
                            <option value='Barro Alto'>Barro Alto</option>
                            <option value='Bela Vista de Goiás'>Bela Vista de Goiás</option>
                            <option value='Bom Jardim de Goiás'>Bom Jardim de Goiás</option>
                            <option value='Bom Jesus de Goiás'>Bom Jesus de Goiás</option>
                            <option value='Bonfinópolis'>Bonfinópolis</option>
                            <option value='Bonópolis'>Bonópolis</option>
                            <option value='Brazabrantes'>Brazabrantes</option>
                            <option value='Britânia'>Britânia</option>
                            <option value='Buriti Alegre'>Buriti Alegre</option>
                            <option value='Buriti de Goiás'>Buriti de Goiás</option>
                            <option value='Buritinópolis'>Buritinópolis</option>
                            <option value='Cabeceiras'>Cabeceiras</option>
                            <option value='Cachoeira Alta'>Cachoeira Alta</option>
                            <option value='Cachoeira de Goiás'>Cachoeira de Goiás</option>
                            <option value='Cachoeira Dourada'>Cachoeira Dourada</option>
                            <option value='Caçu'>Caçu</option>
                            <option value='Caiapônia'>Caiapônia</option>
                            <option value='Caldas Novas'>Caldas Novas</option>
                            <option value='Caldazinha'>Caldazinha</option>
                            <option value='Campestre de Goiás'>Campestre de Goiás</option>
                            <option value='Campinaçu'>Campinaçu</option>
                            <option value='Campinorte'>Campinorte</option>
                            <option value='Campo Alegre de Goiás'>Campo Alegre de Goiás</option>
                            <option value='Campo Limpo de Goiás'>Campo Limpo de Goiás</option>
                            <option value='Campos Belos'>Campos Belos</option>
                            <option value='Campos Verdes'>Campos Verdes</option>
                            <option value='Carmo do Rio Verde'>Carmo do Rio Verde</option>
                            <option value='Castelândia'>Castelândia</option>
                            <option value='Catalão'>Catalão</option>
                            <option value='Caturaí'>Caturaí</option>
                            <option value='Cavalcante'>Cavalcante</option>
                            <option value='Ceres'>Ceres</option>
                            <option value='Cezarina'>Cezarina</option>
                            <option value='Chapadão do Céu'>Chapadão do Céu</option>
                            <option value='Cidade Ocidental'>Cidade Ocidental</option>
                            <option value='Cocalzinho de Goiás'>Cocalzinho de Goiás</option>
                            <option value='Colinas do Sul'>Colinas do Sul</option>
                            <option value='Córrego do Ouro'>Córrego do Ouro</option>
                            <option value='Corumbá de Goiás'>Corumbá de Goiás</option>
                            <option value='Corumbaíba'>Corumbaíba</option>
                            <option value='Cristalina'>Cristalina</option>
                            <option value='Cristianópolis'>Cristianópolis</option>
                            <option value='Crixás'>Crixás</option>
                            <option value='Cromínia'>Cromínia</option>
                            <option value='Cumari'>Cumari</option>
                            <option value='Damianópolis'>Damianópolis</option>
                            <option value='Damolândia'>Damolândia</option>
                            <option value='Davinópolis'>Davinópolis</option>
                            <option value='Diorama'>Diorama</option>
                            <option value='Divinópolis de Goiás'>Divinópolis de Goiás</option>
                            <option value='Doverlândia'>Doverlândia</option>
                            <option value='Edealina'>Edealina</option>
                            <option value='Edéia'>Edéia</option>
                            <option value='Estrela do Norte'>Estrela do Norte</option>
                            <option value='Faina'>Faina</option>
                            <option value='Fazenda Nova'>Fazenda Nova</option>
                            <option value='Firminópolis'>Firminópolis</option>
                            <option value='Flores de Goiás'>Flores de Goiás</option>
                            <option value='Formosa'>Formosa</option>
                            <option value='Formoso'>Formoso</option>
                            <option value='Gameleira de Goiás'>Gameleira de Goiás</option>
                            <option value='Goianápolis'>Goianápolis</option>
                            <option value='Goiandira'>Goiandira</option>
                            <option value='Goianésia'>Goianésia</option>
                            <option value='Goiânia'>Goiânia</option>
                            <option value='Goianira'>Goianira</option>
                            <option value='Goiás'>Goiás</option>
                            <option value='Goiatuba'>Goiatuba</option>
                            <option value='Gouvelândia'>Gouvelândia</option>
                            <option value='Guapó'>Guapó</option>
                            <option value='Guaraíta'>Guaraíta</option>
                            <option value='Guarani de Goiás'>Guarani de Goiás</option>
                            <option value='Guarinos'>Guarinos</option>
                            <option value='Heitoraí'>Heitoraí</option>
                            <option value='Hidrolândia'>Hidrolândia</option>
                            <option value='Hidrolina'>Hidrolina</option>
                            <option value='Iaciara'>Iaciara</option>
                            <option value='Inaciolândia'>Inaciolândia</option>
                            <option value='Indiara'>Indiara</option>
                            <option value='Inhumas'>Inhumas</option>
                            <option value='Ipameri'>Ipameri</option>
                            <option value='Ipiranga de Goiás'>Ipiranga de Goiás</option>
                            <option value='Iporá'>Iporá</option>
                            <option value='Israelândia'>Israelândia</option>
                            <option value='Itaberaí'>Itaberaí</option>
                            <option value='Itaguari'>Itaguari</option>
                            <option value='Itaguaru'>Itaguaru</option>
                            <option value='Itajá'>Itajá</option>
                            <option value='Itapaci'>Itapaci</option>
                            <option value='Itapirapuã'>Itapirapuã</option>
                            <option value='Itapuranga'>Itapuranga</option>
                            <option value='Itarumã'>Itarumã</option>
                            <option value='Itauçu'>Itauçu</option>
                            <option value='Itumbiara'>Itumbiara</option>
                            <option value='Ivolândia'>Ivolândia</option>
                            <option value='Jandaia'>Jandaia</option>
                            <option value='Jaraguá'>Jaraguá</option>
                            <option value='Jataí'>Jataí</option>
                            <option value='Jaupaci'>Jaupaci</option>
                            <option value='Jesúpolis'>Jesúpolis</option>
                            <option value='Joviânia'>Joviânia</option>
                            <option value='Jussara'>Jussara</option>
                            <option value='Lagoa Santa'>Lagoa Santa</option>
                            <option value='Leopoldo de Bulhões'>Leopoldo de Bulhões</option>
                            <option value='Luziânia'>Luziânia</option>
                            <option value='Mairipotaba'>Mairipotaba</option>
                            <option value='Mambaí'>Mambaí</option>
                            <option value='Mara Rosa'>Mara Rosa</option>
                            <option value='Marzagão'>Marzagão</option>
                            <option value='Matrinchã'>Matrinchã</option>
                            <option value='Maurilândia'>Maurilândia</option>
                            <option value='Mimoso de Goiás'>Mimoso de Goiás</option>
                            <option value='Minaçu'>Minaçu</option>
                            <option value='Mineiros'>Mineiros</option>
                            <option value='Moiporá'>Moiporá</option>
                            <option value='Monte Alegre de Goiás'>Monte Alegre de Goiás</option>
                            <option value='Montes Claros de Goiás'>Montes Claros de Goiás</option>
                            <option value='Montividiu'>Montividiu</option>
                            <option value='Montividiu do Norte'>Montividiu do Norte</option>
                            <option value='Morrinhos'>Morrinhos</option>
                            <option value='Morro Agudo de Goiás'>Morro Agudo de Goiás</option>
                            <option value='Mossâmedes'>Mossâmedes</option>
                            <option value='Mozarlândia'>Mozarlândia</option>
                            <option value='Mundo Novo'>Mundo Novo</option>
                            <option value='Mutunópolis'>Mutunópolis</option>
                            <option value='Nazário'>Nazário</option>
                            <option value='Nerópolis'>Nerópolis</option>
                            <option value='Niquelândia'>Niquelândia</option>
                            <option value='Nova América'>Nova América</option>
                            <option value='Nova Aurora'>Nova Aurora</option>
                            <option value='Nova Crixás'>Nova Crixás</option>
                            <option value='Nova Glória'>Nova Glória</option>
                            <option value='Nova Iguaçu de Goiás'>Nova Iguaçu de Goiás</option>
                            <option value='Nova Roma'>Nova Roma</option>
                            <option value='Nova Veneza'>Nova Veneza</option>
                            <option value='Novo Brasil'>Novo Brasil</option>
                            <option value='Novo Gama'>Novo Gama</option>
                            <option value='Novo Planalto'>Novo Planalto</option>
                            <option value='Orizona'>Orizona</option>
                            <option value='Ouro Verde de Goiás'>Ouro Verde de Goiás</option>
                            <option value='Ouvidor'>Ouvidor</option>
                            <option value='Padre Bernardo'>Padre Bernardo</option>
                            <option value='Palestina de Goiás'>Palestina de Goiás</option>
                            <option value='Palmeiras de Goiás'>Palmeiras de Goiás</option>
                            <option value='Palmelo'>Palmelo</option>
                            <option value='Palminópolis'>Palminópolis</option>
                            <option value='Panamá'>Panamá</option>
                            <option value='Paranaiguara'>Paranaiguara</option>
                            <option value='Paraúna'>Paraúna</option>
                            <option value='Perolândia'>Perolândia</option>
                            <option value='Petrolina de Goiás'>Petrolina de Goiás</option>
                            <option value='Pilar de Goiás'>Pilar de Goiás</option>
                            <option value='Piracanjuba'>Piracanjuba</option>
                            <option value='Piranhas'>Piranhas</option>
                            <option value='Pirenópolis'>Pirenópolis</option>
                            <option value='Pires do Rio'>Pires do Rio</option>
                            <option value='Planaltina'>Planaltina</option>
                            <option value='Pontalina'>Pontalina</option>
                            <option value='Porangatu'>Porangatu</option>
                            <option value='Porteirão'>Porteirão</option>
                            <option value='Portelândia'>Portelândia</option>
                            <option value='Posse'>Posse</option>
                            <option value='Professor Jamil'>Professor Jamil</option>
                            <option value='Quirinópolis'>Quirinópolis</option>
                            <option value='Rialma'>Rialma</option>
                            <option value='Rianápolis'>Rianápolis</option>
                            <option value='Rio Quente'>Rio Quente</option>
                            <option value='Rio Verde'>Rio Verde</option>
                            <option value='Rubiataba'>Rubiataba</option>
                            <option value='Sanclerlândia'>Sanclerlândia</option>
                            <option value='Santa Bárbara de Goiás'>Santa Bárbara de Goiás</option>
                            <option value='Santa Cruz de Goiás'>Santa Cruz de Goiás</option>
                            <option value='Santa Fé de Goiás'>Santa Fé de Goiás</option>
                            <option value='Santa Helena de Goiás'>Santa Helena de Goiás</option>
                            <option value='Santa Isabel'>Santa Isabel</option>
                            <option value='Santa Rita do Araguaia'>Santa Rita do Araguaia</option>
                            <option value='Santa Rita do Novo Destino'>Santa Rita do Novo Destino</option>
                            <option value='Santa Rosa de Goiás'>Santa Rosa de Goiás</option>
                            <option value='Santa Tereza de Goiás'>Santa Tereza de Goiás</option>
                            <option value='Santa Terezinha de Goiás'>Santa Terezinha de Goiás</option>
                            <option value='Santo Antônio da Barra'>Santo Antônio da Barra</option>
                            <option value='Santo Antônio de Goiás'>Santo Antônio de Goiás</option>
                            <option value='Santo Antônio do Descoberto'>Santo Antônio do Descoberto</option>
                            <option value='São Domingos'>São Domingos</option>
                            <option value='São Francisco de Goiás'>São Francisco de Goiás</option>
                            <option value='São João da Paraúna'>São João da Paraúna</option>
                            <option value='São João d Aliança'>São João d'Aliança</option>
                            <option value='São Luís de Montes Belos'>São Luís de Montes Belos</option>
                            <option value='São Luiz do Norte'>São Luiz do Norte</option>
                            <option value='São Miguel do Araguaia'>São Miguel do Araguaia</option>
                            <option value='São Miguel do Passa Quatro'>São Miguel do Passa Quatro</option>
                            <option value='São Patrício'>São Patrício</option>
                            <option value='São Simão'>São Simão</option>
                            <option value='Senador Canedo'>Senador Canedo</option>
                            <option value='Serranópolis'>Serranópolis</option>
                            <option value='Silvânia'>Silvânia</option>
                            <option value='Simolândia'>Simolândia</option>
                            <option value='Sítio d Abadia'>Sítio d'Abadia</option>
                            <option value='Taquaral de Goiás'>Taquaral de Goiás</option>
                            <option value='Teresina de Goiás'>Teresina de Goiás</option>
                            <option value='Terezópolis de Goiás'>Terezópolis de Goiás</option>
                            <option value='Três Ranchos'>Três Ranchos</option>
                            <option value='Trindade'>Trindade</option>
                            <option value='Trombas'>Trombas</option>
                            <option value='Turvânia'>Turvânia</option>
                            <option value='Turvelândia'>Turvelândia</option>
                            <option value='Uirapuru'>Uirapuru</option>
                            <option value='Uruaçu'>Uruaçu</option>
                            <option value='Uruana'>Uruana</option>
                            <option value='Urutaí'>Urutaí</option>
                            <option value='Valparaíso de Goiás'>Valparaíso de Goiás</option>
                            <option value='Varjão'>Varjão</option>
                            <option value='Vianópolis'>Vianópolis</option>
                            <option value='Vicentinópolis'>Vicentinópolis</option>
                            <option value='Vila Boa'>Vila Boa</option>
                            <option value='Vila Propício'>Vila Propício</option>
                        </select>
                    </fieldset>
                    <label>Descrição*</label>
                    <textarea placeholder='Descreva o que está sendo denunciado' name='description' onChange={handleInput} value={denuncia.description}></textarea>
                    <label>Data do ocorrido</label>
                    <input type='date' required name='dateFact' onChange={handleInput} value={denuncia.dateFact}></input>
                    <label>Imagem</label>
                    <input type='file' required name='imgBase64' onChange={handleImageChange}></input>
                    <label>Possivel autor</label>
                    <input type='text'required placeholder='Caso não souber informe "Não identicado"' name='author' onChange={handleInput} value={denuncia.author}></input>
                    <button type='submit' onClick={handleSubmit}>Enviar Denúncia</button>
                </form>
            </div >
        </div >
    );
}

export default RegisterDenuncia;