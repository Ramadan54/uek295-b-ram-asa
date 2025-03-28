package noseryoung.ch.bookstore.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(UUID id) {
        return bookRepository.findById(id);
    }

    public Book create(Book book) {
        if (book.getBookId() == null) {
            book.setBookId(UUID.randomUUID());
        }
        return bookRepository.save(book);
    }

    public Book update(UUID id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setLanguage(updatedBook.getLanguage());
                    book.setPrice(updatedBook.getPrice());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found: " + id));
    }

    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }
}
