package data.dao.impl.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import data.dao.exceptions.DAOException;
import data.dao.interfaces.AlumnoDAO;
import domain.entities.Alumno;

public class MySQLAlumnoDAO implements AlumnoDAO {
	
	private final String INSERT = "INSERT INTO alumnos(nombre, apellido, id_documento, nro_documento, fecha_nacimiento, fecha_ingreso) VALUES (?,?,?,?,?,?);";
	private final String UPDATE = "UPDATE alumnos SET nombre = ?, apellido = ?, id_documento = ?, nro_documento= ?, fecha_nacimiento= ?, fecha_ingreso= ? WHERE id_alumno = ?;";
	private final String DELETE = "DELETE FROM alumnos WHERE id_alumno = ?;"; 
	private final String GETONE = "SELECT * FROM alumnos WHERE id_alumno = ?";
	private final String GETALL = "SELECT * FROM alumnos";
	
	private static PreparedStatement psInsert = null;
	private static PreparedStatement psUpdate = null;
	private static PreparedStatement psDelete = null;
	private static PreparedStatement psGetOne = null;
	private static PreparedStatement psGetAll = null;
	
	private Connection conexion;
	
	public MySQLAlumnoDAO(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public boolean insertar(Alumno a) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Alumno a) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno obtener(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> obtenerTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
