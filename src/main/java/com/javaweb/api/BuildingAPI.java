package com.javaweb.api;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

//presentation  layer

@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingService Buildingservice;
	
	@GetMapping(value="/api/building/")
	public ArrayList<BuildingDTO> getBuilding(@RequestParam(value="name",required=false) String name,
											@RequestParam(value="districtId", required=false) String districtId,
											@RequestParam(value="typeCode", required=false) ArrayList<String> typecode){
		ArrayList<BuildingDTO> rs  = Buildingservice.findAll(name,districtId);
		System.out.print("");
		return rs;
	}
}

//Biến kiểu interface có thể tham chiếu đến bất kỳ đối tượng nào thuộc lớp cài đặt interface, bất kể lớp đó nằm trong đâu, miễn là nó implement interface đó.
//Khi bạn đánh dấu biến này bằng @Autowired, Spring sẽ tự động "tiêm" đối tượng BuildingServiceImpl vào biến Buildingservice khi chương trình chạy.
//Khi Spring phát hiện annotation @Autowired trên biến Buildingservice, nó tự động tìm kiếm một bean (đối tượng) tương thích với kiểu BuildingService và tiêm nó vào biến này.







