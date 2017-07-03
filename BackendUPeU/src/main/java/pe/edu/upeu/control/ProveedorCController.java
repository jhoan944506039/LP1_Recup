/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.control;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pe.edu.upeu.model.Proveedor;
import pe.edu.upeu.model.Almacen;
import pe.edu.upeu.model.Cliente;
import pe.edu.upeu.model.Documentos;
import pe.edu.upeu.model.Empleado;
import pe.edu.upeu.service.ProveedorServis;
import pe.edu.upeu.service.AlmacenServis;
import pe.edu.upeu.service.ClienteServis;
import pe.edu.upeu.service.DocumentosServis;
import pe.edu.upeu.service.EmpleadoServis;

/**
 *
 * @author Alumnos
 */
@Controller
@RequestMapping("/Proveedor")
public class ProveedorCController {

    @Autowired
    ProveedorServis service;

    @Autowired
    AlmacenServis serviceAlm;

    @Autowired
    ClienteServis serviceClie;

    @Autowired
    DocumentosServis serviceDoc;

    @Autowired
    EmpleadoServis serviceEmpl;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView listProveedor(ModelMap model) {
        List<Proveedor> lista = service.listarEntidad();
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("ListaProveedor", lista);
        modelo.put("mensaje", "Reporte de Proveedor");
        modelo.put("mensaje", "Reporte de Proveedor");
        return new ModelAndView("Proveedor/mainProveedor", modelo);
    }

    @RequestMapping(value = "buscarProveedor", method = RequestMethod.POST)
    public ModelAndView buscarProveedor(HttpServletRequest r) {
        String dato = r.getParameter("dato") == null ? "" : r.getParameter("dato");
        List<Proveedor> lista = service.listarPorNombre(dato);
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("ListaProveedor", lista);
        return new ModelAndView("Proveedor/mainProveedor", modelo);
    }

    @RequestMapping(value = "eliminarProveedor", method = RequestMethod.GET)
    public ModelAndView eliminarProveedor(HttpServletRequest r) {
        int idEntidad = Integer.parseInt(r.getParameter("id"));
        service.eliminarEntidadId(idEntidad);
        System.out.println("si llego al metodo");
        return new ModelAndView(new RedirectView("list"));
    }

    @RequestMapping(value = "formProveedor", method = RequestMethod.GET)
    public ModelAndView irFormulario(@ModelAttribute("modeloProveedor") Proveedor entidad, BindingResult result) {
        Map<String, Object> modelo = new HashMap<String, Object>();
        modelo.put("listaTemporada", "Holasssssssssss");
        modelo.put("listaTemporadaX", service.listarEntidad());
        modelo.put("listaTemporada2", "");
        modelo.put("listaTemporada3", "");
        modelo.put("ListCliente", serviceClie.listarEntidad());
        modelo.put("ListAlmacen", serviceAlm.listarEntidad());
        modelo.put("ListDocumento", serviceDoc.listarEntidad());
        modelo.put("ListEmpleado", serviceEmpl.listarEntidad());
        return new ModelAndView("Proveedor/formProveedor", modelo);
    }

    @RequestMapping(value = "guardarProveedor", method = RequestMethod.POST)
    public ModelAndView guardarProveedorXX(@ModelAttribute Proveedor entidad,
            BindingResult result) {

        System.out.println("josue " + entidad.toString());
        //methodo para devolver una persona por ID
        // o puedes guardar directamente ID
       // Proveedor Proveedor = new Proveedor();
        
        service.guardarEntidad(entidad);

        return new ModelAndView(new RedirectView("list"));
    }

    @RequestMapping(value = "modificarProveedor", method = RequestMethod.GET)
    public ModelAndView modificarProveedor(HttpServletRequest r) {
        int id = Integer.parseInt(r.getParameter("id"));
        Proveedor entidad = null;
        entidad = service.buscarEntidadId(id);
        return new ModelAndView("Proveedor/formUProveedor", "ModeloProveedor", entidad);
    }

    @RequestMapping(value = "modificarProveedorX", method = RequestMethod.GET)
    public String modificarProveedorX(HttpServletRequest r, Model model) {
        int id = Integer.parseInt(r.getParameter("id"));
        Proveedor Proveedor = null;
        Proveedor = service.buscarEntidadId(id);
        model.addAttribute("ModeloProveedor", Proveedor);
        model.addAttribute("ListCliente", serviceClie.listarEntidad());
        model.addAttribute("ListEmpleado", serviceEmpl.listarEntidad());
        model.addAttribute("ListDocumento", serviceDoc.listarEntidad());

        return "Proveedor/formUProveedor";
    }

    @RequestMapping(value = "actualizarProveedor", method = RequestMethod.POST)
    public ModelAndView gactualizarProveedorXX(@ModelAttribute("ModeloProveedor") Proveedor entidad,
            BindingResult result) {
        service.modificarEntidadId(entidad);
        return new ModelAndView(new RedirectView("list"));
    }

}
