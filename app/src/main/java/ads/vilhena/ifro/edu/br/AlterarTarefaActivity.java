package ads.vilhena.ifro.edu.br;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ads.vilhena.ifro.edu.br.DAO.AppDatabase;
import ads.vilhena.ifro.edu.br.model.Tarefa;

public class AlterarTarefaActivity extends AppCompatActivity {

    private TextInputLayout tilAlterarDescricao;
    private TextView txtAlterarData;
    private TextView txtAlterarHora;
    private Switch swtRealizado;
    private Button btnAlterar;
    private Tarefa tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_tarefa);

        tilAlterarDescricao = (TextInputLayout) findViewById(R.id.til_alterar_descricao);
        swtRealizado = (Switch) findViewById(R.id.swt_realizado);
        btnAlterar = (Button) findViewById(R.id.btn_alterar);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        int id = args.getInt("id_tarefa");
        tarefa = AppDatabase.getAppDatabase(this).tarefaDAO().listarUm(id);

        tilAlterarDescricao.getEditText().setText(tarefa.getDescricao());


        swtRealizado.setChecked(tarefa.isRealizado());


        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarefa.setDescricao(tilAlterarDescricao.getEditText().getText().toString().trim());
                tarefa.setRealizado(swtRealizado.isChecked());

                AppDatabase.getAppDatabase(AlterarTarefaActivity.this).tarefaDAO().alterar(tarefa);

                Intent intent = new Intent();
                intent.putExtra("resposta", "OK");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
