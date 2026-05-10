public class SavingsAccount extends Account
{
    private Double interest;

    public SavingsAccount(String owner, Double balance, Double interest)
    {
        super(owner, balance);
        this.interest = interest;
    }

    public void makeInterests()
    {
        Double balance = getBalance();

        balance += balance*interest/100;

        setBalance(balance);
    }
}
