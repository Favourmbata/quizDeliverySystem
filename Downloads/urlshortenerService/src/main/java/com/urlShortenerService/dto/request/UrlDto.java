package com.urlShortenerService.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UrlDto {
    private String url;
//    private String expirationDate;
}
