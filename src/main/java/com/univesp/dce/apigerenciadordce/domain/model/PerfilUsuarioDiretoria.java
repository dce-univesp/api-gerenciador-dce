package com.univesp.dce.apigerenciadordce.domain.model;

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
import java.time.OffsetDateTime;

import lombok.Data;

@Data
@Entity
@Table(name = "PERFIL_USUARIO_DIRETORIA")
public class PerfilUsuarioDiretoria {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_USUARIO_DIRETORIA")
    private Integer codigo;

 //   @NotNull
    @ManyToOne
    @JoinColumn(nullable = true, name = "COD_DIRETORIA")
    private Diretoria diretoria;

 //   @NotNull
    @ManyToOne
    @JoinColumn(nullable = true, name = "COD_CARGO")
    private Cargo cargo;
    
//    @NotNull
    @Column(nullable = true, name = "FLG_ATIVO")
    private Boolean ativo;

 //   @NotNull
    @ManyToOne
    @JoinColumn(nullable = true, name = "COD_PERFIL_USUARIO")
    private PerfilUsuario perfilUsuario;

    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "datetime", name="DTA_INCLUSAO")
    private OffsetDateTime dataInclusao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_ATUALIZACAO")
    private OffsetDateTime dataAtualizacao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_EXCLUSAO")
    private OffsetDateTime dataExclusao;
}
