package usuario.gui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import usuario.dao.ContatoDao;
import usuario.dao.EventoDao;
import usuario.negocio.SessaoUsuario;


public class CalendarioActivity extends AppCompatActivity {
    private CalendarView calendario;
    private EventoDao eventoDao;
    private SessaoUsuario sessaoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendario=(CalendarView)findViewById(R.id.calendario);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String data = i2 + "/" + i1 + "/" + i;

                Intent intentCalendario = new Intent(CalendarioActivity.this, PopCalendarioActivity.class);
                intentCalendario.putExtra("data",data);
                startActivity(intentCalendario);
                finish();
            }
        });
        sessaoUsuario = new SessaoUsuario(getApplicationContext());
        eventoDao = new EventoDao(getApplicationContext());
        sessaoUsuario.iniciarSessao();
    }
}
