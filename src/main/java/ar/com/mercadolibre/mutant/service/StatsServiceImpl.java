package ar.com.mercadolibre.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mercadolibre.mutant.dao.DnaDao;
import ar.com.mercadolibre.mutant.dto.StatsDTO;

@Service
public class StatsServiceImpl implements StatsService {

	
	@Autowired
	private DnaDao dnaDao;
//	
	public StatsDTO getStats() {
//		List<Dna> dnas = dnaDao.getAll();
//		StatsDTO result = new StatsDTO();
//		Integer humans = 0;
//		Integer mutants = 0;
//		
//		for(Dna dna : dnas) {
//			if(dna.isMutant()) {
//				mutants++;
//			} else {
//				humans++;
//			}
//		}
//		result.setCountHumanDna(humans);
//		result.setCountMutantDna(mutants);
//		
//		
		return null;
	}



	
	
}
