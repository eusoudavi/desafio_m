package com.mirante.avaliacao.mapper;

import com.mirante.avaliacao.bases.BaseMapper;
import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.model.Cidade;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class CidadeMapper extends BaseMapper<Cidade, CidadeDTO> {
}
