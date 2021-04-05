package ma.nekraoui.tp_jpa;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.nekraoui.tp_jpa.entities.Patient;
import ma.nekraoui.tp_jpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner{
   @Autowired
    private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      patientRepository.save(new Patient( 1,"zahira",new Date(),2300,false));
      patientRepository.save(new Patient( 2,"malak",new Date(),2300,false));
      patientRepository.save(new Patient( 3,"wissal",new Date(),2300,false));
      patientRepository.save(new Patient( 4,"hanane",new Date(),2300,false));
      patientRepository.save(new Patient( 5,"zakaria",new Date(),2300,false));
      patientRepository.findAll().forEach(p->{ System.out.println(p.toString());
    	  });
		Patient patient=patientRepository.findById(4L).get();
		System.out.println(patient.getNom());
		System.out.println("----------------------");
		Page<Patient> patients=patientRepository.findByNomContains("s",PageRequest.of(0,5));
		patients.getContent().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("----------------------");
		List<Patient> patients2=patientRepository.findByMalade(false);
		patients2.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("----------------------");
		List<Patient> patients3=patientRepository.findByNomContainsAndMalade("s",false);
		patients3.forEach(p->{
			System.out.println(p.toString());
		});
		patientRepository.deleteById(5L);
		System.out.println("----------------------");
		Page<Patient> pagePatients=patientRepository.findAll(PageRequest.of(0,2));
		List<Patient> Listpatients=pagePatients.getContent();
		Listpatients.forEach(p->{
			System.out.println(p.toString());
		});
	}
	

}
