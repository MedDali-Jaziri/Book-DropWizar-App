package main;

import Controller.BookRessource;
import DAO.BookDAO;
import Entity.Book;
import config.BookConfiguration;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class Book_App extends Application<BookConfiguration> {

    public static void main(String[] args) throws Exception{
        new Book_App().run(args);
    }
    @Override
    public void run(BookConfiguration bookConfiguration, Environment environment) throws Exception {
        System.out.println("Hello Bool !!");
        BookDAO bookDAO = new BookDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new BookRessource(bookDAO));
    }

    HibernateBundle<BookConfiguration> hibernateBundle = new HibernateBundle<BookConfiguration>(Book.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(BookConfiguration bookConfiguration) {
            return bookConfiguration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<BookConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }
}
