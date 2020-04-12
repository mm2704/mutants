package ar.com.mercadolibre.mutant.helper;


import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.dto.StatsDTO;
import ar.com.mercadolibre.mutant.enums.TypesEnum;

@Component
public class MutantHelper {
	

	/**
	 * Devuelve el tipo de adn
	 * @param dna
	 * @return
	 */
	public String getType(DnaDTO dna) {
		if(dna.isMutant()) {
			return TypesEnum.MUTANT.getValue();
		} else {
			return TypesEnum.HUMAN.getValue();
		}
	}
	
	/**
	 * Devuelve un objeto Stats con los seteos de ratio y count correspondientes.
	 * @param mutantsCount
	 * @param humanCounts
	 * @return
	 */
	public StatsDTO getStats(Integer mutantsCount, Integer humanCounts) {
		StatsDTO result = new StatsDTO(); 
		result.setCountMutantDna(mutantsCount);
		result.setCountHumanDna(humanCounts);
		
		if(humanCounts == 0) {
			result.setRatio(new Double(mutantsCount));
		} else {
			Double radio = new Double(mutantsCount)/new Double(humanCounts);
			result.setRatio(Math.round(radio * 10) / 10.0);
		}
		return result;
	}
}
