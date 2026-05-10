public class Programmer extends Empleado
{
    private Double extra_salary;
    private Integer proyects;

    public Programmer (String name_dev, Double salary_dev, Integer proyects)
    {
        super(name_dev, salary_dev);

        if(proyects <= 0) return;
        this.proyects = proyects;
    }

    public Double salaryCalc()
    {
        if(proyects < 4)
        {
            extra_salary = (super.getSalary() * 0.025);

            return extra_salary + super.getSalary();
        }

        extra_salary = (super.getSalary() * 0.05);

        return extra_salary + super.getSalary();
    }

    public Integer getId()
    {
        return super.getId();
    }

    public String toString()
    {
        return "Developer: " + getName() +
               "\nId: "        + getId() +
               "\nSalary: "    + salaryCalc();
    }
    
}
