package com.univesp.dce.apigerenciadordce.domain.model;

import java.time.OffsetDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "NEP")
public class Nep {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_NEP")
    private Integer codigo;

   // @NotBlank
    @Column(nullable = false, name = "DSC_TITULO")
    private String titulo;

   // @NotBlank
    @Column(nullable = true, name = "DSC_SUBTITULO")
    private String subTitulo;

  //  @NotBlank
    @Column(nullable = true, name="DTA_PUBLICACAO")
    private OffsetDateTime dataPublicacao;

  //  @NotBlank
    @Column(nullable = false, name="DSC_POSTAGEM")
    private String descricaoPostagem;

  //  @NotNull
    @Column(nullable = false, name = "FLG_ATIVO")
    private Boolean ativo;

   // @NotNull
    @ManyToOne
	@JoinColumn(nullable = false, name = "COD_PERFIL")
    private PerfilUsuario perfil;

 //   @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name="TPO_NEP")
    private TipoNep tipoNep;

 //   @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name="TPO_ABRANGENCIA_NEP")
    private TipoVisibilidadeNep tipoAbrangenciaNep;

 //   @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name="TPO_SITUACAO")
    private SituacaoNep situacaoNep;

    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "datetime", name="DTA_INCLUSAO")
    private OffsetDateTime dataInclusao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_ATUALIZACAO")
    private OffsetDateTime dataAtualizacao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_EXCLUSAO")
    private OffsetDateTime dataExclusao;
}
