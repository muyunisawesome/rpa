package dao;

public interface IServerDao {

    boolean register(String ip);

    String findServer();
}
