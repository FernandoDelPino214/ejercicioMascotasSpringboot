package Paquete.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class IndexControlador {
    
    @RequestMapping("/")
    public String inicio(){

        return "index";
    }
}
