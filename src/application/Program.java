package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("Nome do departamento: ");
		String nameDepartment = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		Address adds = new Address(email, phone);
		Department dept = new Department(nameDepartment, payDay, adds);
		
		System.out.print("Quantos funcionarios tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Digite os dados do funcionário " + (i+1) + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(nome, salary);
			
			dept.addEmployee(emp);
		}
		
		showReport(dept);
		
		sc.close();
	}
	
	private static void showReport(Department dept) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.println("Departamento de " + dept.getName() + " = R$" + String.format("%.2f", dept.payroll()));
		System.out.println("Pagamento realizado dia " + dept.getPayDay());
		System.out.println("Funcionários:");
		for (Employee e : dept.getEmployees()) {
			System.out.println(e.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}

}
