package org.sid.stock.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GPharmacieApplication {

	public static void main(String[] args) {
		SpringApplication.run(GPharmacieApplication.class, args);
		/*MedicamentsRep medicamentsRep=ctx.getBean(MedicamentsRep.class);
		FournisseurRep fournisseurRep=ctx.getBean(FournisseurRep.class);*/
		
	}
}
