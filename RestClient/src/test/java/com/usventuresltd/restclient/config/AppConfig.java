package com.usventuresltd.restclient.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    /**
    * Indicates that a class declares one or more @Bean methods and may be processed by the Spring container
     *   to generate bean definitions and service requests for those beans at runtime, for example:
     *   @Configuration
     *   public class AppConfig {
     *
     *       @Bean
     *       public MyBean myBean() {
     *           // instantiate, configure and return bean ...
     *       }
     *   }
     */

    /**
     * This method is used to create a RestTemplate bean that is specific for this url
     *      the template bean can then be used to make REST calls.
     * @param RestTemplateBuilder
     * @return RestTemplate
     */
    @Bean
    public RestTemplate astroRestTemplate(RestTemplateBuilder builder) { // The bean added as the parameter will be autowired in the service
        // We are naming this as AstroRestTemplate to make sure that we do not accidentally use this in other places

        return builder.rootUri("http://api.open-notify.org").build();
    }

}
