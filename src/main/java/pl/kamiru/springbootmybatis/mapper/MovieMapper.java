package pl.kamiru.springbootmybatis.mapper;

import org.apache.ibatis.annotations.*;
import pl.kamiru.springbootmybatis.model.Movie;

import java.util.List;

@Mapper
public interface MovieMapper {

    @Insert("INSERT INTO Movie (name, year, rating) VALUES(#{name},#{year},#{rating})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Movie movie);

    @Update("UPDATE Movie SET name=#{name}, year=#{year}, rating=#{rating} WHERE id=#{id}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean update(Movie movie);

    @Select("SELECT id, name, year, rating FROM Movie WHERE id=#{id}")
    Movie findById(long id);

    @Select("SELECT id, name, year, rating FROM Movie")
    List<Movie> findAll();
}
