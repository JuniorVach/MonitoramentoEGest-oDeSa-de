import java.util.ArrayList;
import java.util.List;

public class Medico {
    private String nome;
    private String crm; // Registro médico único
    private String especialidade;
    private String telefone;
    private String email;
    private List<String> consultasRealizadas; // Histórico de consultas

    // Construtor
    public Medico(String nome, String crm, String especialidade, String telefone, String email) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
        this.consultasRealizadas = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getConsultasRealizadas() {
        return consultasRealizadas;
    }

    public void addConsultaRealizada(String consulta) {
        this.consultasRealizadas.add(consulta);
    }

    // Método para exibir os dados do médico
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CRM: " + crm);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("Consultas realizadas: " + consultasRealizadas);
    }
}