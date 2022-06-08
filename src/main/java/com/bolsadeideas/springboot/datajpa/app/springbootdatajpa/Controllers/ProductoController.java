package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Controllers;

import java.util.Map;

import javax.validation.Valid;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Producto;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service.IProductoService;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listarProductos")
    public String listar(Model model){

        model.addAttribute("titulo", "Lista de productos");
        model.addAttribute("producto", productoService.findAll());

        return "listarProductos";
    }

    @GetMapping("/formProductos")
    public String crear(Map<String,Object>model){
        Producto producto = new Producto();
        model.put("producto", producto);
        model.put("titulo", "Formulario de productos");
        return "formProductos";
    }

    @RequestMapping(value = "/formProductos", method = RequestMethod.POST)
    public String guardar(@Valid Producto producto,BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("titulo", "Error en el formulario de productos");

            return "formProductos";
        }
        productoService.save(producto);
        return "redirect:listarProductos";
    }

    @GetMapping("/formProductos/{id}")
    public String editar(@PathVariable Long id, Map<String,Object>model){

        Producto producto = null;

        if (id>0){
            producto = productoService.findOne(id);
        }else{
            return "redirect:/listarProductos";
        }
        model.put("producto", producto);
        model.put("titulo", "Editar Producto");
        return "formProductos";
    }

    @GetMapping("/eliminarProductos/{id}")
    public String eliminar(@PathVariable Long id){

        if (id>0)
            productoService.deleteProductos(id);

        return "redirect:/listarProductos";
    }
    
}
