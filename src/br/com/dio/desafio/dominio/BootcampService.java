package br.com.dio.desafio.dominio;

import java.util.List;

public class BootcampService {
    
    //private Bootcamp devSelecionados;

	public void criarBootcamp(List<Bootcamp> lista) {
        String nome = LeitorDeEntrada.lerString("Digite o nome do Bootcamp: ");
        String descricao = LeitorDeEntrada.lerString("Digite a descrição do Bootcamp: ");
        
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome(nome);
        bootcamp.setDescricao(descricao);
        
        lista.add(bootcamp);
    }

    public void adicionarCurso(List<Bootcamp> lista) {
        int opcao = LeitorDeEntrada.lerInteiro("Digite o número referente ao Bootcamp: ");
        Bootcamp bootcampSelecionado = lista.get(opcao);
        
        String titulo = LeitorDeEntrada.lerString("Digite o nome do curso: ");
        String descricao = LeitorDeEntrada.lerString("Digite a descrição do curso: ");
        int cargaHoraria = LeitorDeEntrada.lerInteiro("Digite a carga horária: ");
        
        Curso curso = new Curso(titulo, descricao, cargaHoraria);
        bootcampSelecionado.getConteudos().add(curso);
    }
    
    // Outros métodos relacionados ao Bootcamp
    
    /*public void obterBootcampSelecionado (List<Bootcamp> lista) {
    	
    	Bootcamp devSelecionados = new Bootcamp();
    	
    	devSelecionados.getDevsInscritos();
    	
    	
    	
    }*/
}
