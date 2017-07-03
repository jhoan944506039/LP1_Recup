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
import pe.edu.upeu.model.Direccion;
import pe.edu.upeu.dao.DireccionDao;

/**
 *
 * @author Alumnos
 */

@Service("DireccionServis")
@Transactional
public class DireccionServisImpl implements DireccionServis{
    @Autowired
    public DireccionDao dao;
 
    @Override
    public List<Direccion> listarEntidad(){return dao.listarEntidad();}
    @Override
    public Direccion buscarEntidadId(int id) {return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(Direccion entidad) {dao.guardarEntidad(entidad); }  
    @Override
    public void eliminarEntidadId(int id) {dao.eliminarEntidadId(id);}    
    @Override
    public void modificarEntidadId(Direccion entidad) {dao.modificarEntidadId(entidad);}       
    @Override
    public List<Direccion> listarPorNombre(String dato){return dao.listarPorNombre(dato);}    
}
