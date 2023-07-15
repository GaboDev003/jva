package view;

import java.sql.SQLException;
import java.util.Scanner;
import datos.ProductoDao;
import domain.Producto;

public class PantallaPrincipal {

	public static void main(String[] args) throws SQLException {
		Scanner in = new Scanner(System.in);

		int opcion = -1;

		while (opcion != 0) {

			System.out.println("Eliga una opcion: \n" + "1.Insertar un producto \n" + "2.Actualizar producto \n"
					+ "3.Eliminar producto \n" + "4.Listar productos \n" + "5.Buscar producto \n" + "0.Salir ");

			opcion = in.nextInt();
			switch (opcion) {

			case 1:
				System.out.println(
						"Inserte los siguientes datos en orden 1.Nombre, 2.Precio, 3.Precio al mayor, 4.Imagen");
				ProductoDao pd1 = new ProductoDao();
				System.out.println("Nombre: ");
				String nm = in.next().concat(in.nextLine());
				System.out.println("Precio: ");
				int prc = in.nextInt();
				System.out.println("Precio al mayor: ");
				int prcam = in.nextInt();
				System.out.println("Imagen: ");
				String img = in.next();
				Producto p1 = new Producto(nm, prc, prcam, img);
				try {
					pd1.insertar(p1);
				} catch (SQLException e) {
					e.printStackTrace(System.out);
				}
				break;
			case 2:
				System.out.println("Inserte el identificador del producto a actualizar: ");
				ProductoDao pd2 = new ProductoDao();

				System.out.println("Identificador del producto:");
				int idtm = in.nextInt();
				Producto productoB = pd2.buscar(idtm);

				String nombre = productoB.getNombre();
				int precio = productoB.getPrecio();
				int precioM = productoB.getPrecioAlMayor();
				String imagen = productoB.getImagen();
				Producto p2 = new Producto(idtm, nombre, precio, precioM, imagen);
				System.out.println(
						"Seleccione el campo que desea actualizar: 1.Nombre, 2.Precio, 3.Precio al mayor, 4.Imagen, 5.Todos los campos");
				int campoA = in.nextInt();
				switch (campoA) {

				case 1:
					System.out.println("Ingrese el nombre: ");
					String nm2 = in.next().concat(in.nextLine());
					p2.setNombre(nm2);
					break;
				case 2:
					System.out.println("Ingrese el precio: ");
					int prc2 = in.nextInt();
					p2.setPrecio(prc2);
					break;
				case 3:
					System.out.println("Ingrese el precio al mayor: ");
					int prcam2 = in.nextInt();
					p2.setPrecioAlMayor(prcam2);
					break;
				case 4:
					System.out.println("Ingrese la imagen: ");
					String img2 = in.nextLine();
					p2.setImagen(img2);
					break;
				case 5:
					System.out.println("Nombre: ");
					String nma = in.next().concat(in.nextLine());
					System.out.println("Precio: ");
					int prca = in.nextInt();
					System.out.println("Precio al mayor: ");
					int prcama = in.nextInt();
					System.out.println("Imagen: ");
					String imga = in.next();

					p2.setNombre(nma);
					p2.setPrecio(prca);
					p2.setPrecioAlMayor(prcama);
					p2.setImagen(imga);

					break;
				}

				try {
					pd2.actualizar(p2);
				} catch (SQLException e) {
					e.printStackTrace(System.out);
				}
				break;

			case 3:
				System.out.println("Ingrese el identificador del producto a eliminar");
				ProductoDao pd3 = new ProductoDao();
				int ide = in.nextInt();

				Producto p3 = new Producto(ide);

				try {
					pd3.eliminar(p3);
				} catch (SQLException e) {
					e.printStackTrace(System.out);
				}
				break;
			case 4:
				ProductoDao pd4 = new ProductoDao();
				try {
					System.out.println(pd4.seleccionar());
				} catch (SQLException e) {
					e.printStackTrace(System.out);
				}
				break;
			case 5:
				System.out.println("Inserte el identificador del producto a buscar: ");
				ProductoDao pd5 = new ProductoDao();

				System.out.println("Identificador producto:");
				int idtb = in.nextInt();
				Producto productoB2 = pd5.buscar(idtb);

				System.out.println(productoB2);
			

				break;
			case 0:
				System.out.println("Hasta pronto");

				break;

			default:
				System.out.println("La opcion ingresada es inavalida");
				break;

			}
		}

		in.close();

	}

}
