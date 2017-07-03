/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.model.Proveedor;
import pe.edu.upeu.dao.ProveedorDao;

/**
 *
 * @author Alumnos
 */

@Service("ProveedorServis")
@Transactional
public class ProveedorServisImpl implements ProveedorServis{
    @Autowired
    public ProveedorDao dao;
 
    @Override
    public List<Proveedor> listarEntidad(){return dao.listarEntidad();}
    @Override
    public Proveedor buscarEntidadId(int id) {return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(Proveedor entidad) {dao.guardarEntidad(entidad); }  
    @Override
    public void eliminarEntidadId(int id) {dao.eliminarEntidadId(id);}    
    @Override
    public void modificarEntidadId(Proveedor entidad) {dao.modificarEntidadId(entidad);}       
    @Override
    public List<Proveedor> listarPorNombre(String dato){return dao.listarPorNombre(dato);}    
}
