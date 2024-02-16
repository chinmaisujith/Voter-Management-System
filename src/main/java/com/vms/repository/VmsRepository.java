package com.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.entity.Vms;
import com.vms.entity.VmsList;

@Repository
public interface VmsRepository extends JpaRepository<Vms, Integer>{

	void save(VmsList v);

}
