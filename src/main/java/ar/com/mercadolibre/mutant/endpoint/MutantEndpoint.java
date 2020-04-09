package ar.com.mercadolibre.mutant.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.com.mercadolibre.mutant.model.DnaDTO;
import ar.com.mercadolibre.mutant.service.MutantService;

@Controller
public class MutantEndpoint {

	@Autowired
	private MutantService mutantService;
	
	
	@PostMapping("/mutant/")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<String> isMutant(@RequestBody DnaDTO dnaDto) throws Exception { // CAMBIAR A JSON
		boolean result = mutantService.isMutant(dnaDto);
		if(!result) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		
		
	}
	
	
}
