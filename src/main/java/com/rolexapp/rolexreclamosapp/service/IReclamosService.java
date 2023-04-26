package com.rolexapp.rolexreclamosapp.service;

import com.rolexapp.rolexreclamosapp.models.Reclamos;
import com.rolexapp.rolexreclamosapp.models.Response;

public interface IReclamosService {
    public Response<Reclamos> ObtenerListaReclamos();
	
	public Response<Reclamos> CrearReclamos(Reclamos reclamos );
	
	public Response<Reclamos> EditarReclamos(Integer id);
	
	public Response<Reclamos> EliminarReclamos(Integer id);
}
