package pl.sda.assembler;

import org.springframework.stereotype.Component;
import pl.sda.dto.AuctionDto;
import pl.sda.model.Auction;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuctionAssembler {

    public AuctionDto toDto(Auction entity) {
        AuctionDto dto = new AuctionDto();
        dto.setId(entity.getId());
        dto.setBuyNowAmount(entity.getBuyNowAmount());
        dto.setCategoryId(entity.getCategory() == null ? null : entity.getCategory().getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setDescription(entity.getDescription());
        dto.setEndDate(entity.getEndDate());
        dto.setLocation(entity.getLocation());
        dto.setMinimumAmount(entity.getMinimumAmount());
        dto.setPromoted(entity.isPromoted());
        dto.setTitle(entity.getTitle());
        return dto;
    }

    public List<AuctionDto> toDtos(List<Auction> auctions){
        List<AuctionDto> auctionsList = new ArrayList<>();
        auctions.forEach(t-> auctionsList.add(toDto(t)));
        return auctionsList;
    }
}
