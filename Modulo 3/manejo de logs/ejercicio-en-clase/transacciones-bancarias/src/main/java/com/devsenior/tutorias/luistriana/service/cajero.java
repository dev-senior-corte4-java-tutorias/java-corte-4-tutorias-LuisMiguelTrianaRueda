package com.devsenior.tutorias.luistriana.service;

import com.devsenior.tutorias.luistriana.model.cuenta;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.LogManager;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class cajero {
    private static final Logger logger = LogManager.getLogger(cajero.class);
    private Map<String, cuenta> cuentas;
    private String cajeroId;
    
    public cajero(String cajeroId) {
        this.cajeroId = cajeroId;
        this.cuentas = new HashMap<>();
        ThreadContext.put("cajeroId", cajeroId);
        logger.info("Cajero automático inicializado - ID: {}", cajeroId);
    }
    
    public boolean agregarCuenta(cuenta cuenta) {
        ThreadContext.put("operacion", "AGREGAR_CUENTA");
        ThreadContext.put("numeroCuenta", cuenta.getNumeroCuenta());
        
        if (cuentas.containsKey(cuenta.getNumeroCuenta())) {
            logger.warn("Intento de agregar cuenta existente - Número: {}", cuenta.getNumeroCuenta());
            return false;
        }
        
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
        logger.info("Cuenta agregada exitosamente - Número: {}, Titular: {}, Saldo inicial: {}", 
                   cuenta.getNumeroCuenta(), cuenta.getNombre(), cuenta.getSaldo());
        return true;
    }
    
    public boolean depositar(String numeroCuenta, double monto) {
        ThreadContext.put("operacion", "DEPOSITO");
        ThreadContext.put("numeroCuenta", numeroCuenta);
        ThreadContext.put("monto", String.valueOf(monto));
        ThreadContext.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        logger.info("Iniciando operación de depósito - Cuenta: {}, Monto: {}", numeroCuenta, monto);
        
        if (monto <= 0) {
            logger.error("Intento de depósito con monto inválido - Monto: {}", monto);
            return false;
        }
        
        cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta == null) {
            logger.error("Cuenta no encontrada para depósito - Número: {}", numeroCuenta);
            return false;
        }
        
        double saldoAnterior = cuenta.getSaldo();
        cuenta.depositar(monto);
        double saldoNuevo = cuenta.getSaldo();
        
        logger.info("Depósito exitoso - Cuenta: {}, Saldo anterior: {}, Monto depositado: {}, Saldo nuevo: {}", 
                   numeroCuenta, saldoAnterior, monto, saldoNuevo);
        
        ThreadContext.clearAll();
        return true;
    }
    
    public boolean retirar(String numeroCuenta, double monto) {
        ThreadContext.put("operacion", "RETIRO");
        ThreadContext.put("numeroCuenta", numeroCuenta);
        ThreadContext.put("monto", String.valueOf(monto));
        ThreadContext.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        logger.info("Iniciando operación de retiro - Cuenta: {}, Monto: {}", numeroCuenta, monto);
        
        if (monto <= 0) {
            logger.error("Intento de retiro con monto inválido - Monto: {}", monto);
            return false;
        }
        
        cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta == null) {
            logger.error("Cuenta no encontrada para retiro - Número: {}", numeroCuenta);
            return false;
        }
        
        double saldoAnterior = cuenta.getSaldo();
        
        if (saldoAnterior < monto) {
            logger.warn("Intento de retiro con saldo insuficiente - Cuenta: {}, Saldo: {}, Monto solicitado: {}", 
                       numeroCuenta, saldoAnterior, monto);
            return false;
        }
        
        boolean exitoso = cuenta.retirar(monto);
        if (exitoso) {
            double saldoNuevo = cuenta.getSaldo();
            logger.info("Retiro exitoso - Cuenta: {}, Saldo anterior: {}, Monto retirado: {}, Saldo nuevo: {}", 
                       numeroCuenta, saldoAnterior, monto, saldoNuevo);
        } else {
            logger.error("Error en operación de retiro - Cuenta: {}", numeroCuenta);
        }
        
        ThreadContext.clearAll();
        return exitoso;
    }
    
    public double consultarSaldo(String numeroCuenta) {
        ThreadContext.put("operacion", "CONSULTA_SALDO");
        ThreadContext.put("numeroCuenta", numeroCuenta);
        ThreadContext.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        logger.info("Consultando saldo - Cuenta: {}", numeroCuenta);
        
        cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta == null) {
            logger.error("Cuenta no encontrada para consulta de saldo - Número: {}", numeroCuenta);
            ThreadContext.clearAll();
            return -1;
        }
        
        double saldo = cuenta.getSaldo();
        logger.info("Consulta de saldo exitosa - Cuenta: {}, Titular: {}, Saldo: {}", 
                   numeroCuenta, cuenta.getNombre(), saldo);
        
        ThreadContext.clearAll();
        return saldo;
    }
    
    public boolean transferir(String cuentaOrigen, String cuentaDestino, double monto) {
        ThreadContext.put("operacion", "TRANSFERENCIA");
        ThreadContext.put("cuentaOrigen", cuentaOrigen);
        ThreadContext.put("cuentaDestino", cuentaDestino);
        ThreadContext.put("monto", String.valueOf(monto));
        ThreadContext.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        
        logger.info("Iniciando transferencia - Origen: {}, Destino: {}, Monto: {}", 
                   cuentaOrigen, cuentaDestino, monto);
        
        if (monto <= 0) {
            logger.error("Intento de transferencia con monto inválido - Monto: {}", monto);
            return false;
        }
        
        cuenta origen = cuentas.get(cuentaOrigen);
        cuenta destino = cuentas.get(cuentaDestino);
        
        if (origen == null) {
            logger.error("Cuenta origen no encontrada - Número: {}", cuentaOrigen);
            return false;
        }
        
        if (destino == null) {
            logger.error("Cuenta destino no encontrada - Número: {}", cuentaDestino);
            return false;
        }
        
        if (origen.getSaldo() < monto) {
            logger.warn("Saldo insuficiente para transferencia - Cuenta origen: {}, Saldo: {}, Monto: {}", 
                       cuentaOrigen, origen.getSaldo(), monto);
            return false;
        }
        
        double saldoOrigenAnterior = origen.getSaldo();
        double saldoDestinoAnterior = destino.getSaldo();
        
        boolean retiroExitoso = origen.retirar(monto);
        if (retiroExitoso) {
            destino.depositar(monto);
            
            logger.info("Transferencia exitosa - Origen: {} (saldo: {} -> {}), Destino: {} (saldo: {} -> {}), Monto: {}", 
                       cuentaOrigen, saldoOrigenAnterior, origen.getSaldo(),
                       cuentaDestino, saldoDestinoAnterior, destino.getSaldo(), monto);
        } else {
            logger.error("Error en transferencia - No se pudo retirar de cuenta origen: {}", cuentaOrigen);
        }
        
        ThreadContext.clearAll();
        return retiroExitoso;
    }
    
    public boolean existeCuenta(String numeroCuenta) {
        ThreadContext.put("operacion", "VERIFICAR_CUENTA");
        ThreadContext.put("numeroCuenta", numeroCuenta);
        
        boolean existe = cuentas.containsKey(numeroCuenta);
        logger.debug("Verificación de existencia de cuenta - Número: {}, Existe: {}", numeroCuenta, existe);
        
        ThreadContext.clearAll();
        return existe;
    }
    
    public cuenta obtenerCuenta(String numeroCuenta) {
        ThreadContext.put("operacion", "OBTENER_CUENTA");
        ThreadContext.put("numeroCuenta", numeroCuenta);
        
        cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null) {
            logger.debug("Cuenta obtenida - Número: {}, Titular: {}", numeroCuenta, cuenta.getNombre());
        } else {
            logger.debug("Cuenta no encontrada - Número: {}", numeroCuenta);
        }
        
        ThreadContext.clearAll();
        return cuenta;
    }
    
    public int getTotalCuentas() {
        int total = cuentas.size();
        logger.debug("Total de cuentas registradas en cajero {}: {}", cajeroId, total);
        return total;
    }
    
    public void imprimirEstadoCajero() {
        logger.info("=== Estado del Cajero {} ===", cajeroId);
        logger.info("Total de cuentas: {}", cuentas.size());
        
        for (cuenta cuenta : cuentas.values()) {
            logger.info("Cuenta: {} | Titular: {} | Saldo: {}", 
                       cuenta.getNumeroCuenta(), cuenta.getNombre(), cuenta.getSaldo());
        }
        logger.info("=== Fin Estado del Cajero {} ===", cajeroId);
    }
}