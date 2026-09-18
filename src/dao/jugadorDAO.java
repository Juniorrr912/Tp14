package dao;

import java.sql.SQLException;
import java.util.List;

public interface jugadorDAO {
    void insertar(jugador jugador) throws SQLException;
    jugador buscarPorId(int id) throws SQLException;
    List<jugador> listarTodos() throws SQLException;
}