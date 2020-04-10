package ar.com.mercadolibre.mutant.dao;

import org.springframework.stereotype.Component;

import ar.com.mercadolibre.mutant.dto.DnaDTO;

public interface DnaDao {

	DnaDTO save(DnaDTO dnaDTO);

}
