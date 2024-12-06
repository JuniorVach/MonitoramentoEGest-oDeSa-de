import java.util.Date;

public class Medicamento {
    private String nome;
    private String dosagem;
    private String frequencia;
    private String descricao;
    private Medico medico; // Médico que prescreveu o medicamento
    private Date dataPrescricao;

    // Construtor
    public Medicamento(String nome, String dosagem, String frequencia, String descricao, Medico medico) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.descricao = descricao;
        this.medico = medico;
        this.dataPrescricao = new Date();  // Data atual
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método para exibir os dados do medicamento
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Dosagem: " + dosagem);
        System.out.println("Frequência: " + frequencia);
        System.out.println("Descrição: " + descricao);
        System.out.println("Médico responsável: " + medico.getNome());
        System.out.println("Data da prescrição: " + dataPrescricao);
    }
}
