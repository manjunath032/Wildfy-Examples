package com.example.helloejb;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


public class PdfSignatureAdderJava8 {

    public static void main(String[] args) throws Exception {

        // Your file location
        String src = "F:/pdf/input.pdf";
        String dest = "F:/pdf/output.pdf";


        String dateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String userName = "Divya";

        addSignatureStamp(src, dest, userName);
    }

    private static void addSignatureStamp(String src, String dest, String userName) throws Exception {

        PDDocument document = PDDocument.load(new File(src));


        // Get the last page
        PDPage lastPage = document.getPage(document.getNumberOfPages() - 1);

        String loginUser = userName;
        String dateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Two-line format
        String line1 = "Signed by:  " + loginUser;
        String line2 = "";
        String line3 = dateTime;


        String signatureImagePath = "F:/pdf/signature.png";


        PDFont font = PDType1Font.TIMES_BOLD;
        int fontSize = 8;


        // Last page
        PDRectangle mediaBox = lastPage.getMediaBox();

        float margin = 20; // distance from page edges
        float leading = 12; // line spacing

        // Load signature image
        PDImageXObject pdImage = PDImageXObject.createFromFile(signatureImagePath, document);
        float imageWidth = 100;   // adjust width
        float imageHeight = 50;   // adjust height

        // Calculate bottom-right X coordinate
        float x = mediaBox.getWidth() - imageWidth - margin;
        float y = margin + fontSize*2 + leading + imageHeight; // leave space for text below image

        PDPageContentStream content = new PDPageContentStream(
                document, lastPage, PDPageContentStream.AppendMode.APPEND, true, true
        );

        // Draw the image
        content.drawImage(pdImage, x, y, imageWidth, imageHeight);

        // Draw the text below the image
        float textStartX = x;
        float textStartY = y - leading; // below image

        content.beginText();
        content.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
        content.newLineAtOffset(textStartX, textStartY);
        content.newLineAtOffset(2, -leading); // one line space
        content.showText("Signed by: " + loginUser);
        content.newLineAtOffset(0, - leading-8); // one line space
        content.showText(dateTime);
        content.endText();

        content.close();

        document.save(dest);
        document.close();

        System.out.println("✔ Signature image + text added at bottom-right of last page!");
    }
}
