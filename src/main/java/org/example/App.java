package org.example;

import org.example.model.Movie;
import org.example.store.MovieStore;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, IOException, URISyntaxException {
        // True Open Source
        // Readable, Secure and Efficient Code
        // SQL DSL
        MovieManager movieManager = MovieManager.getManager(dataSource());

        MovieStore movieStore = movieManager.getMovieStore();

        movieStore.delete().execute();

        //

        movieStore.insert()
                .values(
                    MovieBuilder.aMovie()
                        .title("Jurassic Park")
                        .genre("Action")
                        .directedBy("James Cameron")
                        .rating(9.5)
                        .yearOfRelease((short) 2010) // Optimized Mapping
                        .build()
                ).execute();

        Movie movie = movieStore.insert()
                .values(
                        MovieBuilder.aMovie()
                                .title("Avatar")
                                .genre("Action")
                                .directedBy("James Cameron")
                                .rating(9.8)
                                .yearOfRelease((short) 2020)
                                .build()
                ).returning();

        movie.setGenre("Action/Drama");

        movieStore.update(movie);

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(
                App.class.getClassLoader().getResource("movies.csv").toURI())))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                movieStore.insert()
                        .values(
                                MovieBuilder.aMovie()
                                        .title(values[0])
                                        .genre(values[1])
                                        .directedBy(values[2])
                                        .rating(Double.valueOf(values[3]))
                                        .yearOfRelease(Short.valueOf(values[4]))
                                        .build()
                        ).execute();

            }

        }

        System.out.println(movieStore.select().count());

        // movieStore.select(MovieStore.rating().gt(2.3).and(MovieStore.directedBy().eq("Came"))).;

    }













































































    public static DataSource dataSource() {
        PGSimpleDataSource ds = new PGSimpleDataSource() ;
        ds.setServerName( "localhost" );
        ds.setDatabaseName( "moviedb" );
        ds.setUser( "moviedb" );
        ds.setPassword( "moviedb" );
        ds.setDatabaseName("moviedb");

        return ds;
    }
}
