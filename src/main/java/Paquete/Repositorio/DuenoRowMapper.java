package Paquete.Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Paquete.Modelos.Dueno;

public class DuenoRowMapper implements RowMapper<Dueno>{

    @Override
    public Dueno mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Dueno dueno = new Dueno(resultSet.getString("dni"), resultSet.getString("nombre"));
        return dueno;
    }
    
}
