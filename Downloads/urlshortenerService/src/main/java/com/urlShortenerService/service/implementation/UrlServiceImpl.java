package com.urlShortenerService.service.implementation;

import com.google.common.hash.Hashing;
import com.urlShortenerService.data.model.Url;
import com.urlShortenerService.data.repository.UrlRepository;
import com.urlShortenerService.dto.request.UrlDto;
import com.urlShortenerService.service.interfaces.UrlService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import java.time.LocalDateTime;
@Component
@Service
public class UrlServiceImpl implements UrlService {
@Autowired
    private  UrlRepository urlRepository;
    @Override
    public Url generateShortLink(UrlDto urlDto) {
        if (StringUtils.isNotBlank(urlDto.getUrl())){

            String encodedUrl = encodedUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setExpirationDate(getExpirationDate(String.valueOf(LocalDateTime.now().plusDays(2)),urlToPersist.getCreationDate()));
            Url urlToRet = persistShortLink(urlToPersist);
            if (urlToRet!= null)return urlToRet;
          return null;
        }

        return null;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if (StringUtils.isBlank(expirationDate)){
            return creationDate.plusSeconds(60);
        }
      LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate);
        return expirationDateToRet;
    }


    private String encodedUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32().hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();
        return encodedUrl;
    }

    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet = urlRepository.save(url);
        return urlToRet ;
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;
    }

    @Override
    public void deleteShortLink(Url url) {
      urlRepository.delete(url);
    }
}
