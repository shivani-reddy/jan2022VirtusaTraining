package com.virtusa.customerapi.models;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
@Entity
@Table(name="Desk")
public class Desk {

    @Id
    @Column(name = "Desk_Code",length=15,unique=true,nullable=false)
    private String deskCode;

    @Column(name="Micr_Code",length=10,nullable=false)
    private long micrCode;
    
    /*
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="Bank_Id"), name = "Bank_Id")
    private Bank bank;
	*/
}