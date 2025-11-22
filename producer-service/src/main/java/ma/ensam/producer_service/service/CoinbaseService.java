package ma.ensam.producer_service.service;

import ma.ensam.producer_service.model.Tick;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinbaseService {

    private final RestTemplate restTemplate;

    public CoinbaseService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Tick getTicker(String pair) {
        String url = "https://api.exchange.coinbase.com/products/" + pair + "/ticker";
        return restTemplate.getForObject(url, Tick.class);
    }
}
