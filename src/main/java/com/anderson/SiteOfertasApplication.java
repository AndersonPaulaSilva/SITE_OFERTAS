package com.anderson;

import com.anderson.domain.SocialMetaTag;
import com.anderson.service.SocialMetaTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SiteOfertasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SiteOfertasApplication.class, args);
	}

    @Autowired
	SocialMetaTagService service;

	@Override
	public void run(String... strings) throws Exception {

		SocialMetaTag tag = service.getSocialMetaTagByUrl("https://www.pichau.com.br/processador-intel-core-i9-9900k-octa-core-3-6ghz-5ghz-turbo-16mb-cache-lga1151-bx80684i99900k");
		System.out.println(tag.toString());
	}
}
