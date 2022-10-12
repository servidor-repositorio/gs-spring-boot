package com.example.springboot.assembler;

import org.springframework.stereotype.Component;
import com.example.springboot.entity.EntidadPaciente;
import com.example.springboot.model.Paciente;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertidorPacientes {

	public List<Paciente> convertirListaPacientes(List<EntidadPaciente> entidadPacientes){
		List<Paciente> pacientes = new ArrayList<>();

		for (EntidadPaciente entidadPaciente1 : entidadPacientes) {

			Paciente paciente = new Paciente();

			paciente.setNombre(entidadPaciente1.getNombreEntidad());
			paciente.setFechaNacimiento(entidadPaciente1.getFechaNacimientoEntidad());
			paciente.setIdentificacion(entidadPaciente1.getIdentificacionEntidad());
			paciente.setTipoIdentificacion(entidadPaciente1.getTipoIdentificacionEntidad());
			paciente.setEps(entidadPaciente1.getEpsEntidad());
			paciente.setHistoriaClinica(entidadPaciente1.getHistoriaClinicaEntidad());

			pacientes.add(paciente);
		}

		return pacientes;
	}

	public Paciente convertirPaciente(EntidadPaciente entidadPaciente1) {

		List<EntidadPaciente> entidadPacientes = new ArrayList<>();
		entidadPacientes.add(entidadPaciente1);

		return convertirListaPacientes(entidadPacientes).get(0);

	}

	public EntidadPaciente convertirEntidadPaciente(Paciente paciente) {

		EntidadPaciente entidadPaciente = new EntidadPaciente();

		entidadPaciente.setNombreEntidad(paciente.getNombre());
		entidadPaciente.setFechaNacimientoEntidad(paciente.getFechaNacimiento());
		entidadPaciente.setIdentificacionEntidad(paciente.getIdentificacion());
		entidadPaciente.setTipoIdentificacionEntidad(paciente.getTipoIdentificacion());
		entidadPaciente.setEpsEntidad(paciente.getEps());
		entidadPaciente.setHistoriaClinicaEntidad(paciente.getHistoriaClinica());

		return entidadPaciente;
	}

}
