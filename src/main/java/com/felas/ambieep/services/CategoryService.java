package com.felas.ambieep.services;

import com.felas.ambieep.entites.Category;
import com.felas.ambieep.entites.enums.CategoryType;
import com.felas.ambieep.entites.records.CategoryJSON;
import com.felas.ambieep.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @PostConstruct
    public void initCategory() {
        addCategory("Do transporte e comercialização de animais abatidos de forma ilegal.", CategoryType.FAUNA);
        addCategory("Pesca ilegal, predatória ou por meio de explosivos, ou substâncias que em contato com a água produzem efeito semelhante.", CategoryType.FAUNA);

        addCategory("Destruir ou danificar florestas de preservação permanente, independentemente do estágio de formação.", CategoryType.FLORA);
        addCategory("Destruir ou danificar qualquer vegetação do Bioma Mata Atlântica.", CategoryType.FLORA);

        addCategory("Causar poluição atmosférica ou híbrida.", CategoryType.POLUICAO);
        addCategory("Dificultar ou impedir o uso público das praias.", CategoryType.POLUICAO);

        addCategory("Pixação em áreas urbanas.", CategoryType.ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL);
        addCategory("Alterar o aspecto ou estrutura bem como promover a construção em solo de locais protegidos em razão do seu valor paisagístico, ecológico, turístico, artístico, histórico, cultural, religioso, arqueológico, etnográfico ou monumental, sem autorização prévia da autoridade competente.", CategoryType.ORDENAMENTO_URBANO_PATRIMONIO_CULTURAL);

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

}
