package com.rosalte.spring.api_rosatel.modules.producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosalte.spring.api_rosatel.modules.usuario.repository.DireccionRepository;
import com.rosalte.spring.api_rosatel.modules.usuario.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    private DireccionRepository repoDireccion;
    private OrdenService serviceOrden;
    

    
    public ModelUser create(ModelUser user)
    {
        //verificar si el susuairo existe
        Boolean exsit = repo.existsById(user.getId());
        if(!exsit)
        {
            ModelUser newUser = new UserService(

            );
            repo.save(newUser);
            return true;
        }
        return false;
    }
    //resivira el id del cotnroller y la lista de compras 
    /*
     id,
     items: [
        {
            idProducto,
            cantidad
        }
     ]
    */
    public ValidacionAccion CrearOrden(long id,long id_Direccion, List<>items)
    {
        Boolean exist = repo.existsById(id);
        if(exist)
        {
            ModelOrden orden = new ModelOrden();
            orden.setUserId(id);
            orden.setDireccionId(id_Direccion);
            ModelOrden ordenGuardad = OrdenService.crearOrden(orden);
            //crear la orden
            for( modeloLista item : items)
            {
                //creacion de detalle
                Detalle_Oreden detalle = new Detalle_Orden(
                    null,
                    ordenGuardad.getId(),
                    item.getIdProducto(),
                    item.getCantidad()
                );
                serviceOrden.crearDetalle(detalle);

            }
            //cambio de respuesta a futuro
            return true;

        }
        return false;
    }

    //asignar nuevas direciones para usuario
    public ValidacionAccion asignarDireccion(long id, ModelDireccion direccion)
    {
        //certificar que el usuario exista
        Boolean exist = repo.existsById(id);
        if(exist)
        {
            ModelDireccion newDireccion = new ModelDireccion(
                null,
                id,
                direccion.getdireccion,
                direccion.getRefencia,
                direccion.getCodigoPostal
            );
            repoDireccion.save(newDireccion);
            return true;
        }
        return false;
    }
    
    public apiResponse getAllDirecciones(long id)
    {
        Boolean exist = repo.existsById(id);
        if(exist)
        {
            List<ModelDireccion> direcciones = repoDireccion.findByUserId(id);
            return new apiResponse(true, "Direcciones obtenidas", direcciones);
        }
        return new apiResponse(false, "Usuario no encontrado", null);
    }


}
