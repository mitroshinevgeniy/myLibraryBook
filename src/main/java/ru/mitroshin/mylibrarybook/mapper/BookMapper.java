package ru.mitroshin.mylibrarybook.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;
import ru.mitroshin.mylibrarybook.DTO.BookDto;
import ru.mitroshin.mylibrarybook.model.Book;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book dtoToModel(BookDto bookDto);

    BookDto modelToDto(Book book);

    List<BookDto> toListDto(List<Book> books);
}
