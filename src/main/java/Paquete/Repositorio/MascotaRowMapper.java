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
        dueno.setDni(rs.getString("d.dni"));
        dueno.setNombre(rs.getString("d.nombre"));
        Mascota mascota = new Mascota();
        mascota.setDueno(dueno);
        mascota.setCodigo(rs.getInt("m.codigo"));
        mascota.setNumChip(rs.getInt("m.num_chip"));
        mascota.setNombre(rs.getString("m.nombre"));
        mascota.setCorrienteVacunacion(rs.getBoolean("m.corriente_vacunacion"));
        return mascota;
    }
    
}
