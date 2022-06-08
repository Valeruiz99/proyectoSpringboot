package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Controllers;

import java.util.Map;

import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity.EncabezadoPedido;
import com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Service.IEncabezadoPedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EncabezadoPedidoController {

    @Autowired
    private IEncabezadoPedidoService encabezadoPedidoService;

    @GetMapping("/listarpedido")
    public String listar(Model model){
        model.addAttribute("titulo", "Encabezado de Pedidos");
        model.addAttribute("encabezadoPedido", encabezadoPedidoService.findAll());

        return "listarpedido";
    }

    @GetMapping("/formpedido")
    public String crear(Map<String,Object>model){
        EncabezadoPedido encabezadoPedido = new EncabezadoPedido();
        model.put("encabezadoPedido", encabezadoPedido);
        model.put("titulo", "Formulario de pedidos");
        return "formpedido";
    }

    @GetMapping("/formpedido/{idEncabezadoPedido}")
    public String editar(@PathVariable Long idEncabezadoPedido, Map<String,Object>model){
        EncabezadoPedido encabezadoPedido = null;

        if(idEncabezadoPedido > 0){
            encabezadoPedido = encabezadoPedidoService.findOne(idEncabezadoPedido);
        }else{
            return "redirect:/listarpedido";
        }
        model.put("encabezadoPedido", encabezadoPedido);
        model.put("titulo", "Editar pedido");
        return "formpedido";
    }
    @GetMapping("/eliminarPedidos/idEncabezadoPedido")
    public String eliminar(@PathVariable Long idEncabezadoPedido){
        if(idEncabezadoPedido > 0)
            encabezadoPedidoService.deletePedidos(idEncabezadoPedido);
        
        return "redirect:/listarpedido";
    }
}
