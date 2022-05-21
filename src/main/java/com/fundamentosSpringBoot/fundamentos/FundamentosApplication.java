package com.fundamentosSpringBoot.fundamentos;

import com.fundamentosSpringBoot.fundamentos.Pojo.Pojo;
import com.fundamentosSpringBoot.fundamentos.bean.*;
import com.fundamentosSpringBoot.fundamentos.component.ComponentDependency;

import com.fundamentosSpringBoot.fundamentos.entity.Uzer;
import com.fundamentosSpringBoot.fundamentos.repository.UzerRepository;
import com.fundamentosSpringBoot.fundamentos.service.UzerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private PersonaInterface personaInterface;
	private CarreraF1Interface carreraF1Interface;
	private CarreraF1Interface carreraF1InterfaceConParametros;
	private MyBeanProperties myBeanProperties;
	private Pojo pojo;
	private UzerRepository uzerRepository;
	private UzerService uzerService;

	public FundamentosApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency, PersonaInterface personaInterface,
								  CarreraF1Interface carreraF1Interface, MyBeanProperties myBeanProperties, Pojo pojo,
								  UzerRepository uzerRepository, UzerService uzerService) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.personaInterface = personaInterface;
		this.carreraF1Interface = carreraF1Interface;
		this.myBeanProperties = myBeanProperties;
		this.pojo = pojo;
		this.uzerRepository = uzerRepository;
		this.uzerService = uzerService;
	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUzer();
		savedWithErrorTransactional();
	}

	private void savedWithErrorTransactional(){
		Uzer test1 = new Uzer("Test1 transactional","test1transactional@domain.com", LocalDate.of(1993, 01,24));
		Uzer test2 = new Uzer("Test2 transactional","test2transactional@domain.com", LocalDate.of(1993, 01,24));
		Uzer test3 = new Uzer("Test3 transactional","test3transactional@domain.com", LocalDate.of(1993, 01,24));
		Uzer test4 = new Uzer("Test4 transactional","test4transactional@domain.com", LocalDate.of(1993, 01,24));

		List<Uzer> uzers = Arrays.asList(test1, test2, test3, test4);

		try {
			uzerService.saveTransactional(uzers);
		}catch(Exception e){
				LOGGER.error("Esto es una excepción dentro del método transactional "+ e);

			/* Que mediante el uzerService obtenga todos los usarios                               	
			el punto stream para que los muestre y por cada usuario muestre por pantalla
			el mensaje que aparece en el logger.info*/
				uzerService.getAllUzers().stream()
						.forEach(uzer ->
								LOGGER.info("Este es el usuario dentro del método transactional"));
		}
	}

	private void getInformationJpqlFromUzer(){
		LOGGER.info("Usuario con el método query FindByUzerEmail: " +
				uzerRepository.findByUzerEmail("andres@domain.com")
					.orElseThrow(() -> new RuntimeException("No se encontró el usuario")));

		uzerRepository.findAndSort("user", Sort.by("id").descending())
			.stream()
			.forEach(uzer -> LOGGER.info("El usuario con método sort "+ uzer));

		uzerRepository.findByName("user1")
			.stream()
			.forEach(uzer -> LOGGER.info("Usuario con query method" + uzer));

		LOGGER.info("Usuario con query method indByEmilAndName"+ uzerRepository.findByEmailAndName("jana@domain.com", "user7")
			.orElseThrow(() -> new RuntimeException(("usuario no encontrado"))));

		uzerRepository.findByNameLike("%u%")
			.stream()
			.forEach(uzer -> LOGGER.info("Usuario byNameLike: "+ uzer));

		/*LOGGER.info("El usuario de a partir del namedParameter es: "+ uzerRepository.getAllByBirthDateAndEmail(LocalDate.of(2019,01, 9),
						"julianita@domain.com")
				.orElseThrow(() ->
						new RuntimeException("No se encontró el usuario a partir del namedParameter")));*/
	}

	private void saveUsersInDataBase(){
		Uzer user1 = new Uzer("user1","john@domain.com", LocalDate.of(2021,03, 1));
		Uzer user2 = new Uzer("user2","andres@domain.com", LocalDate.of(2020,02, 2));
		Uzer user3 = new Uzer("user3","julian@domain.com", LocalDate.of(2029,01,3));
		Uzer user4 = new Uzer("user4","jaime@domain.com", LocalDate.of(2028,05, 4));
		Uzer user5 = new Uzer("user5","jaramilllo@domain.com", LocalDate.of(2023,03, 5));
		Uzer user6 = new Uzer("user6","jermain@domain.com", LocalDate.of(2027,03, 6));
		Uzer user7 = new Uzer("user7","jana@domain.com", LocalDate.of(2023,03, 7));
		Uzer user8 = new Uzer("user8","john@domain.com", LocalDate.of(2022,07, 8));
		Uzer user9 = new Uzer("user9","julianita@domain.com", LocalDate.of(2019,01, 9));
		Uzer user10 = new Uzer("user10","juan@domain.com", LocalDate.of(2010,12, 10));

		List<Uzer> listUser = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		listUser.stream().forEach(uzerRepository::save);
	}

	public void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		personaInterface.saludar("Iván",29);
		carreraF1Interface.mostrarNombreCircuito("Spa Francorchamps", "Belgica");
		System.out.println(myBeanProperties.function());
		System.out.println(pojo.getAge()+"_"+pojo.getEmail()+"-"+pojo.getPassword());
		LOGGER.error("Esto es un error");
	}

}
