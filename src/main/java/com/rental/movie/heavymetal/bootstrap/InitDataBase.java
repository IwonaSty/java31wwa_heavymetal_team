package com.rental.movie.heavymetal.bootstrap;

import com.rental.movie.heavymetal.controllers.MovieController;
import com.rental.movie.heavymetal.model.*;
import com.rental.movie.heavymetal.repositories.CopyRepository;
import com.rental.movie.heavymetal.repositories.MovieRepository;
import com.rental.movie.heavymetal.repositories.UserRepository;
import com.rental.movie.heavymetal.services.RoleService;
import org.dom4j.tree.SingleIterator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

@Component
public class InitDataBase implements CommandLineRunner {
    private final MovieRepository movieRepository;
    private final CopyRepository copyRepository;
    private final UserRepository userRepository;
    private final RoleService roleService;

    public InitDataBase(final MovieRepository movieRepository, final CopyRepository copyRepository,
                        final UserRepository userRepository, RoleService roleService) {
        this.movieRepository = movieRepository;
        this.copyRepository = copyRepository;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }


    @Override
    public void run(String... args) throws Exception {
        initAction();
        initAdventure();
        initComedy();
        initCartoons();
        initWesterns();
        initHorrors();
        initDramas();
        initSciFi();
        initFantasy();
        initDocumentary();
//        initCopies();
        initUsers();
    }

    public void initAction() {
        List<Movie> movies = new LinkedList<>();

        Movie movie1 = Movie.builder()
                .title("Where Eagles Dare")
                .director("Brian G. Hutton")
                .releaseDate(LocalDate.of(1968, 12, 4))
                .genre(Genre.ACTION)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie1);
        movie1.setCopies(new LinkedHashSet<>());
        movies.add(movie1);

        Movie movie2 = Movie.builder()
                .title("The Gentlemen")
                .director("Guy Ritchie")
                .releaseDate(LocalDate.of(2020, 2, 14))
                .genre(Genre.ACTION)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie2);
        movie2.setCopies(new LinkedHashSet<>());
        movies.add(movie2);

        Movie movie3 = Movie.builder()
                .title("Logan")
                .director("James Mangold")
                .releaseDate(LocalDate.of(2017, 3, 1))
                .genre(Genre.ACTION)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie3);
        movie3.setCopies(new LinkedHashSet<>());
        movies.add(movie3);

        Movie movie4 = Movie.builder()
                .title("Dead Pool 2")
                .director("David Leitch")
                .releaseDate(LocalDate.of(2018, 5, 1))
                .genre(Genre.ACTION)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }



    }

    public void initHorrors(){

        List<Movie> movies = new LinkedList<>();


        Movie movie1 = Movie.builder()
                .title("SINISTER")
                .director("Scott Derrickson")
                .releaseDate(LocalDate.of(2012, 03, 2))
                .genre(Genre.HORROR)
                .description("Autor powieści kryminalnych po przeprowadzce znajduje na strychu projektor ze " +
                        "starymi taśmami.")
                .build();
        movieRepository.save(movie1);
        movie1.setCopies(new LinkedHashSet<>());
        movies.add(movie1);

        Movie movie2 = Movie.builder()
                .title("The Shining")
                .director("Stanley Kubrick")
                .releaseDate(LocalDate.of(1980, 05, 23))
                .genre(Genre.HORROR)
                .description("Here Comes Jonny")
                .build();
        movieRepository.save(movie2);
        movie2.setCopies(new LinkedHashSet<>());
        movies.add(movie2);

        Movie movie3 = Movie.builder()
                .title("The Vampire Chronicles")
                .director("Neil Jordan")
                .releaseDate(LocalDate.of(1995, 01, 20))
                .genre(Genre.HORROR)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie3);
        movie3.setCopies(new LinkedHashSet<>());
        movies.add(movie3);
        Movie movie4 = Movie.builder()
                .title("LIGHTHOUSE")
                .director("Robert Eggers")
                .releaseDate(LocalDate.of(2019, 10, 18))
                .genre(Genre.HORROR)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }
    }

    public void initCartoons() {
        List<Movie> movies = new LinkedList<>();

        Movie movie1 = Movie.builder()
                .title("Coco")
                .genre(Genre.CARTOON)
                .director("Adrian Molina")
                .releaseDate(LocalDate.of(2017, 10, 27))
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie1);
        movie1.setCopies(new LinkedHashSet<>());
        movies.add(movie1);

        Movie movie2 = Movie.builder()
                .title("The Lion King")
                .genre(Genre.CARTOON)
                .director("Jon Favreau")
                .releaseDate(LocalDate.of(2019, 7, 9))
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie2);
        movie2.setCopies(new LinkedHashSet<>());
        movies.add(movie2);

        Movie movie3 = Movie.builder()
                .title("Zootopia")
                .genre(Genre.CARTOON)
                .director("Byron Howard")
                .releaseDate(LocalDate.of(2016, 2, 19))
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie3);
        movie3.setCopies(new LinkedHashSet<>());
        movies.add(movie3);

        Movie movie4 = Movie.builder()
                .title("Shrek")
                .genre(Genre.CARTOON)
                .director("Andrew Adamson")
                .releaseDate(LocalDate.of(2001, 7, 13))
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }


    }

    public void initWesterns() {

        List<Movie> movies = new LinkedList<>();

        Movie movie4 = Movie.builder()
                .title("The good, the bad and the ugly")
                .genre(Genre.WESTERN)
                .director("Sergio Leone")
                .releaseDate(LocalDate.of(1966, 12, 12))
                .description("just good western")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        Movie movie5 = Movie.builder()
                .title("The Comancheros")
                .genre(Genre.WESTERN)
                .director("Michael Curtiz")
                .releaseDate(LocalDate.of(1961, 1, 12))
                .description("John Wayne Western")
                .build();
        movieRepository.save(movie5);
        movie5.setCopies(new LinkedHashSet<>());
        movies.add(movie5);

        Movie movie6 = Movie.builder()
                .title("The Comancheros")
                .genre(Genre.WESTERN)
                .director("Michael Curtiz")
                .releaseDate(LocalDate.of(1961, 1, 12))
                .description("John Wayne Western")
                .build();
        movieRepository.save(movie6);
        movie6.setCopies(new LinkedHashSet<>());
        movies.add(movie6);

        Movie movie7 = Movie.builder()
                .title("Unforgiven")
                .genre(Genre.WESTERN)
                .director("Clint Eastwood")
                .releaseDate(LocalDate.of(1992, 1, 12))
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie7);
        movie7.setCopies(new LinkedHashSet<>());
        movies.add(movie7);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }

    }

    public void initDramas() {

        List<Movie> movies = new LinkedList<>();

        Movie movie1 = Movie.builder()
                .title("The Big Blue")
                .director("Luc Besson")
                .releaseDate(LocalDate.of(1988, 1, 1))
                .genre(Genre.DRAMA)
                .description("Wielki błękit (fr. Le grand bleu, ang. The Big Blue) – francusko-amerykańsko-włoski " +
                        "dramat obyczajowy z 1988 r. w reżyserii Luca Bessona")
                .build();
        movieRepository.save(movie1);
        movie1.setCopies(new LinkedHashSet<>());
        movies.add(movie1);

        Movie movie2 = Movie.builder()
                .title("The Shawshank Redemption")
                .director("Frank Darabont")
                .releaseDate(LocalDate.of(1995, 4, 16))
                .genre(Genre.DRAMA)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie2);
        movie2.setCopies(new LinkedHashSet<>());
        movies.add(movie2);

        Movie movie3 = Movie.builder()
                .title("Intouchables")
                .director("Eric Toledano")
                .releaseDate(LocalDate.of(2012, 4, 13))
                .genre(Genre.DRAMA)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie3);
        movie3.setCopies(new LinkedHashSet<>());
        movies.add(movie3);

        Movie movie4 = Movie.builder()
                .title("The Godfather")
                .director("Francis Ford Coppola")
                .releaseDate(LocalDate.of(1972, 12, 31))
                .genre(Genre.DRAMA)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }
    }

    public void initComedy() {
        List<Movie> movies = new LinkedList<>();

        Movie movie1 = Movie.builder()
                .title("Forrest Gump")
                .director("Robert Zemeckis")
                .releaseDate(LocalDate.of(1994, 11, 4))
                .genre(Genre.COMEDY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie1);
        movie1.setCopies(new LinkedHashSet<>());
        movies.add(movie1);


        Movie movie2 = Movie.builder()
                .title("La vita è bella")
                .director("Roberto Benigni")
                .releaseDate(LocalDate.of(1999, 3, 12))
                .genre(Genre.COMEDY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie2);
        movie2.setCopies(new LinkedHashSet<>());
        movies.add(movie2);

        Movie movie3 = Movie.builder()
                .title("Green Book")
                .director("Peter Farrelly")
                .releaseDate(LocalDate.of(2018, 11, 21))
                .genre(Genre.COMEDY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie3);
        movie3.setCopies(new LinkedHashSet<>());
        movies.add(movie3);

        Movie movie4 = Movie.builder()
                .title("City Lights")
                .director("Charlie Chaplin")
                .releaseDate(LocalDate.of(2013, 6, 21))
                .genre(Genre.COMEDY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }



    }

    public void initDocumentary() {
        List<Movie> movies = new LinkedList<>();

        Movie movie1 = Movie.builder()
                .title("David Attenborough: A Life On Our Planet")
                .director("Netflix")
                .releaseDate(LocalDate.of(2020, 10, 4))
                .genre(Genre.DOCUMENTARY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie1);
        movie1.setCopies(new LinkedHashSet<>());
        movies.add(movie1);

        Movie movie2 = Movie.builder()
                .title("Le sel de la terre")
                .director("Wim Wenders")
                .releaseDate(LocalDate.of(2014, 10, 15))
                .genre(Genre.DOCUMENTARY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie2);
        movie2.setCopies(new LinkedHashSet<>());
        movies.add(movie2);

        Movie movie3 = Movie.builder()
                .title("Samsara")
                .director("Ron Fricke")
                .releaseDate(LocalDate.of(2012, 10, 19))
                .genre(Genre.DOCUMENTARY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie3);
        movie3.setCopies(new LinkedHashSet<>());
        movies.add(movie3);

        Movie movie4 = Movie.builder()
                .title("Baraka")
                .director("Ron Fricke")
                .releaseDate(LocalDate.of(2005, 6, 10))
                .genre(Genre.DOCUMENTARY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }

    }

    public void initSciFi() {
        List<Movie> movies = new LinkedList<>();

        Movie movie1 = Movie.builder()
                .title("Inception")
                .director("Christopher Nolan")
                .releaseDate(LocalDate.of(2010, 7, 30))
                .genre(Genre.SCI_FI)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie1);
        movie1.setCopies(new LinkedHashSet<>());
        movies.add(movie1);

        Movie movie2 = Movie.builder()
                .title("Avengers: Infinity War")
                .director("Joe Russo")
                .releaseDate(LocalDate.of(2016, 4, 26))
                .genre(Genre.SCI_FI)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie2);
        movie2.setCopies(new LinkedHashSet<>());
        movies.add(movie2);

        Movie movie3 = Movie.builder()
                .title("Star Wars: Episode V - The Empire Strikes Back")
                .director("Irvin Kershner")
                .releaseDate(LocalDate.of(1983, 4, 26))
                .genre(Genre.SCI_FI)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie3);
        movie3.setCopies(new LinkedHashSet<>());
        movies.add(movie3);

        Movie movie4 = Movie.builder()
                .title("The Dark Knight")
                .director("Christopher Nolan")
                .releaseDate(LocalDate.of(2008, 8, 2))
                .genre(Genre.SCI_FI)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }
    }

    public void initFantasy() {
        List<Movie> movies = new LinkedList<>();


        Movie movie4 = Movie.builder()
                .title("The Lord of the Rings: The Return of the King")
                .director("Peter Jackson")
                .releaseDate(LocalDate.of(2004, 1, 1))
                .genre(Genre.FANTASY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        Movie movie5 = Movie.builder()
                .title("The Lord of the Rings: The Two Towers")
                .director("Peter Jackson")
                .releaseDate(LocalDate.of(2003, 1, 31))
                .genre(Genre.FANTASY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie5);
        movie5.setCopies(new LinkedHashSet<>());
        movies.add(movie5);

        Movie movie6 = Movie.builder()
                .title("The Lord of the Rings: The Fellowship of the Ring")
                .director("Peter Jackson")
                .releaseDate(LocalDate.of(2002, 2, 15))
                .genre(Genre.FANTASY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie6);
        movie6.setCopies(new LinkedHashSet<>());
        movies.add(movie6);

        Movie movie7 = Movie.builder()
                .title("How to Train Your Dragon")
                .director("Chris Sanders")
                .releaseDate(LocalDate.of(2010, 4, 10))
                .genre(Genre.FANTASY)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie7);
        movie7.setCopies(new LinkedHashSet<>());
        movies.add(movie7);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }

    }

    public void initAdventure() {
        List<Movie> movies = new LinkedList<>();

        Movie movie1 = Movie.builder()
                .title("Into the Wild")
                .director("Jon Krakauer")
                .releaseDate(LocalDate.of(2008, 4, 4))
                .genre(Genre.ADVENTURE)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie1);
        movie1.setCopies(new LinkedHashSet<>());
        movies.add(movie1);

        Movie movie2 = Movie.builder()
                .title("Jak rozpętałem drugą wojnę światową")
                .director("Tadeusz Chmielewski")
                .releaseDate(LocalDate.of(1970, 4, 2))
                .genre(Genre.ADVENTURE)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie2);
        movie2.setCopies(new LinkedHashSet<>());
        movies.add(movie2);

        Movie movie3 = Movie.builder()
                .title("L'Ours")
                .director("Jean-Jacques Annaud")
                .releaseDate(LocalDate.of(1988, 10, 19))
                .genre(Genre.ADVENTURE)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie3);
        movie3.setCopies(new LinkedHashSet<>());
        movies.add(movie3);

        Movie movie4 = Movie.builder()
                .title("The Secret of Kells")
                .director("Tomm Moore")
                .releaseDate(LocalDate.of(2009, 2, 11))
                .genre(Genre.ADVENTURE)
                .description("Lorem Ipsum")
                .build();
        movieRepository.save(movie4);
        movie4.setCopies(new LinkedHashSet<>());
        movies.add(movie4);

        for (Movie movieElement :
                movies) {
            Copy copy = Copy.builder().movie(movieElement).build();
            copyRepository.save(copy);
            movieElement.getCopies().add(copy);
            movieRepository.save(movieElement);
        }

    }



//    public void initCopies() {
//        Movie movie1 = movieRepository.findById(1L).orElse(null);
//
//        Copy copy1 = Copy.builder().movie(movie1).build();
//        copyRepository.save(copy1);
//        movie1.getCopies().add(copy1);
//        movieRepository.save(movie1);
//        Movie movie2 = movieRepository.findById(2L).orElse(null);
//
//        Copy copy2 = Copy.builder().movie(movie2).build();
//        copyRepository.save(copy2);
//        movie2.getCopies().add(copy2);
//        movieRepository.save(movie2);
//        Movie movie3 = movieRepository.findById(3L).orElse(null);
//
//        Copy copy3 = Copy.builder().movie(movie3).build();
//        copyRepository.save(copy3);
//        movie3.getCopies().add(copy3);
//        movieRepository.save(movie3);
//        Movie movie4 = movieRepository.findById(4L).orElse(null);
//
//        Copy copy4 = Copy.builder().movie(movie4).build();
//        copyRepository.save(copy4);
//        movie4.getCopies().add(copy4);
//        movieRepository.save(movie4);
//
//        Copy copy5 = Copy.builder().movie(movie4).build();
//        copyRepository.save(copy5);
//        movie4.getCopies().add(copy5);
//        movieRepository.save(movie4);
//
//        Copy copy6 = Copy.builder().movie(movie4).build();
//        copyRepository.save(copy6);
//        movie4.getCopies().add(copy6);
//        movieRepository.save(movie4);
//    }


    public void initUsers() {
        Role role1 = new Role();
        role1.setName("USER");
        role1 = roleService.save(role1);

        Role role2 = new Role();
        role2.setName("ADMIN");
        role2 = roleService.save(role2);

        List<Role> list1 = new LinkedList<>();
        list1.add(role1);
        List<Role> list2 = new LinkedList<>();
        list2.add(role2);

        //user
        User user1 = User.builder()
                .firstName("John")
                .lastName("Krasinski")
                .email("john.krasinski@poczta.pl")
                .password("$2a$10$gQuB16dflwFLHC/eo1PiUeYJE.XOAeqNtvmkaqtk6rWqIJMn279Ly")
                .userType(UserType.GOLD)
                .build();
        user1.setRoles(list1);

        userRepository.save(user1);

        //admin
        User user2 = User.builder()
                .firstName("Roman")
                .lastName("Polanski")
                .email("roman.polanski@poczta.pl")
                .password("$2a$10$gQuB16dflwFLHC/eo1PiUeYJE.XOAeqNtvmkaqtk6rWqIJMn279Ly")
                .userType(UserType.SILVER)
                .build();
        user2.setRoles(list2);
        userRepository.save(user2);

        //user
        User user3 = User.builder()
                .firstName("Luke")
                .lastName("Skywalker")
                .email("luke.starKiller@vader.com")
                .password("$2a$10$gQuB16dflwFLHC/eo1PiUeYJE.XOAeqNtvmkaqtk6rWqIJMn279Ly")
                .userType(UserType.PLATINUM)
                .build();
        user3.setRoles(list1);
        userRepository.save(user3);

        //user
        User user4 = User.builder()
                .firstName("Amadeusz")
                .lastName("Mozart")
                .email("amadeusz.mozart@poczta.de")
                .password("$2a$10$gQuB16dflwFLHC/eo1PiUeYJE.XOAeqNtvmkaqtk6rWqIJMn279Ly")
                .userType(UserType.GOLD)
                .build();
        user4.setRoles(list1);

        //no role
        userRepository.save(user4);
        User user5 = User.builder()
                .firstName("awfsa")
                .lastName("fasfas")
                .email("aaa.aaa@poczta.de")
                .password("$2a$10$gQuB16dflwFLHC/eo1PiUeYJE.XOAeqNtvmkaqtk6rWqIJMn279Ly")
                .userType(UserType.GOLD)
                .build();

        userRepository.save(user5);
    }


}