import java.util.Scanner;

public class ContaTerminal {
    public static void main(String... args) throws Exception {
        int numeroDaConta = 0;
        String numeroDaAgencia = "";
        String nomeDoCliente = "";
        double saldo = 0.00;
        boolean insercaoValida = false;

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Por favor, insira o numero da conta: ");
                numeroDaConta = scanner.nextInt();
                insercaoValida = true;
            } catch (Exception e) {
                scanner.next();
                System.out.println("Valor invalido. Digite um numero inteiro.");
            }
        } while (!insercaoValida);

        insercaoValida = false;
        do {
            try {
                System.out.print("Por favor, insira o numero da agencia: ");
                numeroDaAgencia = scanner.next();
                if (numeroDaAgencia.length() != 4) {
                    throw new IllegalArgumentException();
                }
                insercaoValida = true;
                numeroDaAgencia = numeroDaAgencia.substring(0, 3) + "-" + numeroDaAgencia.substring(3);
            } catch (Exception e) {
                System.out.println("Valor invalido. Insira uma conta com 4 digitos.");
            }
        } while (!insercaoValida);

        insercaoValida = false;
        while (!insercaoValida) {
            try {
                System.out.print("Por favor, insira o nome do cliente: ");
                nomeDoCliente = scanner.next();
                if (nomeDoCliente.length() <= 2) {
                    throw new IllegalArgumentException();
                }
                insercaoValida = true;
            } catch (Exception e) {
                System.out.println("Valor invalido. Nome dever ter mais de 2 caracteres.");
            }
        }

        insercaoValida = false;
        while (!insercaoValida) {
            try {
                System.out.print("Por favor, insira o valor do saldo: ");
                saldo = scanner.nextDouble();
                insercaoValida = true;
            } catch (Exception e) {
                scanner.next();
                System.out.println("Valor invalido. Insira um numero.");
            }
        }

        scanner.close();

        final String mensagem = "Olá " + nomeDoCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + numeroDaAgencia + ", conta " + numeroDaConta + " e seu saldo " +
                String.format("%.2f", saldo ) + " já está disponível para saque";
        System.out.println(mensagem);

    }
}