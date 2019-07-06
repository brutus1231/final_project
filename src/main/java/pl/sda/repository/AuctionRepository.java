package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Auction;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
