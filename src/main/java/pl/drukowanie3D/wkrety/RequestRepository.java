package pl.drukowanie3D.wkrety;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Request> getAll(){
        /// to juz zwraca liste dlatego wystarczy query =
        List<Request>  query= jdbcTemplate.query("select id, wymiar1, wymiar2, wymiar3, nick from request2 where status =0",
                BeanPropertyRowMapper.newInstance(Request.class));  // wyciagamy dane z bazy selectem i pakujemy do obiektu request

        return query;
    }

    public int save(Request request) {

        jdbcTemplate.update("insert into request2 (wymiar1,wymiar2,wymiar3,nick) values(?,?,?,?)"
                ,request.getWymiar1(),request.getWymiar2(),request.getWymiar3(),request.getNick());


        return 200;
    }
}
