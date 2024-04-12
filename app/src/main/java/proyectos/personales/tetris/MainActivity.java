package proyectos.personales.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aquí se obtiene la referencia al botón dentro del método onCreate()
        Button myButton = findViewById(R.id.tetris);

        // Aquí se configura el OnClickListener para el botón
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Manejar el evento onClick aquí
                Intent intent = new Intent(MainActivity.this, Game.class);
                startActivity(intent);
            }
        });
    }
}
