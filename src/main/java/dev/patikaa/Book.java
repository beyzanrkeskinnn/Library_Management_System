package dev.patikaa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name", nullable = false)
    private String name;

    @Column(name = "book_publicationYear")
    @Temporal(TemporalType.DATE)
    private LocalDate publicationYear;

    @Column(name = "book_stock", nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_autor_id", referencedColumnName = "autor_id")
    private Author autor;

    @ManyToMany
    @JoinTable(name = "categoryBook",
            joinColumns=@JoinColumn(name = "book_id"),
            inverseJoinColumns =@JoinColumn(name = "category_id"))
    private List<Category> categoryList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<BookBorrowing> borrowingList;
    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<BookBorrowing> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(List<BookBorrowing> borrowingList) {
        this.borrowingList = borrowingList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                ", autor=" + autor +
                ", categoryList=" + categoryList +
                ", publisher=" + publisher +
                ", borrowingList=" + borrowingList +
                '}';
    }
}
