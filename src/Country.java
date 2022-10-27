public class Country {
    private String name, nameCapital;
    private float square, population, populationCapital;
    private static final String descriptionSquare = " кв. км.";
    private static final String descriptionPeople = " чел.";


    public Country() {
        setNameCapital((""));
        setPopulationCapital(0);
    }

    public Country(String name, float square, float population) {
        setName(name);
        setNameCapital("");
        try {
            setSquare(square);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        setPopulation(population);
        setPopulationCapital(0);
    }

    public Country(String name, float square, float population, String nameCapital, float populationCapital) {
        setName(name);
        setNameCapital(nameCapital);
        try {
            setSquare(square);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        setPopulation(population);
        setPopulationCapital(populationCapital);
    }

    public void createCapital(String nameCapital, float populationCapital){
        setNameCapital(nameCapital);
        setPopulationCapital(populationCapital);
    }

    public void resetCapital() {
        setNameCapital("");
        setPopulationCapital(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public void setNameCapital(String nameCapital) {
        this.nameCapital = nameCapital;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) throws MyException{
        if (square>0) this.square = square;
        else if (square==0) throw new MyException("Площадь страны не может быть равна 0 !!!");

    }

    public float getPopulation() {
        return population;
    }

    public void setPopulation(float population) {
        if (population>0) this.population = population;
        else this.population = 0;

    }

    public float getPopulationCapital() {
        return populationCapital;
    }

    public void setPopulationCapital(float populationCapital) {
        if (populationCapital>0)this.populationCapital = populationCapital;
        else this.populationCapital = 0;
    }

    public float getDensity() {
        float density;
        density = getPopulation()/getSquare();
        return density;
    }
    public void print(){
        System.out.print(this.getName()+", ");
        if (this.getSquare() > 1000000) System.out.print(deleteZero(Float.toString(getSquare()/1000000).replace(".", ",")) + " млн" + descriptionSquare + ", ");
        else if (this.getSquare() > 1000) System.out.print(deleteZero(Float.toString(getSquare()/1000).replace(".", ",")) + " тыс." + descriptionSquare + ", ");
            else if (this.getSquare() > 0) System.out.print(deleteZero(Float.toString(getSquare()).replace(".", ",")) + descriptionSquare + ", ");
        if (this.getPopulation() > 1000000) System.out.print(deleteZero(Float.toString(getPopulation()/1000000).replace(".", ",")) + " млн" + descriptionPeople + ", ");
        else if (this.getPopulation() > 1000) System.out.print(deleteZero(Float.toString(getPopulation()/1000).replace(".", ",")) + " тыс." + descriptionPeople + ", ");
            else if (this.getPopulation() > 0) System.out.print(deleteZero(Float.toString(getPopulation()).replace(".", ",")) + descriptionPeople + ", ");
                else  System.out.print("0" + descriptionPeople + ", ");
        if (nameCapital.length()> 0) {
            System.out.print(getNameCapital() + ", ");
            if (this.getPopulationCapital() > 1000000) System.out.print(deleteZero(Float.toString(getPopulationCapital()/1000000).replace(".", ",")) + " млн" + descriptionPeople + ";");
            else if (this.getPopulationCapital() > 1000) System.out.print(deleteZero(Float.toString(getPopulationCapital()/1000).replace(".", ",")) + " тыс." + descriptionPeople + ";");
                else if (this.getPopulationCapital() > 0) System.out.print(deleteZero(Float.toString(getPopulationCapital()).replace(".", ",")) + descriptionPeople + ";");
        }
        System.out.println();


    }
    public String deleteZero(String str){
        return !str.contains(",") ? str : str.replaceAll("0*$","").replaceAll(",$", "");
    }


    static void printAll(Country[] countries){
        for (Country country : countries) {
            if (country.getNameCapital().length() > 0) country.print();
            else {
                System.out.print(country.getName() + ", ");
                if (country.getSquare() > 1000000)
                    System.out.print(country.deleteZero(Float.toString(country.getSquare() / 1000000).replace(".", ",")) + " млн" + descriptionSquare + ", ");
                else if (country.getSquare() > 1000)
                    System.out.print(country.deleteZero(Float.toString(country.getSquare() / 1000).replace(".", ",")) + " тыс." + descriptionSquare + ", ");
                else if (country.getSquare() > 0)
                    System.out.print(country.deleteZero(Float.toString(country.getSquare()).replace(".", ",")) + descriptionSquare + ", ");
                if (country.getPopulation() > 1000000)
                    System.out.print(country.deleteZero(Float.toString(country.getPopulation() / 1000000).replace(".", ",")) + " млн" + descriptionPeople);
                else if (country.getPopulation() > 1000)
                    System.out.print(country.deleteZero(Float.toString(country.getPopulation() / 1000).replace(".", ",")) + " тыс." + descriptionPeople);
                else if (country.getPopulation() > 0)
                    System.out.print(country.deleteZero(Float.toString(country.getPopulation()).replace(".", ",")) + descriptionPeople);
                System.out.println(", --.");
            }
        }

    }

    public static void main(String[] args) {
        Country country1 = new Country();
        country1.setName("Russia");
        try {
            country1.setSquare(17100000);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        country1.setPopulation(146700000);
        country1.setNameCapital("Moscow");
        country1.setPopulationCapital(12600000);
        country1.print();
        Country country2 = new Country("Finland",338000, 5500000,"Helsinki",655000);
        country2.print();
        Country country3 = new Country("France",643800,67800000,"Paris",2100000);
        country3.print();
        Country country4 = new Country("Andorra", 467,85400, "Andorra la Vella", 22600);
        country4.print();
        Country country5 = new Country("Singapore",725,5700000);
        country5.print();
        System.out.println("плотность : " + country5.getDensity());

        
        Country[] countries = new Country[]{country1,country2,country3,country4,country5};
        printAll(countries);

        Country country6 = new Country("Нью Васюки",10,-1);
        country6.print();

        Country country7 = new Country("Нью Васюки",0,100);
        country7.print();
    }
}
