package datos;

import domain.Producto;

import java.util.*;

import java.sql.*;

public class ProductoDao {

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_INSERT = "INSERT INTO productos (ID,Nombre,Precio,Precio_almayor,Imagen) VALUES(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos set Nombre = ? , Precio=? , Precio_almayor=?, Imagen =? WHERE ID =?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE ID=?";
	private static final String SQL_BUSCAR = "SELECT * FROM productos WHERE ID=?";

	public List<Producto> seleccionar() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Producto producto = null;
		List<Producto> productos = new ArrayList<>();
		try {
			conn = Conexion1.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();

			while (rs.next()) {

				producto = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				productos.add(producto);
			}

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion1.close(rs);
			Conexion1.close(stmt);
			Conexion1.close(conn);
		}

		return productos;

	}

	public Producto buscar(int identificador) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Producto productoE = null;
		try {
			conn = Conexion1.getConnection();
			stmt = conn.prepareStatement(SQL_BUSCAR);
			stmt.setInt(1, identificador);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
			 productoE = new Producto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		}
			catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Conexion1.close(rs);
			Conexion1.close(stmt);
			Conexion1.close(conn);

		}
		return productoE;

	}

	public int insertar(Producto producto) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		int filasAfectadas = 0;
		try {
			conn = Conexion1.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setInt(1, producto.getIdentificador());
			stmt.setString(2, producto.getNombre());
			stmt.setInt(3, producto.getPrecio());
			stmt.setInt(4, producto.getPrecioAlMayor());
			stmt.setString(5, producto.getImagen());
			filasAfectadas = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion1.close(stmt);
			Conexion1.close(conn);
		}
		return filasAfectadas;
	}

	public int actualizar(Producto producto) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int filasAfectadas = 0;
		try {
			conn = Conexion1.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setInt(5, producto.getIdentificador());
			stmt.setString(1, producto.getNombre());
			stmt.setInt(2, producto.getPrecio());
			stmt.setInt(3, producto.getPrecioAlMayor());
			stmt.setString(4, producto.getImagen());
			stmt.setInt(5, producto.getIdentificador());

			filasAfectadas = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion1.close(stmt);
			Conexion1.close(conn);
		}
		return filasAfectadas;
	}

	public int eliminar(Producto producto) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int filasAfectadas = 0;
		try {
			conn = Conexion1.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, producto.getIdentificador());
			filasAfectadas = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion1.close(stmt);
			Conexion1.close(conn);
		}
		return filasAfectadas;

	}

}
