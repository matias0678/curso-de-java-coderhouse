package matiaskarlen.preEntrega2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name="clientes")
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name="nombre")
    private String nombre;

    @Column(name="dni")
    private int dni;

    @Column(name="mail")
    private String mail;

    @Column(name="celular")
    private int celular;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Venta> venta;

    public Cliente() {
    }

    public Cliente(long id, String nombre, int dni, String mail, int celular, List<Venta> venta) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.mail = mail;
        this.celular = celular;
        this.venta = venta;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && dni == cliente.dni && celular == cliente.celular && Objects.equals(nombre, cliente.nombre) && Objects.equals(mail, cliente.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, dni, mail, celular);
    }


}

