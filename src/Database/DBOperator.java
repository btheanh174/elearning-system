package Database;

import java.util.List;


public interface DBOperator <TYPE> {
	public List<TYPE> getList() ;
	public boolean add(TYPE t);
	public boolean update(TYPE t );
	public boolean delete(int id);
	public TYPE getbyID(int id);
	
}
