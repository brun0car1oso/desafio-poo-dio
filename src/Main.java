import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.BootcampService;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.LeitorDeEntrada;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) { 
    	
    	//List<Dev> devs = new LinkedList();
    	 
    	//List<Bootcamp> bootcamps = new LinkedList<>();
    	
    	//Set<Bootcamp> bootcamps = new HashSet<>();
    	
    	List<Bootcamp> bootcamps = new ArrayList<>();
    	int opcaoContinuar;
    	int escolharMenu = 0;
    	
    	/*criarBootcamp(bootcamps);
        obterDadosDeV(bootcamps);
        adicionarCurso(bootcamps);
        
        //HashSet<Bootcamp> baseDados = new HashSet<>(bootcamps);
        
        System.out.println("-------");
        
        imprimirDados(bootcamps);*/
       
        //imprimirDados(baseDados);
        while (escolharMenu < 5) {
        	
        	System.out.println("---------MENU----------");
        	System.out.println("1-Criar Bootcamp.");
        	System.out.println("2-Adiconar Desenvolvedor.");
        	System.out.println("3-Adiconar cursos.");
        	System.out.println("4-Adicionar mentorias.");
        	System.out.println("5-Sair.");
        	escolharMenu = LeitorDeEntrada.lerInteiro("Escolha uma opção:");
        	//obterOpcaoValida(1,5);
        	
        	System.out.printf("\n");
        	
        	switch(escolharMenu) {
        		case 1:
        			criarBootcamp(bootcamps);
        		  break;
        		case 2:
        			increverDevBootcamp(bootcamps, criarNovoDev());
        		  break;
        		case 3:
        			adicionarCurso(bootcamps);
          		  break;  
        		case 4:
            	    
          		  break;  
        		default:
        			System.out.println("Programa encerrado....");
        			imprimirDados(bootcamps);
        	}
        	
        }
    	
        
    }
    
    public static void criarBootcamp(List<Bootcamp> lista) {
    	
    	int opcaoContinuar = 1; 
    	
    	BootcampService chamarBootcampServie = new BootcampService();
    	
    	while (opcaoContinuar == 1) {
    		
    		//System.out.print("Digite o nome do Bootcamp:");
    		//nomeBootcamp = LeitorDeEntrada.lerString("Digite o nome do Dev: ");
    		
    		
    		chamarBootcampServie.criarBootcamp(lista);
    		
    		
    		System.out.print("Deseja adicionar mais Bootcamps ? 1(SIM):2(NÃO) : ");
    		opcaoContinuar = scanner.nextInt(); 
    		//validarEntrada(opcaoContinuar);	
    		 

    		System.out.printf("\n");
    	}
    
    }
    
    public static void increverDevBootcamp(List<Bootcamp> lista, Dev dev) {
        //Dev dev; = //criarNovoDev();
        imprimirBootCamp(lista);
        Bootcamp bootcampSelecionado = obterBootcampSelecionado(lista);
        
        dev.inscreverBootcamp(bootcampSelecionado);
    }

    public static Dev criarNovoDev() {
        String nome = obterNomeDev();
        Dev dev = new Dev();
        dev.setNome(nome);
        return dev;
    }
    
    public static String obterNomeDev() {
        System.out.print("Digite o nome do Dev: ");
        return scanner.next();
    }
    
    public static Bootcamp obterBootcampSelecionado(List<Bootcamp> lista) {
        System.out.print("Digite o número do Bootcamp: ");
        int opcao = scanner.nextInt();
        return lista.get(opcao);
    }
    
    
    
   public static void imprimirDadosDev(List<Bootcamp> lista) {
	   
	   for (Bootcamp dev : lista)  {
		   
		   System.out.println(dev.getDevsInscritos());
		   
		   System.out.println(dev.getConteudos());
	   
	   }
       
   } 
   
   /*public static void imprimirDados(List<Bootcamp> lista) {
	   
	   for (Bootcamp dev : lista)  {
		   
		   System.out.println(dev.getDevsInscritos());
		   
		   System.out.println(dev.getConteudos());
	   
	   }
       
   } */
   
   
   public static void adicionarCurso(List<Bootcamp> lista) {
	   
	   int opcaoContinuar = 1; 
	   
       BootcampService chamarBootcampServie = new BootcampService();
   	   
   	   while (opcaoContinuar != 2) {

   	   imprimirBootCamp(lista);   
   		   
   	   chamarBootcampServie.adicionarCurso(lista);
   		   
	     
       opcaoContinuar = LeitorDeEntrada.lerInteiro("Deseja adicionar mais Curso ? 1(SIM):2(NÃO) : ") ;
	   //validarEntrada(opcaoContinuar);
	   
       
   	   }   

	   System.out.printf("\n");
	   
   }
   
   public static int obterOpcaoValida(int limiteInferior, int limiteSuperior) {
	    int opcao;
	    do {
	        opcao = scanner.nextInt();
	        if (opcao < limiteInferior || opcao > limiteSuperior) {
	            System.out.println("Opção inválida. Tente novamente.");
	        }
	    } while (opcao < limiteInferior || opcao > limiteSuperior);
	    return opcao;
   }
   
   public static <T> void imprimirBootCamp(List<T> lista ){
	   int tamLista = lista.size();
	   
	   for (int i=0; i <tamLista; i++) {
		   //System.out.printf("Bootcamp %s \n",lista.get(0));   
		   System.out.printf(lista.get(i).toString()); 
		   System.out.printf("-%s. \n",i);
		  
	   }
   }

   public static void imprimirDados(List<Bootcamp> lista) {
	   
	   for (Bootcamp dev : lista)  {
		   
		   System.out.println(dev.getDevsInscritos());
		   
		   System.out.println(dev.getConteudos());
	   
	   }

   }
   
}
