package com.example.FxDeal.Controller;

import com.example.FxDeal.Service.FXDealService;

import com.example.FxDeal.exception.ImportDealException;
import com.example.FxDeal.model.dto.FXDealDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@Slf4j
public class FXDealController {

    @Autowired
    private FXDealService fxDealService;

    @PostMapping("/deals")
    public ResponseEntity<String> createFXDeal(@RequestBody @Validated FXDealDTO dealDTO) throws Exception {
        log.info("Received request to create FX deal: {}", dealDTO);

        try {
            fxDealService.saveFXDeal(dealDTO);
            log.info("FX deal created successfully: {}", dealDTO);
            return ResponseEntity.ok("FX Deal created successfully");
        }
        catch (ImportDealException e) {
            log.error("Failed to create FX deal: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            log.error("An error occurred while processing the request", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request. Please try again later.");
        }
    }

    @GetMapping("/")
    public RedirectView index() {
        return new RedirectView("http://localhost:8083/webpage.HTML");
    }
}
