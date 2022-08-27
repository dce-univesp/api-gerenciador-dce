package com.univesp.dce.apigerenciadordce.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "FOTO_NEP")
public class FotoNep {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_FOTO_NEP")
    private Integer codigo;

  //  @NotBlank
    @Column(nullable = false, name = "NME_ARQUIVO")
    private String nomeArquivo;

 //   @NotBlank
    @Column(nullable = true, name = "DSC_FOTO")
    private String descricao;

 //   @NotBlank
    @Column(nullable = true, name = "DSC_CONTENT_TYPE")
    private String contentType;

  //  @NotBlank
    @Column(nullable = true, name = "QTD_TAMANHO_ARQUIVO")
    private Integer tamanho;
    
    @ManyToOne
    @JoinColumn( nullable=false, name="COD_NEP")
    private Nep nep;
    
    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "datetime", name="DTA_INCLUSAO")
    private OffsetDateTime dataInclusao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_ATUALIZACAO")
    private OffsetDateTime dataAtualizacao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_EXCLUSAO")
    private OffsetDateTime dataExclusao;
}
