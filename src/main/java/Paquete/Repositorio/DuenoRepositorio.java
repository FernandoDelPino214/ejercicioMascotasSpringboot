package Paquete.Repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Paquete.Modelos.Dueno;

@Repository
public class DuenoRepositorio {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    
    public List<Dueno> getTodosDuenos(){
        String query = "SELECT * FROM dueno;";
        List<Dueno> listaDuenos = jdbcTemplate.query(query, new DuenoRowMapper());
        return listaDuenos;
    }
    
    public Dueno getDuenoPorDni(String dni){
        String query = "SELECT * FROM dueno d WHERE d.dni = ?";
        List<Dueno> listaDuenos = jdbcTemplate.query(query, new DuenoRowMapper(), dni);
        return (listaDuenos.isEmpty())? null: listaDuenos.get(0);
    }

    public void eliminarDueno(Dueno dueno){
        String query = "DELETE FROM dueno d WHERE d.dni = ?";
        jdbcTemplate.update(query, dueno.getDni());
    }

    public void actualizarDueno(Dueno dueno){
        String query = "UPDATE dueno SET nombre_apellidos = ? WHERE dni = ?";
        jdbcTemplate.update(query, dueno.getNombre(), dueno.getDni());
    }

    public void crearDueno(Dueno dueno){
        String query = "INSERT INTO dueno (dni, nombre_apellidos) VALUES (?, ?)";
        jdbcTemplate.update(query, dueno.getDni(), dueno.getNombre());
    }
}
