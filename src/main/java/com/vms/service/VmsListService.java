package com.vms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.entity.Vms;
import com.vms.entity.VmsList;
import com.vms.repository.VmsRepository;

@Service
public class VmsListService {
	
	@Autowired
	private VmsRepository vms;
	
	public void saveVmslist(VmsList v) {
		vms.save(v);
		
	}
	
	public List<Vms> getAllVms() {
		return vms.findAll();
	}
	
	
	public void deleteById(int id) {
		vms.deleteById(id);
	}
}
