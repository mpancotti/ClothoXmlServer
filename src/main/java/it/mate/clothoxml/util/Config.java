package it.mate.clothoxml.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Classe statica per accede alla configurazione del sistema. I file di
 * configurazione vengono letti in quest'ordine:
 * 
 * <ul>
 * <li>1) clothp.prp nel classpath (contiene i default)
 * <li>2) SE C'E' clotho.local.prp nel class path (contiene i
 * parametri locali per lo sviluppo)
 * <li>3) SE DEFINITA il file di properties puntato dalla System.properties
 * "CLOTHO_HOME" (contiene i parametri per il deploy)
 * </ul>
 * 
 * @author Michele
 * 
 */

@SuppressWarnings("serial")
public class Config extends Properties {

	private static final Logger logger = LoggerFactory
			.getLogger(Config.class);
	private static Config config = null;
	

	// singleton
	public static Config getConfigInstance() {
		String clothoHome="CLOTHO_HOME";
		
		if (config != null)
			return config;

		// creiamo e carichiamo
		config = new Config();

		// leggiamo i default della configurazione
		// approcch.properties nel classpath
		InputStream in = null;
		try {
			logger.info("Config: Reading defaults from classpath: /clotho.prp");
			//System.out.println("Config: Reading defaults from classpath: /clotho.prp");
			in = Config.class.getResourceAsStream("/clotho.prp");
			config.load(in);
			clothoHome=config.getProperty("clotho.home");
		} catch (Exception ex) {
			throw new Error("/clotho.prp not found in classpath\n");
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}

		// ridefiniamo i default della configurazione
		// approcch.local.properties nel classpath
		try {
			in = Config.class.getResourceAsStream("/clotho.local.properties");
			if (in != null) {
				logger.info("Config: Overwriting defaults from classpath: /clotho.local.properties");
				//System.out.println("Config: Overwriting defaults from classpath: /clotho.local.properties");
				config.load(in);
			}
		} catch (Exception ex) {
			throw new Error("/clotho.properties not found in classpath\n");
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}

		// leggiamo un eventuale file di configurazione esterno
		// file di properties puntato da approcch.config
		String configFile = System.getProperty(clothoHome);
		if (configFile != null) {
			logger.info("Clotho Home = "+clothoHome);
			//System.out.println("Clotho Home = "+clothoHome);
			configFile += "/conf/clotho.properties";
			loadConfig(configFile);
		} else {
			logger.info("Clotho: CLOTHO_HOME system property not found. The ${CLOTHO_HOME}/conf/clotho.properties file has not been read !");
			//System.out.println("Clotho: CLOTHO_HOME system property not found. The ${CLOTHO_HOME}/conf/clotho.properties file has not been read !");
		}

		dumpConfig();
		return config;

	}

	public static void dumpConfig() {
		logger.info("=== Config: ===");
		//System.out.println("=== Config: ===");
		for (Object i : config.keySet()) {
			logger.info(i + "=" + config.get(i));
			//System.out.println(i + "=" + config.get(i));
		}
		logger.info("===============");
		//System.out.println("===============");
	}

	public static void loadConfig(String configFile) {
		logger.info("Config: overwriting config with " + configFile);
		//System.out.println("Config: overwriting config with " + configFile);
		try {
			FileInputStream fis = new FileInputStream(configFile);
			getConfigInstance().load(fis);
			fis.close();
		} catch (Exception ex) {
			logger.error("*** Config read error: " + ex.getMessage());
			//System.out.println("*** Config read error: " + ex.getMessage());
		}
		dumpConfig();
	}

	public static String getConfig(String prp) {
		return getConfigInstance().getProperty(prp);
	}

	public static boolean isConfig(String prp) {
		String val = getConfigInstance().getProperty(prp);
		if (val != null) {
			val = val.trim();
			return val.equalsIgnoreCase("true") || val.equalsIgnoreCase("1");
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(Config.getConfig("input.file"));
	}
}
