package com.sosorry.mongodao;



/**
 * @author Pallav
 *
 *
 *This Interface is a generic interface for Mongodb Dao. and it will be implemented by other document's dao.
 */
public interface GenMongoDao {
	
	public void create(Object obj);
	public Object getById(String id);
	public void update(Object data);
	public void deleteById(String id);
}
