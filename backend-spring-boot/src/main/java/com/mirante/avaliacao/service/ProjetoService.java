package com.mirante.avaliacao.service;

import java.util.List;

import com.mirante.avaliacao.exceptions.BuscaRepositoryException;
import com.mirante.avaliacao.mapper.CidadeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.repository.CidadeRepository;

//------------------------------------------------------------------
/** Service usado para acessar os repositórios da aplicação */
//------------------------------------------------------------------
@Service
public class ProjetoService {

	private final CidadeRepository repository;

	private final CidadeMapper mapper;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ProjetoService(CidadeRepository repository, CidadeMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public CidadeDTO pesquisarCidade(Long id) {
		var cidade = repository.findById(id)
				.orElseThrow(() -> new BuscaRepositoryException("Não foi possível encontrar a cidade solicitada"));

		return mapper.entityDto(cidade);

	}

	//---------------------------------------------------------
	/** Método que retorna todas as cidades cadastradas */
	//---------------------------------------------------------
	public List<CidadeDTO> pesquisarCidades() {
		var cidadesDtos = repository.findAll();

		return cidadesDtos.stream()
				.map(mapper::entityDto)
				.toList();

	}

	//----------------------------------------------------------
	/** Método chamado para incluir uma nova cidade */
	//----------------------------------------------------------	
	public void incluirCidade(CidadeDTO dto) {

		var entity = mapper.dtoToEntity(dto);

		repository.save(entity);
		
	}

	//----------------------------------------------------------
	/** Método chamado para alterar os dados de uma cidade */
	//----------------------------------------------------------
	public void alterarCidade(CidadeDTO dto) {

		var cidade = repository.findById(dto.getId())
				.map(entity -> {
					var newEntity = mapper.dtoToEntity(dto);

					BeanUtils.copyProperties(newEntity, entity);

					return repository.save(entity);
				})
				.orElseThrow(() -> new BuscaRepositoryException("Não foi possível encontrar a cidade solicitada"));

		logger.info(cidade.toString());

	}

	//----------------------------------------------------------
	/** Método chamado para excluir uma cidade */
	//----------------------------------------------------------	
	public void excluirCidade(Long idCidade) {
		repository.findById(idCidade)
				.ifPresentOrElse(repository::delete,
						() -> {
                            throw new BuscaRepositoryException("Não foi possível encontrar a cidade solicitada");
                        });
	}
}
