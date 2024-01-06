package com.urlShortenerService.controller;

import com.urlShortenerService.data.model.Url;
import com.urlShortenerService.dto.request.UrlDto;
import com.urlShortenerService.dto.response.UrlErrorResponse;
import com.urlShortenerService.dto.response.UrlResponse;
import com.urlShortenerService.service.interfaces.UrlService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
public class UrlShorteningController {
    private UrlService urlService;


    @PostMapping("generate")
    public ResponseEntity<?>generateShortLink(@RequestBody UrlDto urlDto){
        Url urlToRet = urlService.generateShortLink(urlDto);
        if (urlToRet!= null){
            UrlResponse urlResponse = new UrlResponse();
            urlResponse.setOriginalUrl(urlToRet.getOriginalUrl());
            urlResponse.setShortLink(urlToRet.getShortLink());
            urlResponse.setExpirationDate(urlToRet.getExpirationDate());
            return new ResponseEntity<>(urlService.generateShortLink(urlDto), HttpStatus.OK);
        }
        UrlErrorResponse urlErrorResponse = new UrlErrorResponse();
        urlErrorResponse.setStatus("404");
        urlErrorResponse.setError("There was an error processing ur request.please try again");
        return new ResponseEntity<>(urlErrorResponse, HttpStatus.OK);
    }
}
