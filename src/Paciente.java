import java.util.*;

public class Paciente {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    private List<String> historico; //historico de doenças
    private List<String> medicamento; // lista de medicamentos
    private List<String> dispositivo; // lista de dispositivos medicos
    private List<String> consulta; // armazenar informações sobre consulta

    //Construtor
    public Paciente(String Nome, String Cpf, String DataNascimento, String Endereço, String Telefone, String Email) {

        this.nome = Nome;
        this.cpf = Cpf;
        this.dataNascimento = DataNascimento;
        this.endereco = Endereço;
        this.telefone = Telefone;
        this.email = Email;
        this.historico = new ArrayList<>();
        this.medicamento = new ArrayList<>();
        this.dispositivo = new ArrayList<>();
        this.consulta = new ArrayList<>();
    }

    //Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void addHistorico(String Doença) {
        this.historico.add(Doença);
    }

    public List<String> getMedicamento() {
        return medicamento;
    }

    public void addMedicamento(String Medicamentos) {
        this.medicamento.add(Medicamentos);
    }

    public List<String> getDispositivo() {
        return dispositivo;
    }

    public void addDispositivo(String Dispositivos) {
        this.dispositivo.add(Dispositivos);

    }

    public void addConsulta(String data, String motivo){
        this.consulta.add(data + " - " + motivo);
    }

    //Método para exibir dados do paciente
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Cpf: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("Histótico de Doenças: " + historico);
        System.out.println("Medicamentos: " + medicamento);
        System.out.println("Dispositivos: " + dispositivo);
        System.out.println("Consultas: " + consulta);
    }
}


