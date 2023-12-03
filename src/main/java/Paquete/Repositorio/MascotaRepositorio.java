package Paquete.Repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Paquete.Modelos.*;

@Repository
public class MascotaRepositorio {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Mascota> getTodasMascotas(){
        List<Mascota> listaMascotas = jdbcTemplate.query(
            "SELECT m.codigo AS codigo, m.num_chip AS numChip, m.nombre AS nombreM, m.corriente_vacunacion AS corrVac, d.dni AS dniD, d.nombre_apellidos AS nomD FROM mascota AS m, dueno AS d WHERE m.dni_dueno = d.dni",
            new MascotaRowMapper());
        return listaMascotas;
    }

    public Mascota getMascotaPorCodigo(int codigoMascota){
        String query = "SELECT m.codigo AS codigo, m.num_chip AS numChip, m.nombre AS nombreM, m.corriente_vacunacion AS corrVac, d.dni AS dniD, d.nombre_apellidos AS nomD FROM mascota m, dueno d WHERE m.dni_dueno = d.dni AND m.codigo = ?";
        List<Mascota> listaMascotas = jdbcTemplate.query(query, new MascotaRowMapper(), codigoMascota);
        return (listaMascotas.isEmpty())? null: listaMascotas.get(0);
    }

    public List<Mascota> getMascotasPorDueno(Dueno dueno){
        List<Mascota> listaMascotas = jdbcTemplate.query(
            "SELECT m.codigo, m.num_chip, m.nombre, m.corriente_vacunacion, d.dni, d.nombre_apellidos FROM mascota m, dueno d WHERE m.dni_dueno = d.dni AND d.dni = ?",
            new MascotaRowMapper(), dueno.getDni());
        return listaMascotas;
    }

    public void eliminarMascota(Mascota mascota){
        String query = "DELETE FROM mascota m WHERE m.codigo = ?";
        jdbcTemplate.update(query, mascota.getCodigo());
    }

    public void actualizarMascota(Mascota mascota){
        String query = "UPDATE mascota SET num_chip = ?, nombre = ?, corriente_vacunacion = ?, dni_dueno = ? WHERE codigo = ?";
        jdbcTemplate.update(query,
            mascota.getNumChip(), mascota.getNombre(), mascota.getCorrienteVacunacion(), mascota.getDueno().getDni(), mascota.getCodigo());
    }

    public void insertarMascota(Mascota mascota){
        String query = "INSERT INTO mascota (num_chip, nombre, corriente_vacunacion, dni_dueno) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(query, mascota.getNumChip(), mascota.getNombre(), mascota.getCorrienteVacunacion(), mascota.getDueno().getDni().toString());
    }
}
