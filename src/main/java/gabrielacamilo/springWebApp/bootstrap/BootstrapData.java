package gabrielacamilo.springWebApp.bootstrap;

import gabrielacamilo.springWebApp.domain.Author;
import gabrielacamilo.springWebApp.domain.Book;
import gabrielacamilo.springWebApp.domain.Publisher;
import gabrielacamilo.springWebApp.repositories.AuthorRepository;
import gabrielacamilo.springWebApp.repositories.BookRepository;
import gabrielacamilo.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/* Marking as a component tells the Spring Framework to go ahead and detect this as a Spring managed component */
@Component
public class BootstrapData implements CommandLineRunner {

    /* Dependency Injection */
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "111123123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //------------------------------------------------

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "1234567891234");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        //------------------------------------------------

        Publisher addison = new Publisher("Addison-Wesley Professional", "Rua dos bobos nro 0");
        publisherRepository.save(addison);

        System.out.println(publisherRepository.findAll());


//        System.out.println("Started in Bootstrap");
//        System.out.println("Number of Books: " + bookRepository.count());

    }
}
