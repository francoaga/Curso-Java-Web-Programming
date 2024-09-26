package data.dao.interfaces;

public interface DAOManager {
	public abstract AlumnoDAO getAlumnoDAO();
	
	public abstract ProfesorDAO getProfesorDAO();
	
	public abstract AdministrativoDAO getAdministrativoDAO();
	
	public abstract DirectorDAO getDirectorDAO();
	
	public abstract CursoDAO getCursoDAO();
}
