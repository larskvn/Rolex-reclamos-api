package com.rolexapp.rolexreclamosapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rolexapp.rolexreclamosapp.interfaces.IReclamos;
import com.rolexapp.rolexreclamosapp.models.Reclamos;
import com.rolexapp.rolexreclamosapp.models.Response;


@Component
public class ReclamosService implements IReclamosService {
    @Autowired
	private IReclamos reclamosRepository;

    @Override
	public Response<Reclamos>ObtenerListaReclamos(){
		
		Response<Reclamos> response = new Response<>();
		try {
			response.setEstado(true);
			response.setListData((List<Reclamos>) reclamosRepository.findAll());
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

	@Override
	public Response<Reclamos> CrearReclamos(Reclamos reclamos) {
		
		Response<Reclamos> response = new Response<>();

		try {
			Reclamos r = reclamosRepository.save(reclamos);
			response.setEstado(true);
			response.setData(r);
			response.setListData((List<Reclamos>) reclamosRepository.findAll());
			
		} catch (Exception e) {
			response.setEstado(false);
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

	@Override
	public Response<Reclamos> EditarReclamos(Integer id) {
		Response<Reclamos> response = new Response<>();

		try {
			Optional<Reclamos> p = reclamosRepository.findById(id);

			response.setEstado(true);
			response.setData(p.get());
			response.setMensaje("Actualizando el reclamo " + p.get().getNomClie());

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Ocurrió un error actualizar el reclamo");
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

	@Override
	public Response<Reclamos> EliminarReclamos(Integer id) {
		Response<Reclamos> response = new Response<>();
		
		try {	
			Optional<Reclamos> p = reclamosRepository.findById(id);
			reclamosRepository.deleteById(id);			
			response.setEstado(true);
			response.setData(p.get());
			response.setMensaje("El reclamo de "+p.get().getNomClie()+" ha sido eliminado");
		}catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Ocurrió un error al eliminar el reclamo");
			response.setMensajeError(e.getStackTrace().toString());	
		}		
		return response;
	}
	
	
}
