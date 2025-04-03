package noseryoung.ch.bookstore.book;

import lombok.RequiredArgsConstructor;
import noseryoung.ch.bookstore.exception.BookNotFoundException;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book findById(UUID id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(UUID id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setLanguage(updatedBook.getLanguage());
                    book.setPrice(updatedBook.getPrice());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
