package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dao.VillaDao;
import com.ssafy.vue.dto.SidoGugunCodeDto;
import com.ssafy.vue.dto.VillaInfoDto;


@Service
public class VillaServiceImpl implements VillaService {
	
	private static VillaService VillaService;
	
	private VillaServiceImpl() {}
	
	@Autowired
	VillaDao VillaDaoImpl;
	
	public static VillaService getVillaMapService() {
		if(VillaService == null)
			VillaService = new VillaServiceImpl();
		return VillaService;
	}

	@Override
	public List<SidoGugunCodeDto> getSido()  {
		return VillaDaoImpl.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido)  {
		return VillaDaoImpl.getGugunInSido(sido);
	}

	@Override
	public List<VillaInfoDto> getDongInGugun(String gugun)  {
		return VillaDaoImpl.getDongInGugun(gugun);
	}

	@Override
	public List<VillaInfoDto> getVillaInDong(String dong)  {
		return VillaDaoImpl.getVillaInDong(dong);
	}
	@Override
	public List<VillaInfoDto> getAllVilla()  {
		return VillaDaoImpl.getAllVilla();
	}
	@Override
	public List<VillaInfoDto> getVillaName(String AptName)  {
		return VillaDaoImpl.getVillaName(AptName);
	}

}
