
package ar.com.mauroheinrich.Odotontologo.controller;

import ar.com.mauroheinrich.Odotontologo.Paciente;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OdontologoController {
     
    // Endpoint para obtener la lista completa de pacientes
    @GetMapping ("/pacientes")
    public List<Paciente> traerPacientes () {
        // Simulamos una base de datos con una lista de pacientes
        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        
        // Agregamos pacientes ficticios a la lista
        listaPacientes.add(new Paciente(1L, "40234567", "Luciano", "Pérez", LocalDate.of(1990,5,12)));
        listaPacientes.add(new Paciente(2L, "36547890", "Marina", "Gómez", LocalDate.of(1985,7,23)));
        listaPacientes.add(new Paciente(3L, "45678912", "Diego", "Fernández", LocalDate.of(2010,3,30)));
        listaPacientes.add(new Paciente(4L, "47890123", "Julieta", "Ramírez", LocalDate.of(2015,6,15)));
        listaPacientes.add(new Paciente(5L, "40987654", "Santiago", "López", LocalDate.of(2005,10,5)));
        
        // Retorno la lista de pacientes simulada
        return listaPacientes;
    }
    
    // Endpoint para obtener solo los pacientes menores de edad
    @GetMapping ("/pacientes/menores")
    @ResponseBody
    public List<Paciente> traerMenores() {
        // Lista que simula nuestra base de datos de pacientes
        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        listaPacientes.add(new Paciente(1L, "40234567", "Luciano", "Pérez", LocalDate.of(1990,5,12)));
        listaPacientes.add(new Paciente(2L, "36547890", "Marina", "Gómez", LocalDate.of(1985,7,23)));
        listaPacientes.add(new Paciente(3L, "45678912", "Diego", "Fernández", LocalDate.of(2010,3,30)));
        listaPacientes.add(new Paciente(4L, "47890123", "Julieta", "Ramírez", LocalDate.of(2015,6,15)));
        listaPacientes.add(new Paciente(5L, "40987654", "Santiago", "López", LocalDate.of(2005,10,5)));
         
        // Lista donde guardaremos solo a los menores de edad
        List<Paciente> listaMenores = new ArrayList<Paciente>();
         
        // Iteramos sobre la lista de pacientes para filtrar a los menores de edad
        for (Paciente pac : listaPacientes) {
            // Fecha actual
            LocalDate hoy = LocalDate.now();
            // Calculamos la diferencia en años entre la fecha de nacimiento y hoy
            Period cant_anios = Period.between(pac.getFecha_nacimiento(), hoy);
             
            // Si el paciente tiene menos de 18 años, lo agregamos a la lista de menores
            if (cant_anios.getYears() < 18) {
                System.out.println("Edad del paciente: " + cant_anios.getYears());
                listaMenores.add(pac);
            }
        }
        // Retornamos la lista de pacientes menores de edad
        return listaMenores;
    }
}
