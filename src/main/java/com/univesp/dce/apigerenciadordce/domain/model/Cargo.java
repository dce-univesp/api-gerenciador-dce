package com.univesp.dce.apigerenciadordce.domain.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "CARGO")
public class Cargo {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_CARGO")
    private Integer codigo;

 //   @NotBlank
 //   @NotNull
    @Column(nullable = false, name = "NME_CARGO")
    private String nome;

 //   @NotBlank
    @Column(nullable = true, name="DSC_CARGO")
    private String descricao;
   
    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "datetime", name="DTA_INCLUSAO")
    private OffsetDateTime dataInclusao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_ATUALIZACAO")
    private OffsetDateTime dataAtualizacao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_EXCLUSAO")
    private OffsetDateTime dataExclusao;

}
