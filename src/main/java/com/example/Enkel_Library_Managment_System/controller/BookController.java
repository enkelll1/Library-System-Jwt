package com.example.Enkel_Library_Managment_System.controller;

import com.example.Enkel_Library_Managment_System.dto.SearchBookRequest;
import com.example.Enkel_Library_Managment_System.dto.StoreBookRequest;
import com.example.Enkel_Library_Managment_System.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Validated
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/store")
    public ResponseEntity<String> storeBook(@Valid @RequestBody StoreBookRequest storeBookRequest) {
        String response = bookService.storeBook(storeBookRequest.getIsbn(), storeBookRequest.getTags());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<String>> searchBooks(@Valid @RequestBody SearchBookRequest request) {
        List<String> response = bookService.searchBooks(request);
        return ResponseEntity.ok(response);
    }
}
