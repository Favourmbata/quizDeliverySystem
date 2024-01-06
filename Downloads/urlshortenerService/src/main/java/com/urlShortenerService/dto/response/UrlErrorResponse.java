package com.urlShortenerService.dto.response;

import lombok.Data;

@Data
public class UrlErrorResponse {
    private String status;
    private  String error;
}
