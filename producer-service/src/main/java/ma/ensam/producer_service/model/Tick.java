package ma.ensam.producer_service.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tick {

    private String pair;      // e.g. "ETH-EUR"
    private Long trade_id;
    private String price;
    private String size;
    private String bid;
    private String ask;
    private String rfq_volume;
    private String volume;
    private String time;      // ISO string

    public Tick() {
    }

    @Override
    public String toString() {
        return "Tick{" +
                "pair='" + pair + '\'' +
                ", trade_id=" + trade_id +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                ", bid='" + bid + '\'' +
                ", ask='" + ask + '\'' +
                ", volume='" + volume + '\'' +
                ", time='" + time + '\'' +
                ", rfq_volume='" + rfq_volume + '\'' +
                '}';
    }
}
