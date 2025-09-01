package com.devsenior.tutorias.luistriana;

import com.devsenior.tutorias.luistriana.model.cuenta;
import com.devsenior.tutorias.luistriana.service.cajero;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static cajero cajeroATM = new cajero("ATM-001");
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA CAJERO AUTOMÁTICO ===");
        System.out.println("Bienvenido al sistema de transacciones bancarias");
        
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    agregarCuenta();
                    break;
                case 2:
                    realizarDeposito();
                    break;
                case 3:
                    realizarRetiro();
                    break;
                case 4:
                    consultarSaldo();
                    break;
                case 5:
                    realizarTransferencia();
                    break;
                case 6:
                    mostrarEstadoCajero();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("¡Gracias por usar el sistema! Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
            
            if (continuar) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Agregar nueva cuenta");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar retiro");
        System.out.println("4. Consultar saldo");
        System.out.println("5. Realizar transferencia");
        System.out.println("6. Ver estado del cajero");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            return opcion;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }
    
    private static void agregarCuenta() {
        System.out.println("\n=== AGREGAR NUEVA CUENTA ===");
        
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        
        System.out.print("Ingrese el nombre del titular: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = leerMonto();
        
        if (saldoInicial < 0) {
            System.out.println("Error: El saldo inicial no puede ser negativo.");
            return;
        }
        
        cuenta nuevaCuenta = new cuenta(numeroCuenta, saldoInicial, nombre);
        
        if (cajeroATM.agregarCuenta(nuevaCuenta)) {
            System.out.println("✓ Cuenta agregada exitosamente.");
            System.out.println("Número: " + numeroCuenta + " | Titular: " + nombre + " | Saldo: $" + saldoInicial);
        } else {
            System.out.println("✗ Error: Ya existe una cuenta con ese número.");
        }
    }
    
    private static void realizarDeposito() {
        System.out.println("\n=== REALIZAR DEPÓSITO ===");
        
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        
        if (!cajeroATM.existeCuenta(numeroCuenta)) {
            System.out.println("✗ Error: La cuenta no existe.");
            return;
        }
        
        System.out.print("Ingrese el monto a depositar: ");
        double monto = leerMonto();
        
        if (monto <= 0) {
            System.out.println("✗ Error: El monto debe ser positivo.");
            return;
        }
        
        if (cajeroATM.depositar(numeroCuenta, monto)) {
            System.out.println("✓ Depósito realizado exitosamente.");
            System.out.println("Nuevo saldo: $" + cajeroATM.consultarSaldo(numeroCuenta));
        } else {
            System.out.println("✗ Error al procesar el depósito.");
        }
    }
    
    private static void realizarRetiro() {
        System.out.println("\n=== REALIZAR RETIRO ===");
        
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        
        if (!cajeroATM.existeCuenta(numeroCuenta)) {
            System.out.println("✗ Error: La cuenta no existe.");
            return;
        }
        
        double saldoActual = cajeroATM.consultarSaldo(numeroCuenta);
        System.out.println("Saldo actual: $" + saldoActual);
        
        System.out.print("Ingrese el monto a retirar: ");
        double monto = leerMonto();
        
        if (monto <= 0) {
            System.out.println("✗ Error: El monto debe ser positivo.");
            return;
        }
        
        if (cajeroATM.retirar(numeroCuenta, monto)) {
            System.out.println("✓ Retiro realizado exitosamente.");
            System.out.println("Nuevo saldo: $" + cajeroATM.consultarSaldo(numeroCuenta));
        } else {
            System.out.println("✗ Error: Saldo insuficiente o error en la operación.");
        }
    }
    
    private static void consultarSaldo() {
        System.out.println("\n=== CONSULTAR SALDO ===");
        
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        
        if (!cajeroATM.existeCuenta(numeroCuenta)) {
            System.out.println("✗ Error: La cuenta no existe.");
            return;
        }
        
        cuenta cuentaInfo = cajeroATM.obtenerCuenta(numeroCuenta);
        double saldo = cajeroATM.consultarSaldo(numeroCuenta);
        
        System.out.println("✓ Información de la cuenta:");
        System.out.println("Número: " + cuentaInfo.getNumeroCuenta());
        System.out.println("Titular: " + cuentaInfo.getNombre());
        System.out.println("Saldo actual: $" + saldo);
    }
    
    private static void realizarTransferencia() {
        System.out.println("\n=== REALIZAR TRANSFERENCIA ===");
        
        System.out.print("Ingrese el número de cuenta origen: ");
        String cuentaOrigen = scanner.nextLine();
        
        if (!cajeroATM.existeCuenta(cuentaOrigen)) {
            System.out.println("✗ Error: La cuenta origen no existe.");
            return;
        }
        
        System.out.print("Ingrese el número de cuenta destino: ");
        String cuentaDestino = scanner.nextLine();
        
        if (!cajeroATM.existeCuenta(cuentaDestino)) {
            System.out.println("✗ Error: La cuenta destino no existe.");
            return;
        }
        
        if (cuentaOrigen.equals(cuentaDestino)) {
            System.out.println("✗ Error: No se puede transferir a la misma cuenta.");
            return;
        }
        
        double saldoOrigen = cajeroATM.consultarSaldo(cuentaOrigen);
        System.out.println("Saldo disponible en cuenta origen: $" + saldoOrigen);
        
        System.out.print("Ingrese el monto a transferir: ");
        double monto = leerMonto();
        
        if (monto <= 0) {
            System.out.println("✗ Error: El monto debe ser positivo.");
            return;
        }
        
        if (cajeroATM.transferir(cuentaOrigen, cuentaDestino, monto)) {
            System.out.println("✓ Transferencia realizada exitosamente.");
            System.out.println("Nuevo saldo cuenta origen: $" + cajeroATM.consultarSaldo(cuentaOrigen));
            System.out.println("Nuevo saldo cuenta destino: $" + cajeroATM.consultarSaldo(cuentaDestino));
        } else {
            System.out.println("✗ Error: Saldo insuficiente o error en la operación.");
        }
    }
    
    private static void mostrarEstadoCajero() {
        System.out.println("\n=== ESTADO DEL CAJERO ===");
        
        int totalCuentas = cajeroATM.getTotalCuentas();
        
        if (totalCuentas == 0) {
            System.out.println("No hay cuentas registradas en el sistema.");
        } else {
            System.out.println("Total de cuentas registradas: " + totalCuentas);
            cajeroATM.imprimirEstadoCajero();
        }
    }
    
    private static double leerMonto() {
        try {
            double monto = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer
            return monto;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            System.out.println("Error: Ingrese un número válido.");
            return -1;
        }
    }
}