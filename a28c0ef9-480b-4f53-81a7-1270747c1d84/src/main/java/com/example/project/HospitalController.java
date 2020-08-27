package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test/hospitals/")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;


	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody
	Hospital getHospital(@PathVariable("id") int id) throws Exception {
		return hospitalService.getHospital(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Hospital> getAllHospitals() throws Exception {
		return hospitalService.getAllHospitals();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addHospital(@RequestBody Hospital hospital) {
		hospitalService.addHospital(hospital);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) {
		hospitalService.updateHospital(hospital);
		return new ResponseEntity<String>(HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) {
		hospitalService.deleteHospital(hospital);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

}
