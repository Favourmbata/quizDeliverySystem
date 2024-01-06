package com.urlShortenerService;

import com.urlShortenerService.dto.response.UrlResponse;
import com.urlShortenerService.service.interfaces.UrlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UrlshortenerServiceApplicationTests {
	@Autowired
 private UrlService urlService;
	private UrlResponse urlResponse;
	@Test
	void setUp() {
		urlResponse = new UrlResponse();
		urlResponse.setOriginalUrl("");
		urlResponse.setShortLink("");
		urlResponse.setExpirationDate(LocalDateTime.now());
	}

	@Test
	public void createUrl(){
		assertDoesNotThrow(()->{
			urlService.getEncodedUrl(urlResponse.getOriginalUrl());
		});
	}

   @Test
	void deleteUrl(){
//		assertTrue(urlService.deleteShortLink(urlResponse.getShortLink()));
   }



}
