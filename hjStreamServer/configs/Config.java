package configs;


import java.io.*;
import java.util.*;

public class Config{

 private String cipherSuite;
 private String key;
 private String iv;
 private String integrity;
 private String mackey;
 
 	public Config()throws FileNotFoundException, IOException{
 	
	 	 InputStream inputStream = new FileInputStream("configs/box-cryptoconfig");
		if (inputStream == null) {
		    System.err.println("Configuration file not found!");
		    System.exit(1);
		}
		Properties properties = new Properties();
		properties.load(inputStream);
		
		//String remote = properties.getProperty("remote");
		cipherSuite = properties.getProperty("ciphersuite");
		key = properties.getProperty("key");
		iv = properties.getProperty("iv");
		integrity = properties.getProperty("integrity");
        	mackey = properties.getProperty("mackey");
 	}

	public String getCipherSuite(){
		return cipherSuite;
	}
	
	public byte[] getKey(){
		return key.getBytes();
	}
	
	public String getAlgorithm(){
		return cipherSuite.split("/")[0];
	}
	
	public byte[] getIv(){
		return iv.getBytes();
	}
	public String getIntegrity(){
		return integrity;
	}
	public String getMackey(){
		return mackey;
	}




}
