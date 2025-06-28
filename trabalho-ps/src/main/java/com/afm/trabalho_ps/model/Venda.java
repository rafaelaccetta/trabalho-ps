package com.afm.trabalho_ps.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;
    private Double total;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemVenda> itens;

    public Venda(String estado, Double total, LocalDate data, Usuario usuario) {
        this.estado = estado;
        this.total = total;
        this.data = data;
        this.usuario = usuario;
    }

    public void alterarEstado(String novoEstado) {
        this.estado = novoEstado;
    }
}