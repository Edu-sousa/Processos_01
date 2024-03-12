package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	private String os() {

		String os = System.getProperty("os.name");
		return os;
	}

	public void ip(String process) {

		String os = os();
		if (os.contains("Windows"))
			process = "ipconfig";
		else if (os.contains("Linux"))
			process = "ifconfig";

		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			String adaptador = "";
			while (linha != null) {

				if (linha.contains("Adaptador")) {
					adaptador = linha;
				} else if (linha.contains("IPv4")) {
					System.out.println(adaptador);
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ping(String process) {

		String os = os();
		if (os.contains("Windows"))
			process = "ping -4 -n 10 www.google.com.br";
		else if (os.contains("Linux"))
			process = "ping -4 -c 10 www.google.com.br";

		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			String[] mediaVetor = null;

			while (linha != null) {

				mediaVetor = linha.split(" ");
				System.out.println("Calculando ...");

				linha = buffer.readLine();
			}
			String Media = mediaVetor[mediaVetor.length - 1];
			System.out.println("Media do Ping " + Media);

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
