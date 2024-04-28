package dev.patikaa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autor")
public class Author {
    @Id
    @Column(name = "autor_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "autor_name", nullable = false)
    private String name;
    @Column(name = "autor_birthDate")
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Column(name = "autor_country")
    private String country;

    @OneToMany(mappedBy = "autor")
    private List<Book> book;


    public Author() {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}
