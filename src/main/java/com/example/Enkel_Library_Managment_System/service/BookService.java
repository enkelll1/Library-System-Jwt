package com.example.Enkel_Library_Managment_System.service;

import com.example.Enkel_Library_Managment_System.dto.SearchBookRequest;
import com.example.Enkel_Library_Managment_System.model.Book;
import com.example.Enkel_Library_Managment_System.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String storeBook(String isbn, Set<String> tags) {
        Book book = new Book(isbn, tags);
        bookRepository.save(book);
        return "Ok";
    }

    public List<String> searchBooks(SearchBookRequest request) {
        List<Book> books = bookRepository.findByTags(request.getSearch());
        if (books.isEmpty()) {
            return List.of("No books found");
        }
        return books.stream().map(Book::getIsbn).collect(Collectors.toList());
    }
}
