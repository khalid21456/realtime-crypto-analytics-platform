package ma.ensam.consumer_service.domaine.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CryptoDTO {
    private long id;
    private String pair;
    private String ask;
    private String bid;
    private String volume;
    private Long trade_id;
    private String price;
    private String size;
    private String time;
    private String rfq_volume;
}
