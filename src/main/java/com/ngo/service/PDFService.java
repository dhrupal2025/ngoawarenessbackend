package com.ngo.service;



import com.ngo.model.Donation;
import java.io.ByteArrayInputStream;

public interface PDFService {

    ByteArrayInputStream generateDonationReceipt(Donation donation);

}
