package pl.sda.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.assembler.AuctionAssembler;
import pl.sda.dto.AuctionDto;
import pl.sda.model.Auction;
import pl.sda.repository.AuctionRepository;
import pl.sda.repository.CategoryRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class AuctionBoImpl {

    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AuctionAssembler auctionAssembler;
    @Autowired
    private UserBoImpl userBo;

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
        auction.setUser(userBo.getCurrentUser());
        auctionRepository.save(auction);
    }

    public void updateAuction(AuctionDto dto) {
        Auction auction = auctionRepository.getOne(dto.getId());
        auctionRepository.save(auction);
    }

    public AuctionDto getAuction(Long id) {
        Auction auction = auctionRepository.getOne(id);
        return auctionAssembler.toDto(auction);
    }

    public List<AuctionDto> findAll() {
        return auctionAssembler.toDtos(auctionRepository.findAll());
    }

    public List<AuctionDto> findByUsername(String username) {
        return auctionAssembler.toDtos(auctionRepository.findByUsername(username));
    }
}
