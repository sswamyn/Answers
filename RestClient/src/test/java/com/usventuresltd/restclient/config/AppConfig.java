package com.usventuresltd.restclient.config;

import com.usventuresltd.restclient.services.AstroInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

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
     * the template bean can then be used to make REST calls.
     *
     * @param RestTemplateBuilder
     * @return RestTemplate
     */
    @Bean
    public RestTemplate astroRestTemplate(RestTemplateBuilder builder, // The bean added as the parameter will be autowired in the service
                                          @Value("${astroBase.url}") String astroUrl) {
        // We are naming this as AstroRestTemplate to make sure that we do not accidentally use this in other places

        return builder.rootUri(astroUrl).build();
    }

    @Bean
    public AstroInterface astroInterface(@Value("${astroBase.url}") String astroUrl) {
        // Boilerplate code from https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface
        // Hopefully, this will be simplified in the future versions of Spring
        WebClient webClient = WebClient.builder()
                .baseUrl(astroUrl)
                .build();
        // The above statement is equivalent to the following:
        // WebClient webClient = WebClient.create(astroUrl);

        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(AstroInterface.class);
    }
}
