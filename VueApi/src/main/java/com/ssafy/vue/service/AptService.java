package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.AptInfoDto;
import com.ssafy.vue.dto.SidoGugunCodeDto;

public interface AptService {
	
	List<SidoGugunCodeDto> getSido() ;
	List<SidoGugunCodeDto> getGugunInSido(String sido) ;
	List<AptInfoDto> getDongInGugun(String gugun) ;
	List<AptInfoDto> getAptInDong(String dong) ;
	List<AptInfoDto> getAllApt() ;
	List<AptInfoDto> getAptName(String AptName) ;
	
}
