package streamsQuestions;

import models.Actor;
import models.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class NestedObjectsStreamBasic {

    public static void main(String[] args) {
        List<Movie> movies = getMovies();

        System.out.println("1. Find the highest paying actor for each movie");
        movies.stream()
                .collect(Collectors.toMap(
                        Movie::getName,
                        movie -> movie.getActors().stream()
                                .max(Comparator.comparing(Actor::getSalary)).orElse(new Actor(null, null))))
                .forEach((key, value) -> System.out.println(key + " -> " + value.getName()));
        System.out.println("---------");

        System.out.println("2. Find the highest paying actor for each movie preserve order");
        movies.stream()
                .collect(Collectors.toMap(
                        Movie::getName,
                        movie -> movie.getActors().stream()
                                .max(Comparator.comparing(Actor::getSalary)).orElse(new Actor(null, null)), (e1, e2) -> e1, LinkedHashMap::new))
                .forEach((key, value) -> System.out.println(key + " -> " + value.getName()));
        System.out.println("---------");

        System.out.println("3. Print all the actor for each movie");
        movies.stream()
                .collect(Collectors.toMap(
                        Movie::getName,
                        movie -> movie.getActors().stream().map(Actor::getName)
                                .collect(Collectors.joining(", ")), (e1, e2) -> e1, LinkedHashMap::new))
                .forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("---------");

        System.out.println("4. Print all the actor from each movie");
        String actors = movies.stream().flatMap(movie -> movie.getActors().stream().map(Actor::getName)).collect(Collectors.joining("\n"));
        System.out.println(actors);
        System.out.println("---------");

        System.out.println("5. Calculate total spending of each movie");
        movies.stream().collect(Collectors.toMap(Movie::getName, movie ->
                        movie.getActors().stream().mapToDouble(Actor::getSalary).sum(), (e1, e2) -> e1, LinkedHashMap::new))
                .forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("---------");

        System.out.println("6. Find average spending of each movie");
        movies.stream().collect(Collectors.toMap(Movie::getName, movie ->
                        movie.getActors().stream().mapToDouble(Actor::getSalary).average()))
                .forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("---------");

        System.out.println("7. print all books name separated by comma");
        List<List<String>> books = Arrays.asList(Arrays.asList("b1", "b2"), Arrays.asList("b3", "b4", "b5"), Arrays.asList("b6", "b7"), List.of("b8"));
        System.out.println(books.stream().flatMap(Collection::stream).collect(Collectors.joining(", ")));
        System.out.println("---------");

    }

    private static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        // Create actors for the first movie
        List<Actor> actors1 = new ArrayList<>();
        actors1.add(new Actor("Robert Downey Jr.", 80_000.0));
        actors1.add(new Actor("Chris Hemsworth", 50_000.0));

        // Create the first movie and add it to the movies list
        Movie movie1 = new Movie(actors1, "Avengers: Endgame");
        movies.add(movie1);

        // Create actors for the second movie
        List<Actor> actors2 = new ArrayList<>();
        actors2.add(new Actor("Leonardo DiCaprio", 30_000.0));
        actors2.add(new Actor("Brad Pitt", 40_000.0));

        // Create the second movie and add it to the movies list
        Movie movie2 = new Movie(actors2, "Once Upon a Time in Hollywood");
        movies.add(movie2);

        // Create actors for the third movie
        List<Actor> actors3 = new ArrayList<>();
        actors3.add(new Actor("Meryl Streep", 20_000.0));
        actors3.add(new Actor("Tom Hanks", 25_000.0));

        // Create the third movie and add it to the movies list
        Movie movie3 = new Movie(actors3, "The Post");
        movies.add(movie3);
        return movies;
    }
}