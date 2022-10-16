public class ContaCorrente { 
    private double saldo; 

    public ContaCorrente(double saldoInicial){ 
        saldo = saldoInicial; 
    } 

    public double getSaldo(){  
        return(saldo);    
    }

    public void deposito(double valor){ 
        validarValor(valor);
        saldo += valor; 
        }

    public void retirada(double valor){ 
        validarValor(valor);
        saldo -= valor; 
    }

    private void validarValor(double valor) {
		if (valor <= 0) {
			throw new FooRuntimeException("Erro: Valor inválido");
		}
	}
} 
