package com.example.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.springboot.assembler.ConvertidorMedicos;
import com.example.springboot.entity.EntidadMedico;
import com.example.springboot.model.Medico;
import com.example.springboot.repo.RepoMedico;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

	@Autowired
	private RepoMedico repoMedico;

	@Autowired
	private ConvertidorMedicos convertidorMedicos;

	public Medico crear(Medico medico) {

		return convertidorMedicos.convertirMedico(repoMedico.save(convertidorMedicos.convertirEntidadMedico(medico)));

	}

	public Medico actualizar(Medico medico) {

		return convertidorMedicos.convertirMedico(repoMedico.save(convertidorMedicos.convertirEntidadMedico(medico)));

	}

	public Medico borrar(String id) {
		Medico medico = convertidorMedicos.convertirMedico(repoMedico.findById(id).get());

		if (medico != null) {
			repoMedico.deleteById(id);
		}

		return medico;

	}

	public List<Medico> obtener() {

		return convertidorMedicos.convertirListaMedicos(repoMedico.findAll());

	}

	public Medico obtenerPorId(String id) {

		Optional<EntidadMedico> optionalMedico = repoMedico.findById(id);
		Medico medico;

		if (optionalMedico.isPresent()) {
			medico = convertidorMedicos.convertirMedico(optionalMedico.get());
			return medico;
		} else {
			return null;
		}

	}

	public List<Medico> obtenerPorPaginacion(Pageable pageable) {

		return convertidorMedicos.convertirListaMedicos(repoMedico.findAll(pageable).getContent());

	}

}
