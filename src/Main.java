import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Consultar histórico do paciente");
            System.out.println("3. Atualizar dados do paciente");
            System.out.println("4. Consultar dados do paciente");
            System.out.println("5. Agendar consulta médica");
            System.out.println("6. Registrar médico");
            System.out.println("7. Consultar dados do médico");
            System.out.println("8. Atualizar dados do médico");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine();
            if (!entrada.matches("[1-9]")){
                System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 6.");
                continue;
            }

            int opcao = Integer.parseInt(entrada);

            switch (opcao) {
                case 1: //Registrar paciente
                    registrarPaciente(scanner, pacientes);
                    break;

                case 2: // Consultar histórico do paciente
                    consultarHistorico(scanner, pacientes);
                    break;

                case 3: // Atualizar dados do paciente
                    atualizarDados(scanner, pacientes);
                    break;

                case 4: // Consultar dados do paciente
                    consultarDados(scanner, pacientes);
                    break;

                case 5: // Agendar consulta médica
                    agendarConsulta(scanner, pacientes);
                    break;

                case 6: // Registrar médico
                    registrarMedico(scanner, medicos);
                    break;

                case 7: // Consultar dados do médico
                    consultarMedico(scanner, medicos);
                    break;

                case 8: // Atualizar dados do médico
                    atualizarMedico(scanner, medicos);
                    break;

                case 9: // Sair
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para registrar um paciente
    private static void registrarPaciente(Scanner scanner, List<Paciente> pacientes) {
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine().trim();
        while (nome.isEmpty()) {
            System.out.println("O nome não pode ficar em branco. Tente novamente.");
            nome = scanner.nextLine().trim();
        }

        String cpf;
        boolean cpfValido = false;
        do {
            System.out.print("Digite o CPF do paciente (somente números, 11 dígitos): ");
            cpf = scanner.nextLine().trim();
            if (cpf.isEmpty()) {
                System.out.println("O CPF não pode ficar em branco. Tente novamente.");
            }else if (!cpf.matches("\\d{11}")) {
                System.out.println("CPF inválido. Certifique-se de digitar apenas números com 11 dígitos.");
                cpfValido = false;
            } else {
                String finalCpf = cpf;
                if (pacientes.stream().anyMatch(p -> p.getCpf().equals(finalCpf))) {
                    System.out.println("CPF ja cadastrado. Tente novamente.");
                    cpfValido = false;
                } else {
                    cpfValido = true;
                }
            }
        } while (!cpfValido);

        System.out.print("Digite a data de nascimento do paciente (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine().trim();
        while (dataNascimento.isEmpty() || !dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
            if (dataNascimento.isEmpty()) {
                System.out.println("A Data de nascimento não pode ficar em branco. Tente novamente.");
            } else {
                System.out.println("Data de nascimento inválida. Certifique-se de seguir o padrão dd/mm/aaaa.");
            }
            dataNascimento = scanner.nextLine().trim();
        }

        System.out.print("Digite o endereço do paciente: ");
        String endereco = scanner.nextLine().trim();
        while (endereco.isEmpty()) {
            System.out.println("O endereço não pode ficar em branco. Tente novamente.");
            endereco = scanner.nextLine().trim();
        }


        System.out.print("Digite o telefone do paciente (somente números, incluindo DDD (Ex: 51 9 12345678)): ");
        String telefone = scanner.nextLine().trim();
        while (telefone.isEmpty() || !telefone.matches("\\d{11}")) {
            if (telefone.isEmpty()){
                System.out.println("O telefone não pode ficar em branco. Tente novamente.");
            } else {
                System.out.println("Telefone inválido. Certifique-se de digitar apenas números, incluindo DDD(Ex: 51 9 12345678).");
            }
            telefone = scanner.nextLine().trim().replaceAll("\\s+", "");
        }
        System.out.print("Digite o email do paciente: ");
        String email = scanner.nextLine().trim();
        while (email.isEmpty()) {
            System.out.println("O email não pode ficar em branco. Tente novamente.");
            email = scanner.nextLine().trim();
        }


        Paciente novoPaciente = new Paciente(nome, cpf, dataNascimento, endereco, telefone, email);
        pacientes.add(novoPaciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    // Método para consultar histórico do paciente
    private static void consultarHistorico(Scanner scanner, List<Paciente> pacientes) {
        Paciente paciente = selecionarPaciente(scanner, pacientes);
        if (paciente != null) {
            System.out.println("\nHistórico do paciente " + paciente.getNome() + ":");
            System.out.println("Doenças: " + paciente.getHistorico());
            System.out.println("Medicamentos: " + paciente.getMedicamento());
            System.out.println("Dispositivos: " + paciente.getDispositivo());
        }
    }

    // Método para atualizar dados do paciente
    private static void atualizarDados(Scanner scanner, List<Paciente> pacientes) {
        Paciente paciente = selecionarPaciente(scanner, pacientes);
        if (paciente != null) {
            while (true) {
                System.out.println("\n--- Atualizar Dados do Paciente ---");
                System.out.println("1. Nome");
                System.out.println("2. Endereço");
                System.out.println("3. Telefone");
                System.out.println("4. Email");
                System.out.println("5. Sair");
                System.out.print("Escolha o dado que deseja alterar: ");

                int escolha = Integer.parseInt(scanner.nextLine());
                switch (escolha) {
                    case 1:
                        System.out.print("Novo nome: ");
                        paciente.setNome(scanner.nextLine());
                        System.out.println("Nome atualizado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Novo endereço: ");
                        paciente.setEndereco(scanner.nextLine());
                        System.out.println("Endereço atualizado com sucesso!");
                        break;

                    case 3:
                        System.out.print("Novo telefone: ");
                        paciente.setTelefone(scanner.nextLine());
                        System.out.println("Telefone atualizado com sucesso!");
                        break;

                    case 4:
                        System.out.print("Novo email: ");
                        paciente.setEmail(scanner.nextLine());
                        System.out.println("Email atualizado com sucesso!");
                        break;

                    case 5:
                        System.out.println("Finalizando a atualização.");
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    // Método para consultar dados do paciente
    private static void consultarDados(Scanner scanner, List<Paciente> pacientes) {
        Paciente paciente = selecionarPaciente(scanner, pacientes);
        if (paciente != null) {
            System.out.println("\nDados do paciente:");
            paciente.exibirDados();
        }
    }

    // Método para agendar consulta médica
    private static void agendarConsulta(Scanner scanner, List<Paciente> pacientes) {
        Paciente paciente = selecionarPaciente(scanner, pacientes);
        if (paciente != null) {

            System.out.print("Digite a data da consulta (dd/mm/aaaa): ");
            String dataConsulta = scanner.nextLine();


            System.out.print("Digite o motivo da consulta: ");
            String motivoConsulta = scanner.nextLine();

            paciente.addConsulta(dataConsulta, motivoConsulta);

            System.out.print("Deseja adicionar doenças ao histórico? (sim/não): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("sim")) {
                while (true) {
                    System.out.print("Digite o nome da doença (ou deixe em branco para sair): ");
                    String doenca = scanner.nextLine();
                    if (doenca.isBlank()) break;
                    paciente.addHistorico(doenca);
                }
            }

            System.out.print("Deseja adicionar medicamentos? (sim/não): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("sim")) {
                while (true) {
                    System.out.print("Digite o nome do medicamento (ou deixe em branco para sair): ");
                    String medicamento = scanner.nextLine();
                    if (medicamento.isBlank()) break;
                    paciente.addMedicamento(medicamento);
                }
            }

            System.out.print("Deseja adicionar dispositivos médicos? (sim/não): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("sim")) {
                while (true) {
                    System.out.print("Digite o nome do dispositivo (ou deixe em branco para sair): ");
                    String dispositivo = scanner.nextLine();
                    if (dispositivo.isBlank()) break;
                    paciente.addDispositivo(dispositivo);
                }
            }

            System.out.println("Consulta agendada com sucesso para " + dataConsulta + "!");
        }
    }

    // Método auxiliar para selecionar um paciente
    private static Paciente selecionarPaciente(Scanner scanner, List<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return null;
        }

        System.out.println("\nPacientes disponíveis:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNome() + " (CPF: " + pacientes.get(i).getCpf() + ")");
        }

        System.out.print("Selecione o número do paciente: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= pacientes.size()) {
            System.out.println("Paciente inválido.");
            return null;
        }

        return pacientes.get(index);
    }

    private static void registrarMedico(Scanner scanner, List<Medico> medicos) {
        System.out.print("Digite o nome do médico: ");
        String nome = scanner.nextLine().trim();
        while (nome.isEmpty()) {
            System.out.println("O nome não pode ficar em branco. Tente novamente.");
            nome = scanner.nextLine().trim();
        }

        String crm;
        boolean crmValido = false;
        do {
            System.out.print("Digite o CRM do médico (somente números, 6 dígitos): ");
            crm = scanner.nextLine().trim();
            if (crm.isEmpty()) {
                System.out.println("O CRM não pode ficar em branco. Tente novamente.");
            }else if (!crm.matches("\\d{6}")) {
                System.out.println("CRM inválido. Certifique-se de digitar apenas números com 6 dígitos.");
                crmValido = false;
            } else {
                String finalCrm = crm;
                if (medicos.stream().anyMatch(p -> p.getCrm().equals(finalCrm))) {
                    System.out.println("CPF ja cadastrado. Tente novamente.");
                    crmValido = false;
                } else {
                    crmValido = true;
                }
            }
        } while (!crmValido);

        System.out.print("Digite a especialidade do médico: ");
        String especialidade = scanner.nextLine().trim();
        while (especialidade.isEmpty()) {
            System.out.println("A especialidade não pode ficar em branco. Tente novamente.");
            especialidade = scanner.nextLine().trim();
        }

        System.out.print("Digite o telefone do médico: ");
        String telefone = scanner.nextLine().trim();
        while (telefone.isEmpty() || !telefone.matches("\\d{11}")) {
            if (telefone.isEmpty()) {
                System.out.println("O telefone não pode ficar em branco. Tente novamente.");
            } else {
                System.out.println("Telefone inválido. Certifique-se de digitar apenas números com 11 dígitos.");
            }
            telefone = scanner.nextLine().trim();
        }

        System.out.print("Digite o email do médico: ");
        String email = scanner.nextLine().trim();
        while (email.isEmpty()) {
            System.out.println("O email não pode ficar em branco. Tente novamente.");
            email = scanner.nextLine().trim();
        }

        Medico novoMedico = new Medico(nome, crm, especialidade, telefone, email);
        medicos.add(novoMedico);
        System.out.println("Médico cadastrado com sucesso!");
    }

    private static void consultarMedico(Scanner scanner, List<Medico> medicos) {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }

        System.out.println("\nMédicos disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + ". " + medicos.get(i).getNome() + " (CRM: " + medicos.get(i).getCrm() + ")");
        }

        System.out.print("Selecione o número do médico: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= medicos.size()) {
            System.out.println("Médico inválido.");
            return;
        }

        Medico medico = medicos.get(index);
        medico.exibirDados();
    }

    private static void atualizarMedico(Scanner scanner, List<Medico> medicos) {
        Medico medico = selecionarMedico(scanner, medicos);
        if (medico != null) {
            while (true) {
                System.out.println("\n--- Atualizar Dados do Médico ---");
                System.out.println("1. Nome");
                System.out.println("2. Especialidade");
                System.out.println("3. Telefone");
                System.out.println("4. Email");
                System.out.println("5. Sair");
                System.out.print("Escolha o dado que deseja alterar: ");

                int escolha = Integer.parseInt(scanner.nextLine());
                switch (escolha) {
                    case 1:
                        System.out.print("Novo nome: ");
                        medico.setNome(scanner.nextLine().trim());
                        System.out.println("Nome atualizado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Nova especialidade: ");
                        medico.setEspecialidade(scanner.nextLine().trim());
                        System.out.println("Especialidade atualizada com sucesso!");
                        break;

                    case 3:
                        System.out.print("Novo telefone: ");
                        medico.setTelefone(scanner.nextLine().trim());
                        System.out.println("Telefone atualizado com sucesso!");
                        break;

                    case 4:
                        System.out.print("Novo email: ");
                        medico.setEmail(scanner.nextLine().trim());
                        System.out.println("Email atualizado com sucesso!");
                        break;

                    case 5:
                        System.out.println("Finalizando a atualização.");
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    private static Medico selecionarMedico(Scanner scanner, List<Medico> medicos) {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return null;
        }

        System.out.println("\nMédicos disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + ". " + medicos.get(i).getNome());
        }

        System.out.print("Selecione o número do médico: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= medicos.size()) {
            System.out.println("Médico inválido.");
            return null;
        }

        return medicos.get(index);
    }
}