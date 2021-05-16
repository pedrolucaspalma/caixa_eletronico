import java.util.Scanner;

public final class Registrador {
	private Scanner input = new Scanner(System.in);

	public float lerFloat(String mensagem) {
		System.out.printf("%s: ", mensagem);
		String entrada = input.nextLine();

		for (int i = 0; i < entrada.length(); i++) {
			if (Character.isDigit(entrada.charAt(i))) {
				continue;
			} else {
				return lerInt("Entrada invalida. Por favor, digite novamente");
			}
		}

		return entrada.isEmpty() ? lerInt("Entrada invalida. Por favor, digite novamente") : Float.parseFloat(entrada);
	}

	public int lerInt(String mensagem) {
		System.out.printf("%s: ", mensagem);
		String entrada = input.nextLine();

		for (int i = 0; i < entrada.length(); i++) {
			if (Character.isDigit(entrada.charAt(i))) {
				continue;
			} else {
				return lerInt("Entrada invalida. Por favor, digite novamente");
			}
		}

		return entrada.isEmpty() ? lerInt("Entrada invalida. Por favor, digite novamente") : Integer.parseInt(entrada);
	}

	public String lerString(String mensagem) {
		System.out.printf("%s: ", mensagem);
		return input.nextLine();
	}

	public String lerData(String mensagem) {
		System.out.printf("%s [dd/mm/aaaa]: ", mensagem);
		String data = input.nextLine();

		if (data.length() != 10) {
			return lerData("Data invalida. Por favor, digite a data novamente");
		}

		for (int i = 0; i < data.length(); i++) {
			if (i == 2 || i == 5) {
				if (data.charAt(i) == '/') {
					continue;
				} else {
					return lerData("Data invalida. Por favor, digite a data novamente");
				}
			} else {
				if (Character.isDigit((data.charAt(i)))) {
					continue;
				} else {
					return lerData("Data invalida. Por favor, digite a data novamente");
				}
			}
		}

		return data.isEmpty() ? lerData("Data invalida. Por favor, digite a data novamente") : data;
	}

	public String lerCPF(String mensagem) {
		System.out.printf("%s [000.000.000-00]: ", mensagem);
		String cpf = input.nextLine();

		if (cpf.length() != 14)
			return lerCPF("CPF invalido. Por favor, digite o CPF novamente");

		for (int i = 0; i < cpf.length(); i++) {
			if (i == 3 || i == 7) {
				if (cpf.charAt(i) == '.')
					continue;
				else
					return lerCPF("CPF invalido. Por favor, digite o CPF novamente");
			}

			else if (i == 11) {
				if (cpf.charAt(i) == '-')
					continue;
				else
					return lerCPF("CPF invalido. Por favor, digite o CPF novamente");
			}

			else {
				if (Character.isDigit(cpf.charAt(i)))
					continue;
				else
					return lerCPF("CPF invalido. Por favor, digite o CPF novamente");
			}
		}

		return cpf.isEmpty() ? lerCPF("CPF invalido. Por favor, digite o CPF novamente") : cpf;
	}

	public String lerEmail(String mensagem) {
		System.out.printf("%s [user@email.com]: ", mensagem);
		String email = input.nextLine();
		return email.isEmpty() ? lerEmail("Email invalido. Por favor, digite o Email novamente") : email;
	}

	public String lerTelefone(String mensagem) {
		System.out.printf("%s [+00 00 00000-0000]: ", mensagem);
		String telefone = input.nextLine();
		return telefone.isEmpty() ? lerTelefone("Telefone invalido. Por favor, digite o Telefone novamente") : telefone;
	}

	public String lerValor(String mensagem) {
		System.out.printf("%s: ", mensagem);
		String valor = input.nextLine();
		return valor.isEmpty() ? lerValor("Valor invalido. Por favor, digite o valor novamente") : valor;
	}
}
