package com.javaweb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

//business logic layer
//nhan du lieu tra ra

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingrepository;
	
	@Override
	public ArrayList<BuildingDTO> findAll(String name,String districtId) {
		ArrayList<BuildingEntity> entity = buildingrepository.findAll(name,districtId);
		ArrayList<BuildingDTO> result =  new ArrayList<>();
		for(BuildingEntity item : entity) {
			BuildingDTO dto = new BuildingDTO();
			dto.setName(item.getName());
			dto.setAddress(item.getStreet() +"," +item.getWard());
			dto.setNumberofbasement(item.getNumberofbasement());
			result.add(dto);
		}
		return result;
	}
	
}
