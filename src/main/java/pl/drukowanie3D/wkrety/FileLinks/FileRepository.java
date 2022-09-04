package pl.drukowanie3D.wkrety.FileLinks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.drukowanie3D.wkrety.FileLinks.File;

import java.util.List;

@Repository
public class FileRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<File> getAll(){
        /// to juz zwraca liste dlatego wystarczy query =
        List<File>  query= jdbcTemplate.query("select id, wymiar1, wymiar2, wymiar3, linktofile from request2 where status =1",
                BeanPropertyRowMapper.newInstance(File.class));  // wyciagamy dane z bazy selectem i pakujemy do obiektu request

        return query;
    }

}
