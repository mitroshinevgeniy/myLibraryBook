package ru.mitroshin.mylibrarybook.service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mitroshin.mylibrarybook.DTO.BookDto;
import ru.mitroshin.mylibrarybook.mapper.BookMapper;
import ru.mitroshin.mylibrarybook.model.Book;
import ru.mitroshin.mylibrarybook.repositoty.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> findAll() {
        return bookMapper.toListDto(bookRepository.findAll());
    }

    @Override
    public BookDto findById(Long id) {
        return Optional.of(getById(id)).map(bookMapper::modelToDto).get();
    }

    @Override
    @Transactional
    public BookDto save(BookDto book) {
        return bookMapper.modelToDto(bookRepository.save(
                bookMapper.dtoToModel(book)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        var book = getById(id);
        bookRepository.delete(book);
    }

    private Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Book with id: " + id + " not found"));
    }
}
