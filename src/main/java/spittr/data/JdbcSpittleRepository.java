package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcSpittleRepository(JdbcOperations jdbc) {
        super();
        this.jdbc = jdbc;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return jdbc.query("select id, message, created_at, latitude, longitude" + " from Spittle" + " where id < ?"
                + " order by created_at desc limit 20", new SpittleRowMapper(), max);
    }

    private static class SpittleRowMapper implements RowMapper<Spittle> {

        @Override
        public Spittle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Spittle(resultSet.getLong("id"), resultSet.getString("message"),
                    resultSet.getTimestamp("created_at").toLocalDateTime(), resultSet.getDouble("longitude"),
                    resultSet.getDouble("latitude"));
        }

    }

    @Override
    public Spittle findOne(long id) {
        return jdbc.queryForObject("select id, message, created_at, latitude, longitude from Spittle where id = ?",
                new SpittleRowMapper(), id);
    }

}
