package com.univesp.dce.apigerenciadordce.domain.model;

import lombok.EqualsAndHashCode;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;

import lombok.Data;

@Data
@Entity
@Table(name = "REPRESENTANTE_POLO")
public class RepresentantePolo {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_REPRESENTANTE")
    private Integer codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "TPO_REPRESENTANTE")
    private TipoRepresentantePolo tipoRepresentantePolo;

    // @NotNull
    @ManyToOne
    @JoinColumn(nullable = false, name = "COD_POLO")
    private Polo polo;

    // @NotNull
    @Column(nullable = false, name = "FLG_ATIVO")
    private Boolean ativo;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true, name = "DTA_INICIO_MANDATO")
    private Date dataInicioMandado;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true, name = "DTA_FIM_MANDATO")
    private Date dataFimMandado;

    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "datetime", name = "DTA_INCLUSAO")
    private OffsetDateTime dataInclusao;

    @Column(nullable = true, columnDefinition = "datetime", name = "DTA_ATUALIZACAO")
    private OffsetDateTime dataAtualizacao;

    @Column(nullable = true, columnDefinition = "datetime", name = "DTA_EXCLUSAO")
    private OffsetDateTime dataExclusao;

}
