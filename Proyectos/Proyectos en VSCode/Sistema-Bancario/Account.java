public class Account
{
    private String owner;
    private Double balance;

    public Account(String owner, Double balance)
    {
        if(owner.equals("")) return;

        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner()
    {
        return owner;
    }

    public Double getBalance()
    {
        return balance;
    }

    public void setBalance(Double balance)
    {
        this.balance = balance;
    }

    public void addMoney(Double amount)
    {
        if(amount == null || amount < 0) return;
        balance += amount;
    }

    public Double withdrawMoney(Double amount)
    {
        if(amount > balance)
        {
            System.out.println("Fondos Insuficientes");
            return balance;
        } 

        balance = balance - amount;
        return amount;
    }

    @Override
    public String toString()
    {
        return "Owner: " + owner +
               "\nBalance: " + balance;
    }

    
}