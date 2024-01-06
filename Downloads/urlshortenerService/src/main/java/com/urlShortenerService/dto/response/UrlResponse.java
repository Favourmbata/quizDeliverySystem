package com.urlShortenerService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UrlResponse {
    private String originalUrl;
    private String shortLink;
    private LocalDateTime expirationDate;
}

