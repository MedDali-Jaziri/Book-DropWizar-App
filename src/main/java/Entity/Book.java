package Entity;

import javax.persistence.*;

@Entity
@Table(name = "Book")
/*@NamedQueries({
        @NamedQuery(name = "com.dropwizard.core.book.findAll",query = "SELECT b FROM Book b")
})*/
public class Book {

    @Id
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "pages")
    private long pages;

    public Book(){

    }

    public Book(int id, String title, long pages){
        super();
        this.id = id;
        this.title = title;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getPages() {
        return pages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
}
