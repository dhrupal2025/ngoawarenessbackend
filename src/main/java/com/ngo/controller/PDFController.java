package com.ngo.controller;


import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ngo.model.Donation;
import com.ngo.repository.DonationRepository;
import com.ngo.service.PDFService;



@RestController
@RequestMapping("/api/pdf")
@CrossOrigin(origins="http://localhost:5174")
public class PDFController {


    @Autowired
    private DonationRepository repository;


    @Autowired
    private PDFService pdfService;



    @GetMapping("/donation/{id}")
    public ResponseEntity<InputStreamResource> downloadDonationReceipt(
            @PathVariable Long id
    ){


        Donation donation =
                repository.findById(id)
                .orElseThrow(
                () -> new RuntimeException("Donation not found")
                );


        ByteArrayInputStream pdf =
                pdfService.generateDonationReceipt(donation);



        HttpHeaders headers =
                new HttpHeaders();


        headers.add(
            "Content-Disposition",
            "inline; filename=DonationReceipt.pdf"
        );



        return ResponseEntity.ok()
                .headers(headers)
                .contentType(
                  MediaType.APPLICATION_PDF
                )
                .body(
                  new InputStreamResource(pdf)
                );

    }

}
