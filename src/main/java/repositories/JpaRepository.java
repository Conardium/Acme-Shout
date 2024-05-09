
package repositories;

import java.util.List;

public interface JpaRepository<T, ID> {

	//--------_Buscar

	T findOne(ID id);
	List<T> findAll();
	Iterable<T> findAll(Iterable<ID> ids);

	//---------Guardar

	T save(T entity);
	List<T> save(Iterable<T> entities);

	//---------Borrar

	void deleteID(ID id);
	void delete(T entity);
	void delete(Iterable<T> entities);
	void deleteInBatch(Iterable<T> entities);
	void deleteAll();
	void deleteAllInBatch();

	//----------Otros

	boolean exists(ID id);
	long count();
	void flush();

}
