package ma.ensam.consumer_service.repositories;

import ma.ensam.consumer_service.domaine.entities.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto,Long > {

}
