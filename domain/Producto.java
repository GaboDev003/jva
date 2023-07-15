package domain;

public class Producto {

	private int identificador;

	private String nombre;

	private int precio;

	private int precioAlMayor;

	private String imagen;

	public Producto() {
	}

	public Producto(int identificador) {
		this.identificador = identificador;
	}

	public Producto(String nombre, int precio, int precioAlMayor, String imagen) {
		this.nombre = nombre;
		this.precio = precio;
		this.precioAlMayor = precioAlMayor;
		this.imagen = imagen;
	}

	public Producto(int identificador, String nombre, int precio, int precioAlMayor, String imagen) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.precio = precio;
		this.precioAlMayor = precioAlMayor;
		this.imagen = imagen;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPrecioAlMayor() {
		return precioAlMayor;
	}

	public void setPrecioAlMayor(int precioAlMayor) {
		this.precioAlMayor = precioAlMayor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "\nProducto: \nIdentificador= " + identificador + "\nNombre= " + nombre + "\nPrecio= " + precio
				+ "\nPrecioAlMayor= " + precioAlMayor + "\nImagen= " + imagen;
	}

}
