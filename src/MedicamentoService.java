import java.util.ArrayList;
import java.util.List;
public class MedicamentoService {
    private List<Medicamento> medicamentosPrescritos;

    // Construtor
    public MedicamentoService() {
        medicamentosPrescritos = new ArrayList<>();
    }

    // Método para prescrever medicamento
    public Medicamento prescreverMedicamento(String nome, String dosagem, String frequencia, String descricao, Medico medico) {
        Medicamento medicamento = new Medicamento(nome, dosagem, frequencia, descricao, medico);
        medicamentosPrescritos.add(medicamento);
        return medicamento;
    }

    // Método para cancelar a prescrição de um medicamento
    public void cancelarPrescricao(int index) {
        if (index >= 0 && index < medicamentosPrescritos.size()) {
            medicamentosPrescritos.remove(index);
        }
    }

    // Método para consultar todos os medicamentos prescritos
    public List<Medicamento> consultarMedicamentos() {
        return medicamentosPrescritos;
    }
}
