package ma.ensam.producer_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.ensam.producer_service.model.Tick;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger log = LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final CoinbaseService coinbaseService;
    private final ObjectMapper objectMapper;

    @Value("${crypto.topic}")
    private String topic;

    @Value("${crypto.pairs}")
    private String csvPairs; // comma-separated pairs

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate,
                           CoinbaseService coinbaseService,
                           ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.coinbaseService = coinbaseService;
        this.objectMapper = objectMapper;
    }

    /**
     * Every 5 seconds, fetch ticker for each pair and send to Kafka.
     */
    @Scheduled(fixedRate = 5000)
    public void publishTicks() {
        String[] pairs = csvPairs.split(",");
        for (String rawPair : pairs) {
            String pair = rawPair.trim();
            try {
                Tick tick = coinbaseService.getTicker(pair);
                if (tick == null) {
                    log.warn("No data returned for {}", pair);
                    continue;
                }
                tick.setPair(pair);

                String payload = toJson(tick);
                kafkaTemplate.send(topic, pair, payload);
                log.info("Sent to Kafka topic {} key={} value={}", topic, pair, payload);
            } catch (Exception e) {
                log.error("Error while processing pair {}: {}", pair, e.getMessage());
            }
        }
    }

    private String toJson(Tick tick) throws JsonProcessingException {
        return objectMapper.writeValueAsString(tick);
    }
}
