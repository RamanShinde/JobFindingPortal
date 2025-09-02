package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.Entity.Payment;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
public class InVoiceService {

    public byte[] generateInvoice(Payment pay) {
        try {
            Document doc = new Document();
            ByteArrayOutputStream baops = new ByteArrayOutputStream();

            // Create PDF writer
            PdfWriter.getInstance(doc, baops);

            doc.open();

            // Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Payment Invoice Copy", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);

            doc.add(new Paragraph(" ")); // blank line
            doc.add(new Paragraph("Invoice ID: " + pay.getTransactionId()));
            doc.add(new Paragraph("User ID: " + pay.getUserId()));
            doc.add(new Paragraph("Plan ID: " + pay.getPlanId()));
            doc.add(new Paragraph("Amount Paid: Rs " + pay.getAmount()));
            doc.add(new Paragraph("Payment Status: " + pay.getPaymentStatus()));
            doc.add(new Paragraph("Date: " + pay.getLocalDateTime()));

            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Thank you for using Zidio"));

            doc.close();

            return baops.toByteArray();

        } catch (DocumentException e) {
            throw new RuntimeException("Error generating Invoice", e);
        }
    }
}
