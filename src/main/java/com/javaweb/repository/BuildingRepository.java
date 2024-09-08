package com.javaweb.repository;

import java.util.ArrayList;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	ArrayList<BuildingEntity> findAll(String name,String districtId);
}
