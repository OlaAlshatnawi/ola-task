package com.example.FxDeal.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "fx_deals")
@Data
public class FXDeal {

    @Id

    @Column(name = "deal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;

    @Column(name = "from_currency_iso", nullable = false)
    private String fromCurrencyIso;

    @Column(name = "to_currency_iso", nullable = false)
    private String toCurrencyIso;

    @Column(name = "deal_timestamp", nullable = false)
    private LocalDateTime dealTimestamp;

    @Column(name = "deal_amount", nullable = false)
    private Float dealAmount;

}
