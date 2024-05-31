package com.example.FxDeal.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FXDealDTO {
    //validation annotations ***


    @NotNull(message = "From Currency can't be null")
    @Pattern(regexp = "^[A-Z]{3}$", message = "From Currency ISO code must consist of 3 uppercase letters")
    private String fromCurrencyIso;

    @NotNull(message = "To Currency can't be null")
    @Pattern(regexp = "^[A-Z]{3}$", message = "To Currency ISO code must consist of 3 uppercase letters")
    private String toCurrencyIso;

    @PastOrPresent(message = "Deal timestamp cannot be in the future")
    @NotNull(message = "Date can't be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dealTimestamp;

    @NotNull(message = "Deal Amount can't be null")
    @DecimalMin(value = "1.0", message = "Deal amount must be greater than or equal to 1.0")
    private Float dealAmount;

}
