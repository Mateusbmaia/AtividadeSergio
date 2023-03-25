package ads.vilhena.ifro.edu.br.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ads.vilhena.ifro.edu.br.model.Tarefa;

@Dao
public interface TarefaDAO {
    @Query("select * from tarefas")
    List<Tarefa> listarTodos();

    @Query("select * from tarefas where id = :id")
    Tarefa listarUm(int id);

    @Insert
    void inserir(Tarefa tarefa);

    @Update
    void alterar(Tarefa tarefa);

    @Delete
    void deletar(Tarefa tarefa);
}
