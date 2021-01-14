package com.thiagocedran.orderservice.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagocedran.orderservice.domain.exception.NegocioException;
import com.thiagocedran.orderservice.domain.model.Cliente;
import com.thiagocedran.orderservice.domain.model.OrdemServico;
import com.thiagocedran.orderservice.domain.model.StatusOrdemServico;
import com.thiagocedran.orderservice.domain.repository.ClienteRepository;
import com.thiagocedran.orderservice.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente nao encontrado!"));
		
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		
		
		return ordemServicoRepository.save(ordemServico);
	}
}
