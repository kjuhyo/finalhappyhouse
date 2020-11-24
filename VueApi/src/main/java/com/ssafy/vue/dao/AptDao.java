package com.ssafy.vue.dao;

import java.util.List;

import com.ssafy.vue.dto.AptInfoDto;
import com.ssafy.vue.dto.SidoGugunCodeDto;


public interface AptDao {

	List<SidoGugunCodeDto> getSido();
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	List<AptInfoDto> getDongInGugun(String gugun);
	List<AptInfoDto> getAllApt();
	List<AptInfoDto> getAptInDong(String dong);
	List<AptInfoDto> getAptName(String AptName);
	
}
