package com.tallerwebi.presentacion.DataModel;
import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.enums.Days;
import com.tallerwebi.enums.ExerciseType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private Days Day;
    private Integer week;
    private ExerciseType Type;
    private Integer Series;
    private Integer Repeat;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public String GetReplays (){
        return this.Series + " x " + this.Repeat;
    }

}
