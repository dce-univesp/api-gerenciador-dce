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
@Table(name = "POLO")
public class Polo {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="COD_POLO")
    private Integer codigo;

  //  @NotNull
    @Column(nullable = false, name="NME_POLO")
    private String nome;
    
  //  @NotBlank
    @Column(nullable = true, name="DSC_ENDERECO")
    private String descricaoEndereco;
    
 //   @NotBlank
    @Column(nullable = true, name="DSC_CONTATO")
    private String descricaoContato;
    
//    @NotBlank
//    @NotNull
    @Column(nullable = false, name = "FLG_UNICEU")
    private Boolean flagUniceu;

 //   @NotNull
    @ManyToOne
    @JoinColumn( nullable=false, name="COD_CIDADE")
    private Cidade cidade;

 //   @NotNull
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
