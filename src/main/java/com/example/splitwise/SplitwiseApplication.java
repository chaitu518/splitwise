package com.example.splitwise;

import com.example.splitwise.commands.CommandExecutor;
import com.example.splitwise.commands.RegisterUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
	private CommandExecutor commandExecutor;
	private RegisterUserCommand registerUserCommand;
	public SplitwiseApplication(CommandExecutor commandExecutor, RegisterUserCommand registerUserCommand) {
		this.commandExecutor = commandExecutor;
		this.registerUserCommand = registerUserCommand;

	}
	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		commandExecutor.add(registerUserCommand);
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("Enter command : ");
			String input = scanner.nextLine();
			System.out.println(input);
			commandExecutor.execute(input);
		}
	}
}
