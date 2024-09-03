package hogwarts.express.api_harry_potter.domain.book;

public record BookDTO(Long id, String title, String synopsis, String releaseDate) {
    public BookDTO(Book book) {
        this(book.getId(), book.getTitle(), book.getSynopsis(), book.getReleaseDate());
    }
}
