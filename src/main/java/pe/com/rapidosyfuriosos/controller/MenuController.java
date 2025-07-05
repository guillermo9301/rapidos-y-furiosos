// MenuController.java
package pe.com.rapidosyfuriosos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    @GetMapping("/menuprincipal")
    public String mostrarMenu(Model model) {
        model.addAttribute("entidades", List.of(
                new MenuItem("Clientes", "/cliente/vista"),
                new MenuItem("Empleados", "/empleado/vista"),
                new MenuItem("Distrito", "/distrito/vista"),
                new MenuItem("Color", "/color/vista"),
                new MenuItem("Marca", "/marca/vista"),
                new MenuItem("Rol", "/rol/vista"),
                new MenuItem("Sexo", "/sexo/vista"),
                new MenuItem("Vehiculos", "/vehiculo/vista")
        ));
        return "menuprincipal";
    }

    @GetMapping("/")
    public String redireccionarInicio() {
        return "redirect:/menuprincipal";
    }

    // Clase interna para representar ítems del menú
    public record MenuItem(String nombre, String url) {}
}