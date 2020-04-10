package ar.com.mercadolibre.mutant.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.helper.MutantHelper;
import ar.com.mercadolibre.mutant.service.MutantServiceImpl;

@Controller
public class MutantEndpoint {

	@Autowired
	private MutantServiceImpl mutantService;
	
	@Autowired
	private MutantHelper mutantHelper;
	
	
	@PostMapping("/mutant/")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<String> isMutant(@RequestBody DnaDTO dnaDto) throws Exception {
		boolean result = mutantService.isMutant(dnaDto).isMutant();
		if(result) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
	}
	
}
