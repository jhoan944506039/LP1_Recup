/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.service;

import java.util.List;
import pe.edu.upeu.model.Direccion;
        
/**
 *
 * @author Alumnos
 */
public interface DireccionServis {
    public List<Direccion> listarEntidad();
    public Direccion buscarEntidadId(int id);
    public void guardarEntidad(Direccion entidad);
    public void eliminarEntidadId(int id);
    public void modificarEntidadId(Direccion entidad);  
    public List<Direccion> listarPorNombre(String dato);
    
    
}
