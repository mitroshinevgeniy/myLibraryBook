package ru.mitroshin.mylibrarybook.repositoty;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.mitroshin.mylibrarybook.model.Book;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {

}
