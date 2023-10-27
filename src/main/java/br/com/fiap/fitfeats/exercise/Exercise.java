package br.com.fiap.fitfeats.exercise;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Exercise {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String titulo;

    @NotBlank
    String tipo;

    @Size(min = 10, message = "{task.description.size}")
    String descricao;

    @Positive
    Integer pontos;

    @Positive
    Integer status;

}
