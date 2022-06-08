package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Controllers;

import java.util.Map;

import javax.validation.Valid;

//import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Dao.IClienteDao;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.Cliente;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {
    
    @Autowired//Marca que esta instancia se está conectando al Query(a la consulta) para generar una vista.
    private IClienteService clienteService;
    /*@Qualifier("ClienteDaoJPA")//Este me identifica el repository.
    private IClienteDao ClienteDao;//Instancia*/

    @GetMapping("/listar")//Es para entrar al método por medio de la url
    public String listar(Model model){//Manipulación de los datos

        model.addAttribute("titulo", "listado de clientes");
        model.addAttribute("clientes", clienteService.findAll());

        return "listar";
    }   

    @GetMapping("/form")
    public String crear(Map<String,Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);//Con el string comunica con la variable del html
        model.put("titulo", "formulario de cliente");
        return "form";
    }

    //@PostMapping, es una manera mas corta:
    @RequestMapping(value= "/form", method=RequestMethod.POST)//El Método Post guarda la información del formulario.
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model)
    {

        if(result.hasErrors())
        {
            model.addAttribute("titulo", "Formulario de clientes error");
            return "form";
        }

        clienteService.save(cliente);
        return "redirect:listar";
    }

    @GetMapping("/form/{id}")//El id varía, por lo tanto podemos modificar todos los usuarios
    public String editar(@PathVariable Long id,Map<String,Object> model){//Si el id en la url se llama diferente que en java, hay que ponerle in name (name=id) o con cualquier nombre que tenga la url
        
        Cliente cliente = null;//Le decimos que el cliente va a arrancar sin información previa
        
        if (id>0){
            cliente = clienteService.findOne(id);//busca el id en la tabla y lo trae
        }else{
            return "redirect:/listar";
        }
        model.put("cliente", cliente);//Con el string comunica con la variable del html
        model.put("titulo", "Editar cliente");
        return "form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){//Como es por url debe ser pathVariable

        if (id>0)
            clienteService.delete(id);

        return "redirect:/listar";
    }
}