package com.bolsadeideas.springboot.datajpa.app.springbootdatajpa.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
//import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {//Serializable, conecta a la base de datos, que permite entrada y salida de la vase de datos 
    
    private static final long serialVersionUID = 1L;//Versión del serializable
    //Todo lo que va con @, son marcasiones del spring
    @Id//Se marca como id, porque desde acá se va a crear la tabla y éste es el id, o la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Este es el que nos da el auto_increment(SQL Server)(como se va a generar ese id)
    private long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String correo;

    @NotEmpty
    private String celular;

    @NotNull
    @Column(name = "create_at")//Este es el nombre de la columna que se va a ver en la base de datos
    @Temporal(TemporalType.DATE)//Estamos diciendo que el createAt, es de tipo temporal y date, así es como se genera en la tabla de la base de datos
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date CreateAt;//Es un nombre común y corriente, este date es de la clase en java
    @PrePersist
    public void PrePersist(){
        CreateAt = new Date();
    }
    //@PrePersist
    //public void prepersist(){//Primero se hace esto y luego se guarda
     //   CreateAt = new Date();
    //}

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
