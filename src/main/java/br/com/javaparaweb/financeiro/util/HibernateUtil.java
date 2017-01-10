package br.com.javaparaweb.financeiro.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			registradorServico.applySettings(cfg.getProperties());
			StandardServiceRegistry servico = registradorServico.build();
			return cfg.buildSessionFactory();
		}catch(Throwable e){
			System.out.println("Criacão inicial do objeto SessioFactory falhou. Erro: "+ e);
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
