package com.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.entity.Vms;
import com.vms.repository.VmsRepository;

@Service
public class VmsService {
	
	
	@Autowired
	private VmsRepository vRepo;
	
	public void save(Vms v) {
			vRepo.save(v);
		
	}
	
	public List<Vms>  getAllVoter() {
		return vRepo.findAll();		
	}
	
	public Vms getVmsById(int id) {
		return vRepo.findById(id).get();
	}
	public void deleteById(int id) {
		 vRepo.deleteById(id);
	}

}
