package ar.com.mercadolibre.mutant.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.com.mercadolibre.mutant.dto.DnaDTO;
import ar.com.mercadolibre.mutant.dto.StatsDTO;
import ar.com.mercadolibre.mutant.service.MutantServiceImpl;
import ar.com.mercadolibre.mutant.service.StatsServiceImpl;

@Controller
public class MutantEndpoint {

	@Autowired
	private MutantServiceImpl mutantService;
	
	@Autowired
	private StatsServiceImpl statsService;
	
	
	@PostMapping("/mutant/")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<String> isMutant(@RequestBody DnaDTO dnaDto) throws Exception {
		boolean result = mutantService.isMutant(dnaDto).isMutant();
		if(!result) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
	}
	
	@GetMapping("/stats")
	public StatsDTO getStats() {
		return statsService.getStats();
	}
	
}
