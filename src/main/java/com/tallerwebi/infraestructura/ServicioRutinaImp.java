package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.*;
import com.tallerwebi.dominio.excepcion.NoHayEjerciciosCargadosException;
import com.tallerwebi.dominio.excepcion.RutinaSemanalVacia;
import com.tallerwebi.presentacion.DatosDiasYEjercicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ServicioRutinaImp implements ServicioRutina {
    @Autowired
    private RepositorioEjercicio repositorioEjercicio;
    @Autowired
    private RepositorioRutinaSemanal repositorioRutinaSemanal;

    public ServicioRutinaImp(RepositorioEjercicio repositorioEjercicio, RepositorioRutinaSemanal repositorioRutinaSemanal){
        this.repositorioRutinaSemanal= repositorioRutinaSemanal;
        this.repositorioEjercicio= repositorioEjercicio;
    }
    @Override
    public List<Ejercicio> cargarEjercicios(List<Ejercicio> listaEjercicios){
        DetalleRutina detalleRutina = new DetalleRutina();
        detalleRutina.setListaEjercicios(listaEjercicios);
        return detalleRutina.getListaEjercicios();
    }

    @Override
    public Integer contarEjerciciosCumplidos(DetalleRutina detalleRutina) throws NoHayEjerciciosCargadosException {
        Integer ejerciciosCumplidos = 0;
//        Ejercicio actual = new Ejercicio();
        if((detalleRutina.getListaEjercicios())!=null){
            for(Ejercicio actual : detalleRutina.getListaEjercicios()){
                if (actual.getRealizado().equals(true)) {
                    ejerciciosCumplidos++;
                }
            }
        }
        else {
            throw new NoHayEjerciciosCargadosException("No hay ejercicios cargados");
        }
        return ejerciciosCumplidos;
    }

    @Override
    public Double calcularDiferenciaDeKilos(Double pesoInicial, Double pesoActual){
        Double difPeso;
        difPeso= pesoInicial - pesoActual;
        return difPeso;
    }

    @Override
    public Integer contarEjerciciosporHacer(DetalleRutina detalleRutina) throws NoHayEjerciciosCargadosException {
        Integer ejerciciosPorHacer = 0;
//        Ejercicio actual = new Ejercicio();
        if((detalleRutina.getListaEjercicios())!=null) {
            for (Ejercicio actual : detalleRutina.getListaEjercicios()) {
                if (actual.getRealizado().equals(false)) {
                    ejerciciosPorHacer++;
                }
            }
        }
        else {
            throw new NoHayEjerciciosCargadosException("No hay ejercicios cargados");
        }
        return ejerciciosPorHacer;
    }

    @Override
    public Double calcularIMC(Double peso,Double altura){
        Double imc=0.0;
        imc=peso/(altura*altura);
        return imc;
    }
    /*Se necesita la AptitudFisica Cargada por el usuario para armar la rutina...  */

    public RutinaSemanal generarRutinaSemanal(Usuario usuario) {
        AptitudFisica aptitudFisica = usuario.getAptitudFisica();
        int diasEntrenamiento = aptitudFisica.getDiasEntrenamiento();
        int horasPorSesion = aptitudFisica.getHorasEntrenamiento();
        var entrenamiento = aptitudFisica.getTipoEntrenamiento();
        String tipoEntrenamiento = entrenamiento.iterator().next().getDescripcion();
        RutinaSemanal rutinaSemanal = new RutinaSemanal();
        rutinaSemanal.setUsuario(usuario);
        Set<RutinaDiaria> rutinasDiarias = new HashSet<>();


        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        for (int i = 0; i < diasEntrenamiento; i++) {
            RutinaDiaria rutinaDiaria = new RutinaDiaria();
            rutinaDiaria.setRutinaSemanal(rutinaSemanal);
            rutinaDiaria.setDiaSemana(diasSemana[i % 7]);

            Set<Ejercicio> ejerciciosDia = generarEjerciciosDia(horasPorSesion, tipoEntrenamiento);
            rutinaDiaria.setEjercicios(ejerciciosDia);

            rutinasDiarias.add(rutinaDiaria);
        }
        rutinaSemanal.setRutinaDiaria(rutinasDiarias);

        repositorioRutinaSemanal.guardar(rutinaSemanal);

        return rutinaSemanal;
    }

    public Set<Ejercicio> generarEjerciciosDia(int horasPorSesion, String tipoEntrenamiento) {
        List<Ejercicio> ejerciciosDisponibles = repositorioEjercicio.buscarTodosLosEjercicio();
        Set<Ejercicio> ejerciciosDia = new HashSet<>();
        Random random = new Random();

        int minutosDisponibles = horasPorSesion * 60;
        int minutosAsignados = 0;

        // Filtrar ejercicios primarios y no primarios
        List<Ejercicio> ejerciciosPrimarios = new ArrayList<>();
        List<Ejercicio> ejerciciosNoPrimarios = new ArrayList<>();

        for (Ejercicio ejercicio : ejerciciosDisponibles) {
            if (ejercicio.getTipo().equals(tipoEntrenamiento)) {
                if (ejercicio.getPrimario()) {
                    ejerciciosPrimarios.add(ejercicio);
                } else {
                    ejerciciosNoPrimarios.add(ejercicio);
                }
            }
        }

        // Agregar hasta 2 ejercicios primarios
            int maxPrimarios = 2;
        while (maxPrimarios > 0 && minutosAsignados < minutosDisponibles && !ejerciciosPrimarios.isEmpty()) {
            int index = random.nextInt(ejerciciosPrimarios.size());
            Ejercicio ejercicio = ejerciciosPrimarios.get(index);

            if (minutosAsignados + ejercicio.getDuracion() <= minutosDisponibles) {
                minutosAsignados += ejercicio.getDuracion();
                ejerciciosDia.add(ejercicio);
                maxPrimarios--;
            }

            ejerciciosPrimarios.remove(index);
        }

        // Agregar ejercicios no primarios hasta completar el tiempo disponible
        while (minutosAsignados < minutosDisponibles && !ejerciciosNoPrimarios.isEmpty()) {
            int index = random.nextInt(ejerciciosNoPrimarios.size());
            Ejercicio ejercicio = ejerciciosNoPrimarios.get(index);

            if (minutosAsignados + ejercicio.getDuracion() <= minutosDisponibles) {
                minutosAsignados += ejercicio.getDuracion();
                ejerciciosDia.add(ejercicio);
            }

            ejerciciosNoPrimarios.remove(index);
        }


        return ejerciciosDia;
    }

    @Override
    public List<RutinaSemanal> obtenerTodasLasRutinasById(Long idUsuario) throws RutinaSemanalVacia {
        return this.repositorioRutinaSemanal.obtenerTodasLasRutinasById(idUsuario);
    }
    @Override
    public DatosDiasYEjercicios obtenerDatosDiasYEjercicios(Long idUsuario) throws RutinaSemanalVacia {
        List<RutinaSemanal> rutinaSemanalList = this.obtenerTodasLasRutinasById(idUsuario);
        DatosDiasYEjercicios datos = new DatosDiasYEjercicios();

        for (RutinaSemanal rutinaSemanal : rutinaSemanalList) {
            Set<RutinaDiaria> rutinaDiariaList = rutinaSemanal.getRutinaDiaria();

            for (RutinaDiaria rutinaDiaria : rutinaDiariaList) {
                String dia = rutinaDiaria.getDiaSemana();

                datos.agregarDia(dia);

                Set<Ejercicio> ejercicios = rutinaDiaria.getEjercicios();

                for (Ejercicio ejercicio : ejercicios) {
                    String nombreEjercicio = ejercicio.getNombre();

                    datos.agregarEjercicio(nombreEjercicio);
                }
            }
        }

        return datos;
    }

    @Override
    public DatosDiasYEjercicios procesarRutinas(Long idUsuario) throws RutinaSemanalVacia {
        DatosDiasYEjercicios datos =  obtenerDatosDiasYEjercicios(idUsuario);

        ArrayList<Integer> dias = new ArrayList<>();
        ArrayList<Integer> ejercicios = new ArrayList<>();

        List<String> labelDias = new ArrayList<>();
        List<String> labelEjercicios = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : datos.getDias().entrySet()) {
            dias.add(entry.getValue());
            labelDias.add(entry.getKey());
        }

        for (Map.Entry<String, Integer> entry : datos.getEjercicios().entrySet()) {
            ejercicios.add(entry.getValue());
            labelEjercicios.add(entry.getKey());
        }

        datos.setDiasList(dias);
        datos.setEjerciciosList(ejercicios);
        datos.setLabelDias(labelDias);
        datos.setLabelEjercicios(labelEjercicios);

        return datos;
    }

}
