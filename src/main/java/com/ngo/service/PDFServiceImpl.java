package com.ngo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import com.ngo.model.Donation;


@Service
public class PDFServiceImpl implements PDFService {


    @Override
    public ByteArrayInputStream generateDonationReceipt(Donation donation) {


        Document document = new Document();


        ByteArrayOutputStream out =
                new ByteArrayOutputStream();


        try {

            PdfWriter.getInstance(document, out);


            document.open();


            // Title

            Font titleFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            20,
                            BaseColor.GREEN
                    );


            Paragraph title =
                    new Paragraph(
                            "NGO SOCIAL AWARENESS",
                            titleFont
                    );

            title.setAlignment(Element.ALIGN_CENTER);

            document.add(title);


            document.add(
                    new Paragraph(
                            "Donation Receipt"
                    )
            );


            document.add(
                    new Paragraph(
                            "--------------------------------------"
                    )
            );


            // Donation Details


            document.add(
                    new Paragraph(
                    "Receipt ID : NGO-" + donation.getId()
                    )
            );


            document.add(
                    new Paragraph(
                    "Donor Name : "
                    + donation.getDonorName()
                    )
            );


            document.add(
                    new Paragraph(
                    "Email : "
                    + donation.getEmail()
                    )
            );


            document.add(
                    new Paragraph(
                    "Mobile : "
                    + donation.getMobile()
                    )
            );


            document.add(
                    new Paragraph(
                    "Donation Amount : ₹"
                    + donation.getAmount()
                    )
            );


            document.add(
                    new Paragraph(
                    "Payment Method : "
                    + donation.getPaymentMethod()
                    )
            );


            document.add(
                    new Paragraph(
                    "Donation Date : "
                    + donation.getDonationDate()
                    )
            );


            document.add(
                    new Paragraph(
                    "\nThank you for supporting our NGO."
                    )
            );


            document.add(
                    new Paragraph(
                    "\nAuthorized Signature\n"
                    +"NGO Social Awareness Team"
                    )
            );


            document.close();



        } catch(Exception e){

            e.printStackTrace();

        }


        return new ByteArrayInputStream(
                out.toByteArray()
        );
    }

}