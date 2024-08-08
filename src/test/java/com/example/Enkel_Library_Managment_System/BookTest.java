package com.example.Enkel_Library_Managment_System;


import com.example.Enkel_Library_Managment_System.dto.SearchBookRequest;
import com.example.Enkel_Library_Managment_System.dto.StoreBookRequest;
import com.example.Enkel_Library_Managment_System.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;



    @Test
    @WithMockUser(username = "test-user") // Mock a user with roles
    void storeBookWithValidRequestShouldReturnOk() throws Exception {
        StoreBookRequest request = new StoreBookRequest();
        request.setIsbn("2041232349872");
        request.setTags(Set.of("Science"));

        when(bookService.storeBook(request.getIsbn(), request.getTags())).thenReturn("Ok");

        mockMvc.perform(post("/books/store")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Ok"));
    }


    @Test
    @WithMockUser(username = "test-user", roles = {"USER"}) // Mock a user with roles
    void storeBookWithoutTagsShouldReturnError() throws Exception {
        StoreBookRequest request = new StoreBookRequest();
        request.setIsbn("2041232349872");

        mockMvc.perform(post("/books/store")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error tags\":\"tags must not be empty.\"}"));
    }

    @Test
    @WithMockUser(username = "test-user", roles = {"USER"}) // Mock a user with roles
    void storeBookWithoutIsbnShouldReturnError() throws Exception {
        StoreBookRequest request = new StoreBookRequest();
        request.setTags(Set.of("Science"));

        mockMvc.perform(post("/books/store")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error isbn\":\"isbn must not be empty.\"}"));
    }

    @Test
    @WithMockUser(username = "test-user", roles = {"USER"}) // Mock a user with roles
    void storeBookWithWrongIsbnFormatShouldReturnError() throws Exception {
        StoreBookRequest request = new StoreBookRequest();
        request.setTags(Set.of("Science"));
        request.setIsbn("204123234982");

        mockMvc.perform(post("/books/store")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error isbn\":\"ISBN must be a 13-digit number.\"}"));
    }

    @Test
    @WithMockUser(username = "test-user", roles = {"USER"}) // Mock a user with roles
    void storeBookWithWrongIsbnAndWithoutTag() throws Exception {
        StoreBookRequest request = new StoreBookRequest();
        request.setIsbn("204123234982");

        mockMvc.perform(post("/books/store")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error isbn\":\"ISBN must be a 13-digit number.\",\"error tags\":\"tags must not be empty.\"}"));
    }


    @Test
    @WithMockUser(username = "test-user", roles = {"USER"}) // Mock a user with roles
    void searchBookWithValidRequestShouldReturnBooks() throws Exception {

        // Prepare the request
        SearchBookRequest request = new SearchBookRequest();
        request.setSearch(Set.of("Science"));

        // Ensure this is mocked correctly and returns the mock data
        when(bookService.searchBooks(request)).thenReturn(List.of("1111111111111", "1111111111112"));

        // Perform the request and assert the expected results
        mockMvc.perform(get("/books/search")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("1111111111111"))
                .andExpect(jsonPath("$[1]").value("1111111111112"));
    }

    @Test
    @WithMockUser(username = "test-user", roles = {"USER"}) // Mock a user with roles
    void searchBookWithValidRequestShouldReturnNoBooks() throws Exception {

        // Prepare the request
        SearchBookRequest request = new SearchBookRequest();
        request.setSearch(Set.of("Science"));

        // Ensure this is mocked correctly and returns the mock data
        when(bookService.searchBooks(request)).thenReturn(Collections.singletonList("No books found"));

        // Perform the request and assert the expected results
        mockMvc.perform(get("/books/search")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0]").value("No books found"));
    }

    @Test
    @WithMockUser(username = "test-user", roles = {"USER"}) // Mock a user with roles
    void searchBookWithoutTagsShouldReturnError() throws Exception {
        SearchBookRequest request = new SearchBookRequest();

        mockMvc.perform(get("/books/search")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error search\":\"no tags provided.\"}"));
    }
}

