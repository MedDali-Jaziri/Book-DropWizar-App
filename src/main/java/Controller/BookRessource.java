package Controller;

import DAO.BookDAO;
import Entity.Book;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("bookService")
@Produces(MediaType.APPLICATION_JSON)
public class BookRessource {
    private final BookDAO bookDAO;

    public BookRessource(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GET
    @Path("/getBook")
    @UnitOfWork
    public Book getBook(@QueryParam("bookID")int bookID){
        return this.bookDAO.getBook(bookID);
    }

    @GET
    @Path("/getBooks")
    @UnitOfWork
    public List<Book> getBooks(){
        return this.bookDAO.getBooks();
    }

    @POST
    @Path("/addBook")
    @UnitOfWork
    public int addBook(
            @Valid Book book
            ){
        return this.bookDAO.addBook(book).getId();
    }

    @DELETE
    @Path("/deleteBook")
    @UnitOfWork
    public String deleteBook(@QueryParam("bookID") int bookID){
        return this.bookDAO.deleteBooks(bookID);
    }

    @POST
    @Path("/updateBook")
    @UnitOfWork
    public String updateBook(@Valid Book book){
        return this.bookDAO.updateBook(book);
    }
}
