package com.mirante.avaliacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mirante.avaliacao.dto.CidadeDTO;
import com.mirante.avaliacao.service.ProjetoService;

//--------------------------------------------------
/** Endpoint para consultar e manter cidades */
//--------------------------------------------------
@RestController
@CrossOrigin
@RequestMapping("/cidades")
public class CidadeController {

	private final ProjetoService service ;

	public CidadeController(ProjetoService service) {
		this.service = service;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CidadeDTO> buscarPeloId(@PathVariable Long id) {
		var cidadeDTO = service.pesquisarCidade(id);
		return new ResponseEntity<>(cidadeDTO, HttpStatus.OK);
	}
	
	//----------------------------------------------------------
	/** Endpoint que retorna todas as cidades cadastradas */
	//----------------------------------------------------------
	@GetMapping()
	public List<CidadeDTO> pesquisarCidades() {
		// TODO: Responde GET em http://localhost:8080/mirante/cidades

		return service.pesquisarCidades();
	}
	
	//----------------------------------------------------------
	/** Endpoint para incluir nova cidade */
	//----------------------------------------------------------
	@PostMapping()
	public void incluirCidade(@RequestBody(required = true) CidadeDTO cidadeDto) {
		//	TODO: Responde POST em http://localhost:8080/mirante/cidades
		//	Envia JSON no body:
		//	{
		//	 	"nome": "Florianópolis",
		//	  	"uf": "SC",
		//	   	"capital": true
		//	}

		service.incluirCidade(cidadeDto);
	}	
	
	//----------------------------------------------------------
	/** Endpoint para alterar cidade */
	//----------------------------------------------------------
	@PutMapping()
	public void alterarCidade(@RequestBody(required = true) CidadeDTO cidadeDto) {
		// TODO: Responde PUT em http://localhost:8080/mirante/cidades
		//   Envia JSON no body:
		//   {
		//     "id": 11,
		//     "nome": "Blumenau",
		//     "uf": "SC",
		//     "capital": false
		//   }		 		

		service.alterarCidade(cidadeDto);

	}
	
	//----------------------------------------------------------
	/** Endpoint para excluir uma cidade */
	//----------------------------------------------------------
	@DeleteMapping(value = "/{idCidade}")
	public void excluirCidade(@PathVariable(required = true) Long idCidade) {
		// Responde DELETE em http://localhost:8080/mirante/cidades/{idCidade}

		service.excluirCidade(idCidade);
	}	
}
