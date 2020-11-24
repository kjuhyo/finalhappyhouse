package com.ssafy.vue.dao;

import java.util.List;

import com.ssafy.vue.dto.SidoGugunCodeDto;
import com.ssafy.vue.dto.VillaInfoDto;

public interface VillaDao {

	List<SidoGugunCodeDto> getSido();

	List<SidoGugunCodeDto> getGugunInSido(String sido);

	List<VillaInfoDto> getDongInGugun(String gugun);

	List<VillaInfoDto> getAllVilla();

	List<VillaInfoDto> getVillaInDong(String dong);

	List<VillaInfoDto> getVillaName(String VillaName);

}
