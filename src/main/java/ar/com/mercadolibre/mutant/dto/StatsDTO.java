package ar.com.mercadolibre.mutant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StatsDTO {

		
	@JsonProperty("count_mutant_dna")
	private Integer countMutantDna;
	
	@JsonProperty("count_human_dna")
	private Integer countHumanDna;
	
	@JsonProperty("ratio")
	private Double ratio;
	
}
