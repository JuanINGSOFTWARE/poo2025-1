public class Vehiculo {

   //atributos de la clase
   private String marca;                
   private String color;
   private double cilindraje;
   private string chasis;
   private double peso;
   private string potencia;


   /*constructor de la clase -> permite inicializar el objeto 
    *
   
   
   */  

   public Vehiculo(String marca, string color, double cilindraje, string chasis, double peso, string potencia){

   
      this.marca = marca;
      this.color = color;
      this.cilindraje = cilindraje;
      this.chasis = chasis;
      this.peso = peso;
      this.potencia = potencia;
   }
   //metodos getter / setter 
      public String getMarca(){
      return marca;

      public void setMarca(string marca){
      this.marca = marca;

      }
      
      //permite mostrar el objeto  
    public String toString() {
      return "Vehiculo { Marca: " + marca + " Color: " + color +
              " Cilindraje: " + cilindraje + " Chasis: " + chasis +
              " Peso: " + peso + " Potencia: " + potencia + "}";
  }

  //Métodos de la clase
  public void acelerar(){
      System.out.println("Vehículo acelerando....");
  }

  public void frenar(){
      System.out.println("Vehículo frenando....");
  }

  public void girarIzquierda(){
      System.out.println("Vehículo girando izquierda....");
  }

  public void girarDerecha(){
      System.out.println("Vehículo girando derecha....");
  }

  public void retroceder(){
      System.out.println("Vehículo retrocediendo....");
  }

}
