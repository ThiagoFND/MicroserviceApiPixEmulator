package br.com.api.ApiPix.services;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.ApiPix.dto.ChavePixDTO;
import br.com.api.ApiPix.entities.ChavePix;
import br.com.api.ApiPix.exceptions.ResourceNotFoundException;
import br.com.api.ApiPix.mapper.DozerMapper;
import br.com.api.ApiPix.repositories.ChavePixRepository;

@Service
public class ChavePixService {

	private Logger logger = Logger.getLogger(ChavePixService.class.getName());
	
    @Autowired
    private ChavePixRepository chavePixRepository;

    
	public List<ChavePixDTO> findAll() {

		logger.info("Finding all dados!");

		return DozerMapper.parseListObjects(chavePixRepository.findAll(), ChavePixDTO.class);
	}

	
	public ChavePixDTO create(ChavePixDTO chavePix) {

		logger.info("Creating one endereço!");
		var entity = DozerMapper.parseObject(chavePix, ChavePix.class);
		var vo = DozerMapper.parseObject(chavePixRepository.save(entity), ChavePixDTO.class);
		return vo;
	}

	public ChavePixDTO findById(String id) {

		logger.info("Finding one dados!");

		var entity = chavePixRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, ChavePixDTO.class);
	}

	public ChavePixDTO update(ChavePixDTO dados) {

		logger.info("Updating one dados!");

		var entity = chavePixRepository.findById(dados.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setId(dados.getId());

		var vo = DozerMapper.parseObject(chavePixRepository.save(entity), ChavePixDTO.class);
		return vo;
	}

	public void delete(String id) {

		logger.info("Deleting one person!");

		var entity = chavePixRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		chavePixRepository.delete(entity);
	}
}
