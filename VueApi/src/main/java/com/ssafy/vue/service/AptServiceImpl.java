package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dao.AptDao;
import com.ssafy.vue.dto.AptInfoDto;
import com.ssafy.vue.dto.SidoGugunCodeDto;


@Service
public class AptServiceImpl implements AptService {
	
	private static AptService AptService;
	
	private AptServiceImpl() {}
	
	@Autowired
	AptDao AptDaoImpl;
	
	public static AptService getAptService() {
		if(AptService == null)
			AptService = new AptServiceImpl();
		return AptService;
	}

	@Override
	public List<SidoGugunCodeDto> getSido()  {
		return AptDaoImpl.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido)  {
		return AptDaoImpl.getGugunInSido(sido);
	}

	@Override
	public List<AptInfoDto> getDongInGugun(String gugun)  {
		return AptDaoImpl.getDongInGugun(gugun);
	}

	@Override
	public List<AptInfoDto> getAptInDong(String dong)  {
		return AptDaoImpl.getAptInDong(dong);
	}
	@Override
	public List<AptInfoDto> getAllApt()  {
		return AptDaoImpl.getAllApt();
	}
	@Override
	public List<AptInfoDto> getAptName(String AptName)  {
		return AptDaoImpl.getAptName(AptName);
	}

}
