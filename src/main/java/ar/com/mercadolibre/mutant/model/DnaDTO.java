package ar.com.mercadolibre.mutant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DnaDTO {

	@JsonProperty("dna")
	private String[] dna;
	
}
