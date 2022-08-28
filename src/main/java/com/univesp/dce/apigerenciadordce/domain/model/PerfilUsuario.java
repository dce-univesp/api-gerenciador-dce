package com.univesp.dce.apigerenciadordce.domain.model;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
@Entity
@Table(name = "PERFIL_USUARIO")
public class PerfilUsuario {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="COD_PERFIL_USUARIO")
    private Integer codigo;

 //   @NotBlank
    @Column(nullable = false, name="DSC_EMAIL_ACADEMICO")
    private String emailAcademico; // login

 //   @NotBlank
    @Column(nullable = false, name="DSC_SENHA")
    private String senha;

//    @NotBlank
    @Column(nullable = true, name="DSC_EMAIL_PESSOAL")
    private String emailPessoal;

 //   @NotBlank
    @Column(nullable = false, name="DSC_USUARIO_TELEGRAM")
    private String usuarioTelegram;

 //   @NotBlank
    @Column(nullable = false, name="NME_USUARIO")
    private String nomeUsuario;

 //   @NotNull
    @Column(nullable = false, name = "FLG_ATIVO")
    private Boolean ativo;

 //   @NotNull
    @Column(nullable = true, name= "NUM_ANO_TURMA_INGRESSO")
    private Integer anoTurmaIngresso;

//    @NotNull
    @Column(nullable = false, name="NUM_SEMESTRE_INGRESSO")
    private Integer numeroSemestreIngresso;
    
 //   @NotNull
    @ManyToOne
    @JoinColumn(nullable = true, name="COD_CURSO")
    private Curso curso;

 //   @NotNull
    @ManyToOne
    @JoinColumn(nullable = true, name="COD_POLO")
    private Polo polo;

 //   @NotBlank
    @Column(nullable = true, name="DSC_CONTATO")
    private String descricaoContato;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, name="TPO_USUARIO")
    private TipoUsuario tipoUsuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name="SIT_USUARIO")
    private SituacaoUsuario situacaoUsuario;

    @CreationTimestamp
    @Column(nullable = true, columnDefinition = "datetime", name="DTA_INCLUSAO")
    private OffsetDateTime dataInclusao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_ATUALIZACAO")
    private OffsetDateTime dataAtualizacao;

    @Column(nullable = true, columnDefinition = "datetime", name="DTA_EXCLUSAO")
    private OffsetDateTime dataExclusao;

    @ManyToMany
    @JoinTable(name = "GRUPO_PERFIL_USUARIO", joinColumns = @JoinColumn(name = "COD_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "COD_GRUPO"))
    private Set<GrupoUsuario> grupos = new HashSet<>();

    public boolean senhaCoincideCom(String senha) {
		return getSenha().equals(senha);
    }
	
    public boolean senhaNaoCoincideCom(String senha) {
		return !senhaCoincideCom(senha);
    }
    
    public boolean removerGrupo(GrupoUsuario grupo) {
		return getGrupos().remove(grupo);
    }
	
    public boolean adicionarGrupo(GrupoUsuario grupo) {
		return getGrupos().add(grupo);
    }
}
