package mate.academy;

import mate.academy.lib.Injector;
import mate.academy.model.Movie;
import mate.academy.service.MovieService;
import mate.academy.util.HibernateUtil;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.academy");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);

        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setDescription("A mind-bending thriller by Christopher Nolan");

        Movie savedMovie = movieService.add(movie);
        System.out.println("Saved movie: " + savedMovie);

        movieService.get(savedMovie.getId())
                .ifPresentOrElse(
                        m -> System.out.println("Retrieved movie: " + m),
                        () -> System.out.println("Movie not found")
                );
        System.out.println(
                HibernateUtil.class.getClassLoader().getResource("hibernate.cfg.xml")
        );
    }
}
