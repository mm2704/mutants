package ar.com.mercadolibre.mutant.helper;


import org.springframework.stereotype.Component;

import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.dto.StatsDTO;
import ar.com.mercadolibre.mutant.enums.TypesEnum;

@Component
public class MutantHelper {

	
	public String getType(DnaDTO dna) {
		if(dna.isMutant()) {
			return TypesEnum.MUTANT.getValue();
		} else {
			return TypesEnum.HUMAN.getValue();
		}
	}
	
	public StatsDTO getStats(Integer mutantsCount, Integer humanCounts) {
		StatsDTO result = new StatsDTO(); 
		result.setCountMutantDna(mutantsCount);
		result.setCountHumanDna(humanCounts);
		
		if(humanCounts == 0) {
			result.setRatio(new Double(mutantsCount));
		} else {
			result.setRatio(new Double((mutantsCount)/humanCounts));
		}
		return result;
	}
}
