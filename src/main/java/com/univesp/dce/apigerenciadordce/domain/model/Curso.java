package com.univesp.dce.apigerenciadordce.domain.model;

import java.time.OffsetDateTime;

import lombok.EqualsAndHashCode;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "CURSO")
public class Curso {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_CURSO")
    private Integer codigo;

  //  @NotBlank
    @Column(nullable = false, name = "NME_CURSO")
    private String nome;

  //  @NotBlank
    @Column(nullable = true, name = "SGL_CURSO")
    private String sigla;

  //  @NotBlank
    @Column(nullable = true, name = "DSC_CURSO", length = 500)
    private String descricao;

  //  @NotBlank
    @Column(nullable = true, name = "DSC_URI_GRADE", length = 500)
    private String linkGrade;

 //   @NotBlank
    @Column(nullable = true, name = "DSC_URI_PPC", length = 500)
    private String linkPPC;

 //   @NotNull
    @Column(nullable = true, name = "FLG_ATIVO")
    private Boolean ativo;

 //   @NotNull
    @ManyToOne
    @JoinColumn(nullable = true, name = "COD_EIXO")
    private Eixo eixo;
    
    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "datetime", name="DTA_INCLUSAO")
    private OffsetDateTime dataInclusao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_ATUALIZACAO")
    private OffsetDateTime dataAtualizacao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_EXCLUSAO")
    private OffsetDateTime dataExclusao;
}
