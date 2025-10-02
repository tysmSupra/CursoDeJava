package Practica;

/**
 * Herencia y polimorfismos
 * Polimorfismo -> Sobrecarga de métodos (misma clase) y Sobreescritura de
 * métodos (herencia)
 **/

class Persona {
  private String nombre, apellido;
  private int dni;

  public Persona(String nombre, String apellido, int dni) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  @Override // polimorfismo -> sobreescritura
  public String toString() {
    return "- " + this.apellido + ", " + this.nombre + " (DNI: " + this.dni + ")";
  }
}

class Estudiantes extends Persona {
  private String carrera;

  public Estudiantes(String nombre, String apellido, int dni, String carrera) {
    super(nombre, apellido, dni);
    this.carrera = carrera;
  }

  public Estudiantes(String nombre, String apellido, int dni) {
    super(nombre, apellido, dni);
    this.carrera = "Sin definir";
  }

  public void modificarCarrera(String nuevaCarrera) {
    this.carrera = nuevaCarrera;
  }

  @Override // polimorfismo -> sobreescritura
  public String toString() {
    return super.toString() + " - Carrera: " + this.carrera;
  }

}

class Materia {
  private String nombre;

  public Materia(String nombre) {
    this.nombre = nombre;
  }

  public String toString() {
    return "- " + this.nombre;
  }
}

class Docentes extends Persona implements InformeDeDatos {
  private Materia[] materias;

  public Docentes(String nombre, String apellido, int dni, Materia[] materias) {
    super(nombre, apellido, dni);
    this.materias = materias;
  }

  @Override
  public String informe() {
    return "El docente " + super.toString() + " dicta materias:";
  }

  public void mostrarMaterias() {
    for (Materia materia : materias) {
      System.out.println(materia.toString());
    }
  }

  @Override // polimorfismo -> sobreescritura
  public String toString() {
    return super.toString();
  }

}

interface InformeDeDatos {
  public String informe();
}

public class Practica06 {
  public static void main(String[] args) {
    Estudiantes estudiante = new Estudiantes("María", "Gómez", 87654321, "ISI");
    estudiante.modificarCarrera("TUP");
    Materia isi = new Materia("ISI");
    Materia tup = new Materia("TUP");
    Materia[] materias = { isi, tup };
    Docentes docente = new Docentes("Facundo", "Uferer", 12345678, materias);

    System.out.println(estudiante.toString());
    System.out.println(docente.toString());
    docente.mostrarMaterias();
  }
  //funcion agregada 
public static Docentes registrarDocente() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Registro de un nuevo docente");
    System.out.println("=======================");

    System.out.print("ingrese el nombre del docente: ");
    String nombre = sc.nextLine();

    System.out.print("ingrese el apellido del docente: ");
    String apellido = sc.nextLine();

    System.out.print("ingrese el DNI del docente: ");
    int dni = sc.nextInt();

    System.out.print("cuantas materias dicta este docente?: ");
    int cantMaterias = sc.nextInt();

    Materia[] materias = new Materia[cantMaterias ];
    System.out.println("\ningrese los nombres de las materias:");
    for (int i = 0; i < cantMaterias; i++) {
      System.out.print("Materia " + (i + 1) + ": ");
      materias[i] = new Materia(nombreMateria);
    }
    return new Docentes(nombre, apellido, dni, materias);
}

