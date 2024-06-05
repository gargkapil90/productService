package ecommerce.productservice.configurations;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().build();
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//        return restTemplate;
    }
}
