package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.SidoGugunCodeDto;
import com.ssafy.vue.dto.VillaInfoDto;
import com.ssafy.vue.service.VillaService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/vue/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/villa")
public class VillaController {

	private static final Logger logger = LoggerFactory.getLogger(VillaController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	VillaService VillaService;

	@ApiOperation(value = "시도", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> getSido() throws Exception {
		logger.debug("getSido - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(VillaService.getSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "구군", response = List.class)
	@GetMapping("/gugun/{sido}")
	public ResponseEntity<List<SidoGugunCodeDto>> getGugunInSido(@PathVariable String sido) {
		logger.debug("getGugunInSido - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(VillaService.getGugunInSido(sido), HttpStatus.OK);
	}
	@ApiOperation(value = "동", response = List.class)
	@GetMapping("/dong/{gugun}")
	public ResponseEntity<List<VillaInfoDto>> getDongInGugun(@PathVariable String gugun) {
		logger.debug("getGugunInSido - 호출");
		return new ResponseEntity<List<VillaInfoDto>>(VillaService.getDongInGugun(gugun), HttpStatus.OK);
	}
	@ApiOperation(value = "동안에 빌라", response = List.class)
	@GetMapping("/dong/{dong}")
	public ResponseEntity<List<VillaInfoDto>> getAptInDong(@PathVariable String dong) {
		logger.debug("getGugunInSido - 호출");
		return new ResponseEntity<List<VillaInfoDto>>(VillaService.getVillaInDong(dong), HttpStatus.OK);
	}
	@ApiOperation(value = "빌라 이름으로 찾기", response = List.class)
	@GetMapping("/name/{name}")
	public ResponseEntity<List<VillaInfoDto>> getAptName(@PathVariable String name) {
		logger.debug("getGugunInSido - 호출");
		return new ResponseEntity<List<VillaInfoDto>>(VillaService.getVillaName(name), HttpStatus.OK);
	}
	@ApiOperation(value = "전체 빌라", response = List.class)
	@GetMapping("/all")
	public ResponseEntity<List<VillaInfoDto>> getAllApt() {
		logger.debug("getGugunInSido - 호출");
		return new ResponseEntity<List<VillaInfoDto>>(VillaService.getAllVilla(), HttpStatus.OK);
	}

}