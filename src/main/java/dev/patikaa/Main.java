package dev.patikaa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        // Author Adding
        Author author = new Author();
        author.setName("Canan Tan");
        author.setBirthDate(LocalDate.of(1951, 6, 25));
        author.setCountry("Türkiye");
        entityManager.persist(author);

        // Publisher Adding
        Publisher publisher = new Publisher();
        publisher.setName("Doğan Kitap");
        publisher.setAdress("Türkiye");
        publisher.setEstablishmentYear(LocalDate.of(2016,01,05));
        entityManager.persist(publisher);

        // Book Adding
        Book book = new Book();
        book.setName("Piraye");
        book.setAutor(author);
        book.setPublisher(publisher);
        book.setStock(45);
        book.setPublicationYear(LocalDate.of(2016, 05,14));
        entityManager.persist(book);

        // Category Adding
        Category categoryFiction = new Category();
        categoryFiction.setName("Roman");
        categoryFiction.setDescription("İlk Türk Roman");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        categoryFiction.setBookList(bookList);
        entityManager.persist(categoryFiction);

        // BookBorrowing Adding
        BookBorrowing borrowing = new BookBorrowing();
        borrowing.setBorrowerName("Beyzanur");
        borrowing.setBorrowingDate(LocalDate.of(2024, 4, 28));
        borrowing.setReturnDate(LocalDate.of(2024, 5, 28));
        borrowing.setBook(book);
        entityManager.persist(borrowing);


        Category category = new Category();
        category.setName("Roman");
        category.setDescription("İkinci Türk Roman");
        entityManager.persist(category);

        Book book2=entityManager.find(Book.class,1);
        List<Category>categoryList=new ArrayList<>();
        categoryList.add(category);
        book.setCategoryList(categoryList);
        entityTransaction.commit();
    }
}