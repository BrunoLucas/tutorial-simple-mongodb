package com.mballem.simplemongodb.dao;

import com.mongodb.DBObject;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 09/07/12
 * Time: 15:29
 * http://mballem.com/
 */
public interface IDao {
    void save(Map<String, Object> mapEntity);

    void save(Map<String, Object> mapEntity, String indexKey, boolean unique);

    void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity);

    void delete(Map<String, Object> mapEntity);

    DBObject findOne(Map<String, Object> mapEntity);

    List<DBObject> findAll();

    List<DBObject> findKeyValue(Map<String, Object> keyValue);
}
