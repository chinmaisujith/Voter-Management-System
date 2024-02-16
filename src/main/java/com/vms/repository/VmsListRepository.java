package com.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.entity.VmsList;

@Repository
public interface VmsListRepository extends JpaRepository<VmsList, Integer> {

}
