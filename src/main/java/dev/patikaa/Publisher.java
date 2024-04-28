package dev.patikaa;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @Column(name = "publisher_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "publisher_name", nullable = false)
    private String name;

    @Column(name = "publisher_establishmentYear")
    @Temporal(TemporalType.DATE)
    private LocalDate establishmentYear;


    @Column(name = "publisher_address")
    private String adress;
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> bookList ;

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

    public LocalDate getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(LocalDate establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
