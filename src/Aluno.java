import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nomeAluno;
	private int raAluno;
	private int [] notasAluno;

	public Aluno(String nome, int ra, int numeroDeNotas) {
		setNomeAluno(nome);
		setRaAluno(ra);
		setNotasAluno (new int[numeroDeNotas]);
		
	}
	
	// GETS
	public String getNomeAluno() {
		return nomeAluno;
	}
	
	public int getRaAluno() {
		return raAluno;
	}
	
	public int[] getNotasAluno() {
		return notasAluno;
	}
	//SETS
	public void setNomeAluno (String nome) {
		nomeAluno = nome;
	}
	
	public void setRaAluno (int ra) {
		raAluno = ra;
	}
	public void setNotasAluno(int[] notas) {
		notasAluno = notas;
	}
	//modifica nota:
	
	public void setNotaAlunoAtividade(int atividade, int nota) {
        int[] notasAtuais = getNotasAluno();
        if (atividade >= 0 && atividade < notasAtuais.length) {
            notasAtuais[atividade] = nota;
        }
    }
	
	
	//Clculo da média:
	public double calculaMedia() {
        double soma = 0;
        int[] notas = getNotasAluno();
        
        for (int nota : notas) {
            soma += nota;
        }
        
        return (double) soma / notas.length;
    }
	
}


