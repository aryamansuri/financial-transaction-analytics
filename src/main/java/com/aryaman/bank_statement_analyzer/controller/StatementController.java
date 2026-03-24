package com.aryaman.bank_statement_analyzer.controller;

import com.aryaman.bank_statement_analyzer.service.PdfParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/statements")
public class StatementController {

    @Autowired
    private PdfParserService pdfParserService;

    @PostMapping("/upload")
    public String uploadStatement(@RequestParam("file") MultipartFile file) throws IOException {

        File tempFile = File.createTempFile("statement", ".pdf");
        file.transferTo(tempFile);

        String text = pdfParserService.extractText(tempFile);

        return text.substring(0, Math.min(500, text.length()));
    }
}