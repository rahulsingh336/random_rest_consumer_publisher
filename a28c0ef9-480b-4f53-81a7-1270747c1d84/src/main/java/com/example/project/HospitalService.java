package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;


	public List<Hospital> getAllHospitals() {
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		hospitalRepository.findAll().forEach(hospitalList::add);
		return hospitalList;
	}

	public Hospital getHospital(int id) {
		return hospitalRepository.findOne(id);
	}

	public void addHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public void updateHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public void deleteHospital(Hospital hospital) {
		hospitalRepository.delete(hospital);
	}
}
