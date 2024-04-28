package dev.patikaa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int İd;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(name = "category_description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "categoryList" , fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Book> bookList;

    public int getId() {
        return İd;
    }

    public void setId(int id) {
        İd = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
