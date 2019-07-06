package pl.sda.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dto.AuctionDto;
import pl.sda.model.Auction;
import pl.sda.repository.AuctionRepository;
import pl.sda.repository.CategoryRepository;

import java.io.IOException;
import java.util.Date;

@Service
public class AuctionBoImpl {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveAuction(AuctionDto dto) throws IOException {
        Auction auction = new Auction();
        auction.setId(dto.getId());
        auction.setTitle(dto.getTitle());
        auction.setDescription(dto.getDescription());
        auction.setPicture(dto.getPicture().getBytes());
        auction.setMinimumAmount(dto.getMinimumAmount());
        auction.setBuyNowAmount(dto.getBuyNowAmount());
        auction.setCreationDate(new Date());
        auction.setEndDate(dto.getEndDate());
        auction.setCategory(categoryRepository.getOne(dto.getCategoryId()));
        auctionRepository.save(auction);
    }

    public void updateAuction(AuctionDto dto) {
        Auction auction = auctionRepository.getOne(dto.getId());
        auctionRepository.save(auction);
    }

    public AuctionDto getAuction(Long id) {
        Auction auction = auctionRepository.getOne(id);
        return new AuctionDto();
    }
}
