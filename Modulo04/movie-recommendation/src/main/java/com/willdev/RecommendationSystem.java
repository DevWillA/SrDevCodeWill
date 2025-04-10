package com.willdev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class RecommendationSystem {

    private List<Movie> movies;

    public void loadMovies(Collection<Movie> movies) {
        this.movies = new ArrayList<>(movies);
    }

    public List<String> getGenres() {
        return movies.stream()
                .map(Movie::getGenre)
                .distinct()
                .sorted()
                .toList();
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movies.stream()
                .filter(m -> m.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    public List<Movie> getRecomendationByGenre(String genre) {
        return movies.stream()
                .filter(m -> m.getGenre().equalsIgnoreCase(genre))
                .filter(this::classifyMovie)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                        .thenComparing(Movie::getTitle))
                .toList();

    }

    private boolean classifyMovie(Movie movie) {
        return movie.getRating() > 4.0 && movie.getVotes() >= 100;
    }
}