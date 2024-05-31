package com.example.FxDeal;

import com.example.FxDeal.Controller.FXDealController;
import com.example.FxDeal.model.dto.FXDealDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;


@SpringBootTest
@Slf4j
public class FXDealApplicationTests {


	@Autowired
	private FXDealController fxDealController;

	@Test
	public void testCreateFXDeal_ValidInput_ReturnsSuccess() throws Exception {
		FXDealDTO dealDTO = new FXDealDTO();
		dealDTO.setFromCurrencyIso("USD");
		dealDTO.setToCurrencyIso("EUR");
		dealDTO.setDealTimestamp(LocalDateTime.now());
		dealDTO.setDealAmount(100.0f);

		ResponseEntity<String> response = fxDealController.createFXDeal(dealDTO);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("FX Deal created successfully", response.getBody());
	}

	@Test
	public void testCreateFXDeal_SameCurrency_ThrowsImportDealException() throws Exception {
		FXDealDTO dealDTO = new FXDealDTO();
		dealDTO.setFromCurrencyIso("USD");
		dealDTO.setToCurrencyIso("USD");
		dealDTO.setDealTimestamp(LocalDateTime.now());
		dealDTO.setDealAmount(100.0f);

		fxDealController.createFXDeal(dealDTO);
	}
}
