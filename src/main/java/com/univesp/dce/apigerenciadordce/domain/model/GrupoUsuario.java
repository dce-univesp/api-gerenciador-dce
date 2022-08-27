package com.univesp.dce.apigerenciadordce.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "GRUPO_USUARIO")
public class GrupoUsuario {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "COD_GRUPO")
    private Integer codigo;

    @Column(nullable = false, name = "NME_GRUPO")
    private String nome;

    @Column(nullable = true, name = "DSC_GRUPO", length = 500)
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

    @ManyToMany
    @JoinTable(name = "grupo_permissao", joinColumns = @JoinColumn(name = "COD_GRUPO"),
            inverseJoinColumns = @JoinColumn(name = "COD_PERMISSAO"))
    private Set<Permissao> permissoes = new HashSet<>();

    public boolean removerPermissao(Permissao permissao) {
        return getPermissoes().remove(permissao);
    }

    public boolean adicionarPermissao(Permissao permissao) {
        return getPermissoes().add(permissao);
    }
}