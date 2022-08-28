package com.univesp.dce.apigerenciadordce.domain.model;

import java.time.OffsetDateTime;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EIXO")
public class Eixo {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_EIXO")
    private Integer codigo;

  //  @NotBlank
    @Column(nullable = false, name = "NME_EIXO")
    private String nome;

  //  @NotBlank
    @Column(nullable = true, name = "DSC_EIXO")
    private String descricao;

  //  @NotNull
    @Column(nullable = false, name = "FLG_ATIVO")
    private Boolean ativo;

    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "datetime", name="DTA_INCLUSAO")
    private OffsetDateTime dataInclusao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_ATUALIZACAO")
    private OffsetDateTime dataAtualizacao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_EXCLUSAO")
    private OffsetDateTime dataExclusao;
}
