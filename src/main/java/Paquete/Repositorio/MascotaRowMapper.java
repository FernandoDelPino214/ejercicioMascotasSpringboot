package Paquete.Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Paquete.Modelos.Dueno;
import Paquete.Modelos.Mascota;

public class MascotaRowMapper implements RowMapper<Mascota> {

    @Override
    public Mascota mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dueno dueno = new Dueno();
        dueno.setDni(rs.getString("dniD"));
        dueno.setNombre(rs.getString("nomD"));
        
        Mascota mascota = new Mascota();
        mascota.setDueno(dueno);
        mascota.setCodigo(rs.getInt("codigo"));
        mascota.setNumChip(rs.getInt("numChip"));
        mascota.setNombre(rs.getString("nombreM"));
        mascota.setCorrienteVacunacion(rs.getBoolean("corrVac"));
        return mascota;
    }
    
}
