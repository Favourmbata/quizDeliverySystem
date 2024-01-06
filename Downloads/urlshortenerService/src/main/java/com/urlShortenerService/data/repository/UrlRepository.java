package com.urlShortenerService.data.repository;

import com.urlShortenerService.data.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository <Url ,Long> {

    public Url findByShortLink(String shortLink);

}
