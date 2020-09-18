package dao;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class IServerDaoImpl implements IServerDao {

    String sql = null;
    @Override
    public boolean register(String ip) {
        sql = "delete from gobang_server";
        BaseDao.doUpdate(sql, null);

        sql = "insert into gobang_server values(?)";
        BaseDao.doInsert(sql, new String[]{ip});
        return true;
    }

    @Override
    public String findServer() {
       sql = "select * from gobang_server";
        ResultSet r = BaseDao.doQuery(sql);
       String server = null;
        try {
            while (r.next()) {
                server = r.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return server;
    }
}
