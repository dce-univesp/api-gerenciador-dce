package com.univesp.dce.apigerenciadordce.domain.model;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.time.OffsetDateTime;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "DIRETORIA")
public class Diretoria {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_DIRETORIA")
    private Integer codigo;

  //  @NotBlank
  //  @NotNull
    @Column(nullable = false, name = "NME_DIRETORIA")
    private String nome;

  //  @NotBlank
    @Column(nullable = true, name = "DSC_DIRETORIA")
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true, name = "DTA_INICIO_MANDATO")
    private Date dataInicioMandado;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "DTA_FIM_MANDATO")
    private Date dataFimMandado;

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
