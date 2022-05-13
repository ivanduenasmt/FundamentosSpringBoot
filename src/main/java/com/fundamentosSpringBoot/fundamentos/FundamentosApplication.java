package com.fundamentosSpringBoot.fundamentos;

import com.fundamentosSpringBoot.fundamentos.Pojo.Pojo;
import com.fundamentosSpringBoot.fundamentos.bean.*;
import com.fundamentosSpringBoot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private PersonaInterface personaInterface;
	private CarreraF1Interface carreraF1Interface;
	private CarreraF1Interface carreraF1InterfaceConParametros;
	private MyBeanProperties myBeanProperties;
	private Pojo pojo;

	public FundamentosApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency, PersonaInterface personaInterface,
								  CarreraF1Interface carreraF1Interface, MyBeanProperties myBeanProperties, Pojo pojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.personaInterface = personaInterface;
		this.carreraF1Interface = carreraF1Interface;
		this.myBeanProperties = myBeanProperties;
		this.pojo = pojo;
	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		personaInterface.saludar("Iván",29);
		carreraF1Interface.mostrarNombreCircuito("Spa Francorchamps", "Belgica");
		System.out.println(myBeanProperties.function());
		System.out.println(pojo.getAge()+"_"+pojo.getEmail()+"-"+pojo.getPassword());
	}
}
