package ar.com.mercadolibre.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mercadolibre.mutant.dao.DnaDao;
import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.searchers.MutantSearcher;

@Service
public class MutantServiceImpl implements MutantService {

	@Autowired
	private MutantSearcher mutantSearcher;
	
	@Autowired
	private DnaDao dnaDao;
	
	public DnaDTO isMutant(DnaDTO dnaDto) {
		DnaDTO result = mutantSearcher.searchMutant(dnaDto);
		dnaDao.save(result);
		return result;
	}

	
	
}
