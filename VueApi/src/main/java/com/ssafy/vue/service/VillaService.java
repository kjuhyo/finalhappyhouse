package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.SidoGugunCodeDto;
import com.ssafy.vue.dto.VillaInfoDto;

public interface VillaService {
	
	List<SidoGugunCodeDto> getSido() ;
	List<SidoGugunCodeDto> getGugunInSido(String sido) ;
	List<VillaInfoDto> getDongInGugun(String gugun) ;
	List<VillaInfoDto> getVillaInDong(String dong) ;
	List<VillaInfoDto> getAllVilla() ;
	List<VillaInfoDto> getVillaName(String AptName) ;
	
}
