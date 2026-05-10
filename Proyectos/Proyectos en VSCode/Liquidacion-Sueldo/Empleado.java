import java.util.Random;

class Empleado
{
    private String name;
    private Double salary;
    private Integer id_employ;


    public Empleado(String name, Double salary)
    {
        if(name.equals("")) return;
        if(salary == null || salary < 0) return;

        this.name = name;
        this.salary = salary;
        id_employ = new Random().nextInt(10001);
    }

    public String getName()
    {
        return name;
    }

    public Double getSalary()
    {
        return salary;
    }

    public Double salaryCalc()
    {
        return salary;
    }
    
    public Integer getId()
    {
        return id_employ;
    }

    public String toString()
    {
        return "Empleado: " + getName() +
               "\nId: "      + getId() +
               "\nSalary: "  + salaryCalc();
    }
}