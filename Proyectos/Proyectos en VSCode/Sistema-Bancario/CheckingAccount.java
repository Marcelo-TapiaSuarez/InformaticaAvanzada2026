public class CheckingAccount extends Account
{
    private Double limit;

    public CheckingAccount(String owner, Double balance, Double limit)
    {
        super(owner, balance);
        this.limit = limit;
    }

    @Override
    public Double withdrawMoney(Double amount)
    {
        if(amount < 0.0) return getBalance();

        Double aux = getBalance() - amount;
        if(aux < -limit)
        {
            System.out.println("Límite excedido");
            return getBalance();
        }
        setBalance(aux);
        return getBalance();

    }
    
}
