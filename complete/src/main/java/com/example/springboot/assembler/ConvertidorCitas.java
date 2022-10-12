package com.example.springboot.assembler;

import org.springframework.stereotype.Component;
import com.example.springboot.entity.EntidadCita;
import com.example.springboot.model.Cita;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertidorCitas {

	public List<Cita> convertirListaCitas(List<EntidadCita> entidadCitas) {

		List<Cita> citas = new ArrayList<>();

		for (EntidadCita entidadCita1 : entidadCitas) {
			Cita cita = new Cita();

			cita.setRegistro(entidadCita1.getRegistroEntidad());
			cita.setPaciente(entidadCita1.getPacienteEntidad());
			cita.setMedico(entidadCita1.getMedicoEntidad());
			cita.setHorarioCita(entidadCita1.getHorarioCitaEntidad());

			citas.add(cita);
		}

		return citas;
	}

	public Cita convertirCita(EntidadCita entidadCita1) {

		List<EntidadCita> entidadCitas = new ArrayList<>();
		entidadCitas.add(entidadCita1);

		return convertirListaCitas(entidadCitas).get(0);

	}

	public EntidadCita convertirEntidadCita(Cita cita) {

		EntidadCita entidadCita = new EntidadCita();

		entidadCita.setRegistroEntidad(cita.getRegistro());
		entidadCita.setPacienteEntidad(cita.getPaciente());
		entidadCita.setMedicoEntidad(cita.getMedico());
		entidadCita.setHorarioCitaEntidad(cita.getHorarioCita());

		return entidadCita;
	}

}
