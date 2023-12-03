package Paquete.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Paquete.Modelos.*;
import Paquete.Repositorio.DuenoRepositorio;

@Controller
public class DuenoControlador {
    
    @Autowired
    private DuenoRepositorio duenoRepositorio;

    @RequestMapping("/listaDuenos")
    public String listadoDuenos(Model model){
        List<Dueno> listaDuenos = duenoRepositorio.getTodosDuenos();
        model.addAttribute("listaDuenos", listaDuenos);
        return "listaDuenos";
    }

    @RequestMapping("/formModificarDueno/{dni}")
    public String formModificadoDueno(@PathVariable String dni, Model model){
        Dueno dueno = duenoRepositorio.getDuenoPorDni(dni);
        if (dueno != null) {
            model.addAttribute("dueno", dueno);
            return "formModificarDueno";
        }
        else{
            return "paginaError";
        }   
    }

    @RequestMapping("/formInsertarDueno")
    public String formInsertadoDueno(Model model){
        Dueno dueno = new Dueno();
        model.addAttribute("dueno", dueno);
        return "formDueno";
    }

    @RequestMapping("/insertarDueno")
    public String insertarNuevoDueno(Dueno dueno, Model model){
        System.out.println(dueno.getDni() + ", " + dueno.getNombre());
        duenoRepositorio.crearDueno(dueno);
        return listadoDuenos(model);
    }

    @RequestMapping("/actualizarDueno")
    public String actualizarDueno(Dueno dueno, Model model){
        System.out.println(dueno.getDni() + ", " + dueno.getNombre());
        duenoRepositorio.actualizarDueno(dueno);
        return listadoDuenos(model);
    }

    @RequestMapping("/avisoEliminarDueno/{dni}")
    public String avisoEliminarDueno(@PathVariable String dni, Model model){
        Dueno dueno = duenoRepositorio.getDuenoPorDni(dni);
        if (dueno != null) {
            model.addAttribute("dueno", dueno);
            return "avisoEliminarDueno";
        }
        else{
            return "paginaError";
        }   
    }

    @RequestMapping("/eliminarDueno/{dni}")
    public String eliminarDueno(@PathVariable String dni, Model model){
        Dueno dueno = duenoRepositorio.getDuenoPorDni(dni);
        if (dueno != null) {
            duenoRepositorio.eliminarDueno(dueno);
            return listadoDuenos(model);
        }
        else{
            return "paginaError";
        }   
    }

    public List<Dueno> getTodosDuenos(){
        return duenoRepositorio.getTodosDuenos();
    }

    public Dueno getDuenoPorDni(String dni){
        return duenoRepositorio.getDuenoPorDni(dni);
    }
}
