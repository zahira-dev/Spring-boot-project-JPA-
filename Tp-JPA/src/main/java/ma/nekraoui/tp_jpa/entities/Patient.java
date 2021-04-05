package ma.nekraoui.tp_jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table (name="PATIENT")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
private long id;
	@Column (name="nom",length=25)
private String nom;
	@Temporal(TemporalType.DATE)
private Date datNaissance;
private int Score;
private Boolean	malade;

}
