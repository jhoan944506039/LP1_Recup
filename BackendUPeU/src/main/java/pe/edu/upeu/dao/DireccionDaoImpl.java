/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.configuration.SysDataAccess;
import pe.edu.upeu.model.Direccion;

/**
 *
 * @author David
 */
@Repository("DireccionDao")
public class DireccionDaoImpl extends SysDataAccess<Integer, Direccion> implements DireccionDao{
    @SuppressWarnings("unchecked")
    public List<Direccion> listarEntidad(){ return getListAll();}
    public Direccion buscarEntidadId(int id) {return getByKey(id);}
    public void guardarEntidad(Direccion entidad) {savev(entidad); }  
    public void eliminarEntidadId(int id) {delete(id);}    
    public void modificarEntidadId(Direccion entidad) {update(entidad);}         
    public List<Direccion> listarPorNombre(String dato){
    return (List<Direccion>)sessionFactory.getCurrentSession()
            .createQuery("select a from Diagnostico a where a.idDiagnostico.dni fechaAlta ? ")        
            .setString(0, "%"+dato+"%")
            .list();
    }     
}
