package com.example.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.springboot.assembler.ConvertidorPacientes;
import com.example.springboot.entity.EntidadPaciente;
import com.example.springboot.model.Paciente;
import com.example.springboot.repo.RepoPaciente;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

	@Autowired
	private RepoPaciente repoPaciente;

	@Autowired
	private ConvertidorPacientes convertidorPacientes;

	public Paciente crear(Paciente paciente) {

		return convertidorPacientes
				.convertirPaciente(repoPaciente.save(convertidorPacientes.convertirEntidadPaciente(paciente)));

	}

	public Paciente actualizar(Paciente paciente) {

		return convertidorPacientes
				.convertirPaciente(repoPaciente.save(convertidorPacientes.convertirEntidadPaciente(paciente)));

	}

	public Paciente borrar(String id) {
		Paciente paciente = convertidorPacientes.convertirPaciente(repoPaciente.findById(id).get());

		if (paciente != null) {
			repoPaciente.deleteById(id);
		}

		return paciente;

	}

	public List<Paciente> obtener() {

		return convertidorPacientes.convertirListaPacientes(repoPaciente.findAll());

	}

	public Paciente obtenerPorId(String id) {

		Optional<EntidadPaciente> optionalPaciente = repoPaciente.findById(id);
		Paciente paciente;

		if (optionalPaciente.isPresent()) {
			paciente = convertidorPacientes.convertirPaciente(optionalPaciente.get());
			return paciente;
		} else {
			return null;
		}

	}

	public List<Paciente> obtenerPorPaginacion(Pageable pageable) {

		return convertidorPacientes.convertirListaPacientes(repoPaciente.findAll(pageable).getContent());

	}

}
