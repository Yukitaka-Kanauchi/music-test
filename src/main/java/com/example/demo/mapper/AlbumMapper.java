package com.example.demo.mapper;

import com.example.demo.entity.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

@Mapper
public interface AlbumMapper {
    //@Select("SELECT title FROM wa ORDER BY RANDOM()")
    //List<Album> selectAllAlbums();
    @Select("SELECT * FROM albums")
    List<Album> selectAllAlbums();

    @Insert("INSERT INTO albums (title, artist_int, release_date) VALUES (#{title}, #{artistInt}, #{releaseDate})")
    @Options(useGeneratedKeys = true, keyProperty = "albumId")
    void insertAlbum(Album album);

    @Select("SELECT * FROM albums WHERE album_id = #{albumId}")
    Album selectAlbumById(long albumId);

    @Delete("DELETE FROM albums WHERE album_id = #{albumId}")
    void deleteAlbumById(long albumId);

    @Update("UPDATE albums SET title = #{title}, artist_int = #{artistInt}, release_date = #{releaseDate} WHERE album_id = #{albumId}")
    void updateAlbum(Album album);

    @Select("SELECT * FROM wa ORDER BY RANDOM() LIMIT 1")
    List<Album> japaneseFoodDisplay();

    @Select("SELECT * FROM you ORDER BY RANDOM() LIMIT 1")
    List<Album> westernFoodDisplay();

    @Select("SELECT * FROM tyu ORDER BY RANDOM() LIMIT 1")
    List<Album> chineseFoodDisplay();
}