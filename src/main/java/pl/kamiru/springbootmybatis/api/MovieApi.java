package pl.kamiru.springbootmybatis.api;

import org.springframework.web.bind.annotation.*;
import pl.kamiru.springbootmybatis.mapper.MovieMapper;
import pl.kamiru.springbootmybatis.model.Movie;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieApi {

   private MovieMapper movieMapper;

   public MovieApi(MovieMapper movieMapper) {
      this.movieMapper=movieMapper;
   }

   @GetMapping
   public List<Movie> getAll() {
      return movieMapper.findAll();
   }

   @GetMapping("/id/{id}")
   public Movie getById(@PathVariable long id) {
      return movieMapper.findById(id);
   }

   @PostMapping
   public void addMovie(@RequestBody Movie movie) {
      movieMapper.insert(movie);
   }

   @PutMapping()
   public boolean updateMovie(@RequestBody Movie movie) {
      return movieMapper.update(movie);
   }
}
