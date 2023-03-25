package ads.vilhena.ifro.edu.br.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ads.vilhena.ifro.edu.br.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {

    public abstract TarefaDAO tarefaDAO();

    private static final String DB_NAME = "db_tarefas";
    private static AppDatabase appDatabase;

    public static AppDatabase getAppDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        } return appDatabase;
    }
}
