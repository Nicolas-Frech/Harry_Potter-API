package hogwarts.express.api_harry_potter.controllers;

import hogwarts.express.api_harry_potter.domain.book.Book;
import hogwarts.express.api_harry_potter.domain.book.BookDTO;
import hogwarts.express.api_harry_potter.domain.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class BookController {

    @Autowired
    BookRepository repository;

    @GetMapping
    public ResponseEntity searchBooks() {
        List<Book> books = repository.findAll();
        var booksDTO = books.stream().map(BookDTO::new).toList();

        return ResponseEntity.ok(booksDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity searchBookById(@PathVariable Long id) {
        var book = repository.getReferenceById(id);

        return ResponseEntity.ok(new BookDTO(book));
    }

    @GetMapping("/titulo/{title}")
    public ResponseEntity searchBookByTitle(@PathVariable String title) {
        var book = repository.findByTitle(title.replace("+"," "));

        return ResponseEntity.ok(new BookDTO(book));
    }


}
