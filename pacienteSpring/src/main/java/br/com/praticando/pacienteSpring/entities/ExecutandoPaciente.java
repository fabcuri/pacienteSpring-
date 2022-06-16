package br.com.praticando.pacienteSpring.entities;



public class ExecutandoPaciente {
	
		public static void main(String[] args) {
			Paciente p = new Paciente();
			p.setIdPaciente(10);
			p.setNome("Ana Clara");
			p.setCpf("1111111111");
			p.setDataNascimento("01/01/2000");
			p.setSexo("Feminino");
			
		
			System.out.println(p);
			
		}
		}