package ar.com.mercadolibre.mutant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StatsDto {


	@JsonProperty("count_mutant_dna")
	private Integer countMutantDna;
	
	@JsonProperty("count_human_dna")
	private Integer CountHumanDna;
	
	@JsonProperty("ratio")
	private Integer ratio;
	
}
