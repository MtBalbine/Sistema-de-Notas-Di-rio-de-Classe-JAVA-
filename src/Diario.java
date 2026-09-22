import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Importação necessária para o menu interativo
import java.util.InputMismatchException;

public class Diario {
	
	private String histogramaNotas;
    private String nomeMateria;
    private List<Aluno> listaAluno;
    private int numeroDeNotas;

    public Diario(String materia, int numero) {
    	setNomeMateria(materia);
    	setNumeroDeNotas(numero);
    	setListaAluno(new ArrayList<>());
    }
    
    // GETS
    public String getHistogramaNotas () {
    	return histogramaNotas;
    }
    
    public String getNomeMateria() {
    	return nomeMateria;
    }
    
    public int getNumeroDeNotas() {
    	return numeroDeNotas;
    }
    
    public List<Aluno> getListaAluno(){
    	return listaAluno;
    }
    
    // SETS 
    public void setHistogramaNotas (String histograma) {
    	histogramaNotas = histograma; 
    }
    
    public void setNomeMateria (String materia) {
    	nomeMateria = materia;
    }
    
    public void setNumeroDeNotas (int numero) {
    	numeroDeNotas = numero;
    }
    
    public void setListaAluno (List<Aluno> lista) {
    	listaAluno = lista;
    }
    
    // METODOS
    // adiciona um novo aluno
    public void adicionarAluno (String nome, int ra) {
    	Aluno novoAluno = new Aluno(nome, ra, getNumeroDeNotas());
    	getListaAluno().add(novoAluno);
    	System.out.println("Aluno " + nome + " cadastrado com sucesso.");
    }
    
	// modifica alguma nota de algum aluno
    public void modificarNotaAluno(String nomeAluno, int atividade, int novaNota) {
    	// busca pelo nome
    	for (Aluno aluno : getListaAluno()) {
    		if (aluno.getNomeAluno().equalsIgnoreCase(nomeAluno)) {
    			aluno.setNotaAlunoAtividade(atividade, novaNota);
                System.out.println("Nota atualizada com sucesso.");
    			return;
    		}
    	}
    	System.out.println("Aluno não encontrado.");
    }
    
	// gera relatório de notas
    public void gerarRelatorioNotas() {
        if (getListaAluno().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado no diário.");
            return;
        }

        System.out.println(" Relatório de Notas: " + getNomeMateria() );
        
        int maiorNota = -1;
        int atividadeMaior = -1;
        String alunoMaior = "";

        int menorNota = 101; 
        int atividadeMenor = -1;
        String alunoMenor = "";

        int[] histograma = new int[10]; // guardar a contagem do histograma (0-90)

        // Passa por todos os alunos
        for (Aluno aluno : getListaAluno()) {
            System.out.print("Nome: " + aluno.getNomeAluno() + " | Notas: ");
            
            int[] notas = aluno.getNotasAluno();
            
            for (int i = 0; i < notas.length; i++) {
                int nota = notas[i];
                System.out.print(nota + " ");
                
                // maior nota, salvando de quem foi e de qual atividade
                if (nota > maiorNota) {
                    maiorNota = nota;
                    atividadeMaior = i;
                    alunoMaior = aluno.getNomeAluno();
                }
                
                // menor nota, salvando de quem foi e de qual atividade
                if (nota < menorNota) {
                    menorNota = nota;
                    atividadeMenor = i;
                    alunoMenor = aluno.getNomeAluno();
                }
                
                // Prepara o histograma
                int indice = nota / 10;
                if (indice == 10) 
                	{
                		indice = 9; // Agrupa o 100 na casa dos 90
                	}
                histograma[indice]++;
            }
            // média do aluno
            System.out.printf("| Média: %.2f\n", aluno.calculaMedia());
        }

        // Impressão da maior e menor nota com atividade e aluno
        System.out.println("\nMaior Nota Geral: " + maiorNota + " (Atividade " + atividadeMaior + " - Aluno: " + alunoMaior + ")"); 
        System.out.println("Menor Nota Geral: " + menorNota + " (Atividade " + atividadeMenor + " - Aluno: " + alunoMenor + ")");
        
        // Imprime o histograma com asteriscos
        System.out.println("\n\t Histograma de Notas:");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d - %2d: %d\n", (i * 10), (i * 10 + 9), histograma[i]);
        }
    }
    
 // MAIN
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== CONFIGURAÇÃO INICIAL =====");
        System.out.print("Digite o nome da matéria: ");
        String materiaInput = scanner.nextLine();
        
        int qtdNotas = 0;
        
        
        while (true) {
            try {
                System.out.print("Quantas notas (N) essa matéria terá? ");
                qtdNotas = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do teclado
                
                if (qtdNotas > 0) {
                    break; // Sai do loop se o número for válido (maior que zero)
                }
                System.out.println("Por favor, digite um número maior que zero.");
                
            } catch (InputMismatchException e) {
                System.out.println("[ERRO] Entrada inválida! Digite apenas números inteiros.");
                scanner.nextLine(); // Limpa o caractere errado que causou o erro
            }
        }
        
        // Cria o diário com a quantidade de notas definida pelo usuário
        Diario POO = new Diario(materiaInput, qtdNotas);
        System.out.println("\nDiário de '" + materiaInput + "' criado para " + qtdNotas + " notas!");
        
        int opcao = 0;

        // Loop principal do menu interativo
        while (opcao != 4) {
            System.out.println("\nMENU DO DIÁRIO:");
            System.out.println("1 - Adicionar um novo aluno");
            System.out.println("2 - Modificar nota de um aluno");
            System.out.println("3 - Gerar relatório de notas");
            System.out.println("4 - Sair do sistema");
            System.out.print("Escolha uma opção: ");
            
            // O try-catch envolve todo o menu. Se o usuário digitar letra em QUALQUER
            // lugar que pedia número (opção, RA, índice ou nota), ele cai no catch.
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa teclado após ler o número
                
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do aluno: ");
                        String nome = scanner.nextLine();
                        
                        System.out.print("Digite o RA numérico do aluno: ");
                        int ra = scanner.nextInt();
                        scanner.nextLine(); // Limpa buffer
                        
                        POO.adicionarAluno(nome, ra);
                        break;
                        
                    case 2:
                        System.out.println("\nLista de Alunos:");
                        if (POO.getListaAluno().isEmpty()) {
                            System.out.println("Nenhum aluno cadastrado no momento.");
                            break; 
                        }
                        
                        for (Aluno a : POO.getListaAluno()) {
                            System.out.println("- " + a.getNomeAluno());
                        }
                        System.out.println("-----------------------");
                        
                        System.out.print("Digite o nome do aluno: ");
                        String nomeBusca = scanner.nextLine();
                        
                        System.out.println("\nAtividades disponíveis:");
                        for (int i = 0; i < POO.getNumeroDeNotas(); i++) {
                            System.out.println(i + " - Nota da Atividade " + (i + 1));
                        }
                        
                        System.out.print("Índice da atividade: ");
                        int atividade = scanner.nextInt();
                        
                        System.out.print("Digite a nova nota: ");
                        int novaNota = scanner.nextInt();
                        scanner.nextLine(); // Limpa buffer
                        
                        POO.modificarNotaAluno(nomeBusca, atividade, novaNota);
                        break;
                        
                    case 3:
                        POO.gerarRelatorioNotas();
                        break;
                        
                    case 4:
                        System.out.println("Encerrando o sistema...");
                        break;
                        
                    default:
                        System.out.println("Opção inválida. Escolha um número entre 1 e 4.");
                }
                
            } catch (InputMismatchException e) {
              
                System.out.println("\n Você digitou uma letra ou caractere onde era esperado um NÚMERO.");
                System.out.println("A operação foi cancelada. Tente novamente.");
                scanner.nextLine(); //descarta a letra errada para não gerar um loop infinito
            }
        }
        
        scanner.close(); 
    }
}