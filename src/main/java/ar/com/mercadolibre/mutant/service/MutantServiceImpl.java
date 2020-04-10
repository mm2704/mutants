package ar.com.mercadolibre.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.searchers.MutantSearcherImpl;

@Service
public class MutantServiceImpl implements MutantService {

	@Autowired
	private MutantSearcherImpl mutantSearcher;
	
	
	public boolean isMutant(DnaDTO dnaDto) {
		return mutantSearcher.searchMutant(dnaDto);
	}

	
	
}
