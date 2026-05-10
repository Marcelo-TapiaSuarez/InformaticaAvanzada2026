public class Manager extends Empleado
{
    private Double extra_salary;
    private Integer performance;
    
    public Manager (String name_m, Double salary_m, Integer performance)
    {
        super(name_m, salary_m);
        
        if(performance < 0 || performance > 10) return;
        this.performance = performance;
    }

    //@Override
    public Double salaryCalc()
    {
        if(performance < 6)
        {
            extra_salary = (super.getSalary() * 0.05);
            return extra_salary + super.getSalary();
        }

        extra_salary = (super.getSalary() * 0.1);

        return extra_salary + super.getSalary();
    }

    public Integer getId()
    {
        return super.getId();
    }

    public String toString()
    {
        return "Manager: " + getName() +
               "\nId: "      + getId() +
               "\nSalary: "  + salaryCalc();
    }
}
