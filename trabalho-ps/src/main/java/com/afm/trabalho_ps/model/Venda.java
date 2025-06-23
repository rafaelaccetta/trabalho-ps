package com.afm.trabalho_ps.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens;

    public Venda(String estado, Double total, Usuario usuario) {
        this.estado = estado;
        this.total = total;
        this.usuario = usuario;
    }

    public void alterarEstado(String novoEstado) {
        this.estado = novoEstado;
    }
}