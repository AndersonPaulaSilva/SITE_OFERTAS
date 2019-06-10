package com.anderson.service;

import com.anderson.domain.SocialMetaTag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Anderson on 19/05/2019.
 */

@Service // Torna a classe um bean gerenciável pelo Spring
public class SocialMetaTagService {

    private static Logger log = LoggerFactory.getLogger(SocialMetaTagService.class);

    //

    public SocialMetaTag getSocialMetaTagByUrl(String url){

        SocialMetaTag Twitter = getTwitterCardByUrl(url);
        if(!isEmpty(Twitter)){

            return Twitter;

        }

        SocialMetaTag openGraph = getOpenGraphByUrl(url);

        if(!isEmpty(openGraph)){

            return openGraph;
        }

        return null;

    }

    private SocialMetaTag getTwitterCardByUrl(String url) {

        SocialMetaTag tag = new SocialMetaTag();
        try {
            Document doc = Jsoup.connect(url).get();
            tag.setTitle(doc.head().select("meta[name=twitter:title]").attr("content"));
            tag.setSite(doc.head().select("meta[name=twitter:site]").attr("content"));
            tag.setImagem(doc.head().select("meta[name=twitter:image]").attr("content"));
            tag.setUrl(doc.head().select("meta[name=twitter:url]").attr("content"));
        } catch (IOException e) {
            log.error(e.getMessage(),e.getCause());
        }

        return tag;

    }
    //

    private SocialMetaTag getOpenGraphByUrl(String url) {

        SocialMetaTag tag = new SocialMetaTag();
        try {
            Document doc = Jsoup.connect(url).get();
            tag.setTitle(doc.head().select("meta[property=og:title]").attr("content"));
            tag.setSite(doc.head().select("meta[property=og:site_name]").attr("content"));
            tag.setImagem(doc.head().select("meta[property=og:image]").attr("content"));
            tag.setUrl(doc.head().select("meta[property=og:url]").attr("content"));
        } catch (IOException e) {
            log.error(e.getMessage(),e.getCause());
        }

        return tag;

    }

    private Boolean isEmpty(SocialMetaTag tag){

        if(tag.getImagem().isEmpty())return true;
        if(tag.getSite().isEmpty())return true;
        if(tag.getTitle().isEmpty())return true;
        if(tag.getUrl().isEmpty())return true;
        return false;
    }
}
