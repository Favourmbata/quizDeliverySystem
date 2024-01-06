package com.urlShortenerService.service.interfaces;

import com.urlShortenerService.data.model.Url;
import com.urlShortenerService.dto.request.UrlDto;
import org.springframework.stereotype.Service;

@Service

public interface UrlService {
    public  Url  generateShortLink(UrlDto urlDto);
    public  Url persistShortLink(Url url);
    public Url getEncodedUrl(String url);

    public void deleteShortLink(Url url);
}
