package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {

		RedesController redes = new RedesController();
		String ipconfig = "";
		String ping = "";

		int op = 9;

		while (op != 0) {
			op = Integer
					.parseInt(JOptionPane.showInputDialog("1 - Visualizar IP \n2 - Visualizar PING \n0 - Sair"));

			switch (op) {
			case 1:
				redes.ip(ipconfig);
				break;

			case 2:
				redes.ping(ping);
				break;

			case 0:
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção invalida");

			}
		}

	}
}