package ru.mitroshin.mylibrarybook.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mitroshin.mylibrarybook.DTO.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findAll ();
    BookDto findById( Long id);
    BookDto save (BookDto book);
    void deleteById (Long id);
}
