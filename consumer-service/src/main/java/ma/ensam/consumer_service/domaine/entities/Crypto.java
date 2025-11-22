package ma.ensam.consumer_service.domaine.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Crypto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pair;
    private double ask;
    private double bid;
    private double volume;
    private Long trade_id;
    private double price;
    private double size;
    private Date time;
    private Double rfq_volume;
}


