package com.jm.eitec_back.rest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jm.eitec_back.entity.Caja;
import com.jm.eitec_back.entity.Pedido;
import com.jm.eitec_back.entity.Usuario;
import com.jm.eitec_back.services.CajaService;
import com.jm.eitec_back.services.PedidoService;
import com.jm.eitec_back.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/pedido")
@CrossOrigin(origins = "*")
public class PedidoRest {

    @Autowired
    private PedidoService pedidoService;

    private UsuarioService usuarioService;

    @Autowired
    private CajaService cajaService;

    @GetMapping("/listar")
    public List<Pedido> porEntregar(){

        return pedidoService.listAll();
    }

    @PostMapping("/registrar")
    public String guardar(@RequestBody Pedido pedido) {

        Usuario user = usuarioService.findById(pedido.getUsuarioId());
        pedido.setTotal(0.0);
        pedidoService.save(pedido);

        user.agregar(pedido);
        usuarioService.save(user);

        return "Se registro su pedido";
    }

    @PostMapping("/addCajaPedido")
    public String agregarCajaPedido(@RequestParam("idcaja") Long idcaja,
                                    @RequestParam("idpedido") Long idpedido) {

        try {

            Pedido pedido = pedidoService.findById(idpedido);
            Caja caja = cajaService.findById(idcaja);
            pedido.agregar(caja);
            pedido.setTotal(pedido.getTotal() + caja.getPrecio());
            pedidoService.save(pedido);

            return "Se agrego la caja a su pedido";

        } catch (Exception e) {
            // TODO: handle exception
            return "Error es posible que la caja o el pedido tengan algun defecto o no existan";
        }


    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

}
