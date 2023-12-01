package com.felas.ambieep.services;

import com.felas.ambieep.entites.Category;
import com.felas.ambieep.entites.enums.CategoryType;
import com.felas.ambieep.entites.records.CategoryJSON;
import com.felas.ambieep.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void initCategory() {
        addCategory("Do transporte e comercialização de animais abatidos de forma ilegal.", CategoryType.FAUNA);
        addCategory("Pesca ilegal, predatória ou por meio de explosivos, ou substâncias que em contato com a água produzem efeito semelhante. Assim como, transportar ou comercializar espécies provenientes de tais atos.", CategoryType.FAUNA);
        addCategory("Caça ilegal ou predatória, de animais em extinção ou fora de época, bem como entrar em locais de conservação portando instrumentos próprios para a atividade.", CategoryType.FAUNA);
        addCategory("Ferir, praticar maus-tratos, abuso ou mutilação de qualquer animal silvestre.", CategoryType.FAUNA);
        addCategory("Experiências que possam causar dor e sofrimento aos animais.", CategoryType.FAUNA);
        addCategory("Emissão de efluentes, substâncias tóxicas ou outro meio proibido que possa provocar a morte ou extinção de espécies aquáticas.", CategoryType.FAUNA);

        addCategory("Destruir ou danificar florestas de preservação permanente, independentemente do estágio de formação.", CategoryType.FLORA);
        addCategory("Destruir ou danificar qualquer vegetação do Bioma Mata Atlântica.", CategoryType.FLORA);
        addCategory("Cortar árvores em florestas de preservação permanente, sem a devida permissão.", CategoryType.FLORA);
        addCategory("Fabricar, vender, transportar ou soltar balões que podem provocar incêndios.", CategoryType.FLORA);
        addCategory("Destruir, danificar, lesar ou maltratar, por qualquer meio ou modo, plantas de ordenação de espaços públicos ou em propriedades privadas alheias.", CategoryType.FLORA);

        addCategory("Causar poluição atmosférica ou híbrida.", CategoryType.POLUICAO);
        addCategory("Dificultar ou impedir o uso público das praias.", CategoryType.POLUICAO);
        addCategory("Realizar pesquisa, lavra ou extração de recursos minerais sem autorização legal.", CategoryType.POLUICAO);
        addCategory("Produzir, processar, embalar, importar, exportar, comercializar, fornecer, transportar, armazenar, guardar, ter em depósito ou usar substância tóxica perigosa, ou nociva à saúde humana ou ao meio ambiente, em desacordo com as exigências estabelecidas.", CategoryType.POLUICAO);
        addCategory("Construir, reformar, ampliar, instalar ou fazer funcionar, estabelecimentos, obras ou serviços potencialmente poluidores, sem licença.", CategoryType.POLUICAO);
        addCategory("Disseminar doença ou praga que cause dano à agricultura, pecuária, fauna, flora e aos ecossistemas.", CategoryType.POLUICAO);

        addCategory("Pixação em áreas urbanas.", CategoryType.ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL);
        addCategory("Alterar o aspecto ou estrutura bem como promover a construção em solo de locais protegidos em razão do seu valor paisagístico, ecológico, turístico, artístico, histórico, cultural, religioso, arqueológico, etnográfico ou monumental, sem autorização prévia da autoridade competente.", CategoryType.ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL);
        addCategory("Mineração, Ruído e Vibração Industrial.", CategoryType.ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL);

        addCategory("Práticas como afirmações falsas ou enganosas.", CategoryType.ADMINISTRACAO_AMBIENTAL);
        addCategory("Concessões de licenças, autorizações ou permissões emitidas pelos funcionários, porém em desacordo com as normas ambientais.", CategoryType.ADMINISTRACAO_AMBIENTAL);
    }

    private void addCategory(String description, CategoryType type) {
        Category category = new Category();
        category.setDescription(description);
        category.setCategoryEnum(type);
        categoryRepository.save(category);
    }

    public List<Category> findByType(CategoryJSON categoryJSON){
        return categoryRepository.findByType(categoryJSON.categoryType());
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

}
