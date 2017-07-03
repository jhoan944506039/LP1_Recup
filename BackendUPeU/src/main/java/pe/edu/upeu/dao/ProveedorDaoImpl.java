/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.configuration.SysDataAccess;
import pe.edu.upeu.model.Proveedor;

/**
 *
 * @author David
 */
@Repository("ProveedorDao")
public class ProveedorDaoImpl extends SysDataAccess<Integer, Proveedor> implements ProveedorDao{
    @SuppressWarnings("unchecked")
    public List<Proveedor> listarEntidad(){ return getListAll();}
    public Proveedor buscarEntidadId(int id) {return getByKey(id);}
    public void guardarEntidad(Proveedor entidad) {savev(entidad); }  
    public void eliminarEntidadId(int id) {delete(id);}    
    public void modificarEntidadId(Proveedor entidad) {update(entidad);}         
    public List<Proveedor> listarPorNombre(String dato){
    return (List<Proveedor>)sessionFactory.getCurrentSession()
            .createQuery("select a from Diagnostico a where a.idDiagnostico.dni fechaAlta ? ")        
            .setString(0, "%"+dato+"%")
            .list();
    }     
}
