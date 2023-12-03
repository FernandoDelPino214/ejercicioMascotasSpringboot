package Paquete.Controladores;

import Paquete.Modelos.Mascota;
import Paquete.Modelos.Dueno;
import Paquete.Repositorio.MascotaRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MascotaControlador {
    
    @Autowired
    private MascotaRepositorio mascotaRepositorio;

    @Autowired
    private DuenoControlador duenoControlador;

    @RequestMapping("/listaMascotas")
    public String listaMascotas(Model model){
        List<Mascota> listaMascotas = mascotaRepositorio.getTodasMascotas();
        model.addAttribute("listaMascotas", listaMascotas);
        return "listaMascotas";
    }

    @RequestMapping("/formMascota")
    public String formInsertarMascota(Model model){
        Mascota mascota = new Mascota();
        model.addAttribute("nuevaMascota", mascota);
        model.addAttribute("listaDuenos", duenoControlador.getTodosDuenos());
        return "formMascota";
    }

    @RequestMapping("/insertarMascota")
    public String insertarMascota(Mascota mascota, @RequestParam String dniDueno, Model model){
        Dueno dueno = duenoControlador.getDuenoPorDni(dniDueno);
        mascota.setDueno(dueno);
        mascotaRepositorio.insertarMascota(mascota);
        return listaMascotas(model);
    }

    @RequestMapping("/formModificarMascota/{codigo}")
    public String formModificarMascota(Model model, @PathVariable String codigo){
        Mascota mascota = mascotaRepositorio.getMascotaPorCodigo(Integer.parseInt(codigo));
        model.addAttribute("mascota", mascota);
        model.addAttribute("listaDuenos", duenoControlador.getTodosDuenos());
        return "formModificarMascota";
    }

    @RequestMapping("/actualizarMascota")
    public String actualizarMascota(Mascota mascota, @RequestParam String dniDueno, Model model){
        Dueno dueno = duenoControlador.getDuenoPorDni(dniDueno);
        mascota.setDueno(dueno);
        mascotaRepositorio.actualizarMascota(mascota);
        return listaMascotas(model);
    }

    @RequestMapping("/eliminarMascota/{codigo}")
    public String eliminarMascota(@PathVariable String codigo, Model model){
        Mascota mascota = mascotaRepositorio.getMascotaPorCodigo(Integer.parseInt(codigo));
        mascotaRepositorio.eliminarMascota(mascota);
        return listaMascotas(model);
    }
}
