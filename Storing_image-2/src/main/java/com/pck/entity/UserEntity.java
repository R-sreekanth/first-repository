package com.pck.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="user_table1")
public class UserEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
	
	private String userName;
	
	//@Lob
	 //@Column(columnDefinition = "LONGBLOB")
	private String image;

}
