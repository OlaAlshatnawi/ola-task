package com.example.FxDeal.exception;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ImportDealException extends RuntimeException {
    public ImportDealException(String message) {
        super(message);
        log.error(message);
    }


    public ImportDealException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }
}
