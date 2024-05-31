package com.example.FxDeal.Service;

import com.example.FxDeal.exception.ImportDealException;
import com.example.FxDeal.model.dto.FXDealDTO;
import com.example.FxDeal.model.entity.FXDeal;
import com.example.FxDeal.repository.FXDealRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FXDealService {

    private final FXDealRepository fxDealRepository;

    public FXDealService(FXDealRepository fxDealRepository) {
        this.fxDealRepository = fxDealRepository;
    }

    @Transactional
    public void saveFXDeal(FXDealDTO dealDTO) throws Exception {

        try
        {
            if (dealDTO.getFromCurrencyIso().equals(dealDTO.getToCurrencyIso())) {
                String errorMessage = "From Currency and To Currency cannot be the same.";
                log.error(errorMessage);
                throw new ImportDealException(errorMessage);
            }

            FXDeal deal = convertToEntity(dealDTO);
            fxDealRepository.save(deal);
            log.info("FX Deal saved successfully: {}", dealDTO);
        }
        catch (ImportDealException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            String errorMessage = "An error occurred while importing the deal. Please try again later.";
            log.error(errorMessage, e);
            throw new ImportDealException(errorMessage, e);
        }
    }

    private FXDeal convertToEntity(FXDealDTO dealDTO) {
        FXDeal deal = new FXDeal();
        deal.setFromCurrencyIso(dealDTO.getFromCurrencyIso());
        deal.setToCurrencyIso(dealDTO.getToCurrencyIso());
        deal.setDealTimestamp(dealDTO.getDealTimestamp());
        deal.setDealAmount(dealDTO.getDealAmount());
        return deal;
    }
}
