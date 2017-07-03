/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import pe.edu.upeu.model.Proveedor;

/**
 *
 * @author David
 */
public interface ProveedorDao {
    public List<Proveedor> listarEntidad();
    public Proveedor buscarEntidadId(int id);
    public void guardarEntidad(Proveedor entidad);
    public void eliminarEntidadId(int id);
    public void modificarEntidadId(Proveedor entidad); 
    public List<Proveedor> listarPorNombre(String dato);
}
