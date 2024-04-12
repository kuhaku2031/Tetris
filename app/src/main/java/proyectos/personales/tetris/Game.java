package proyectos.personales.tetris;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class Game extends AppCompatActivity {

    // Declara los botones como campos de clase
    private TextView m1;
    private TextView m2;
    private TextView m3;
    private TextView o1;
    private TextView o2;
    private TextView o3;
    private TextView p1;
    private TextView p2;
    private TextView p3;
    private TextView q1;
    private TextView q2;
    private TextView q3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        // Inicializa los botones
        m1 = findViewById(R.id.m1);
        m2 = findViewById(R.id.m2);
        m3 = findViewById(R.id.m3);
        o1 = findViewById(R.id.m1);
        o2 = findViewById(R.id.m2);
        o3 = findViewById(R.id.m3);
        p1 = findViewById(R.id.m1);
        p2 = findViewById(R.id.m2);
        p3 = findViewById(R.id.m3);
        q1 = findViewById(R.id.m1);
        q2 = findViewById(R.id.m2);
        q3 = findViewById(R.id.m3);


        next_shape();

    }

    int nextUp = 0;
    int starting = 0;
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    int num4 = 0;
    int shape_is = 0;
    int stop = 0;
    int lines = 0;
    int once = 0;
    int x = 0;


    private void loseAlinh() {
    }

    private void next_shape() {
        // Ahora puedes acceder a m1, m2 y m3 en este método
        m1.setBackgroundResource(R.drawable.gray);
        m2.setBackgroundResource(R.drawable.gray);
        m3.setBackgroundResource(R.drawable.gray);
        o1.setBackgroundResource(R.drawable.gray);
        o2.setBackgroundResource(R.drawable.gray);
        o3.setBackgroundResource(R.drawable.gray);
        p1.setBackgroundResource(R.drawable.gray);
        p2.setBackgroundResource(R.drawable.gray);
        p3.setBackgroundResource(R.drawable.gray);
        q1.setBackgroundResource(R.drawable.gray);
        q2.setBackgroundResource(R.drawable.gray);
        q3.setBackgroundResource(R.drawable.gray);

        Random random = new Random();

        // Generar un número aleatorio entre 1 (inclusive) y 8 (exclusivo)
        int randomNumber = random.nextInt(7) + 1;


        switch (randomNumber) {
            case 1:
                m2.setBackgroundResource(R.drawable.light_blue);
                o2.setBackgroundResource(R.drawable.light_blue);
                p2.setBackgroundResource(R.drawable.light_blue);
                q2.setBackgroundResource(R.drawable.light_blue);

                break;
            case 2:
                o1.setBackgroundResource(R.drawable.blue);
                o2.setBackgroundResource(R.drawable.blue);
                o3.setBackgroundResource(R.drawable.blue);
                p3.setBackgroundResource(R.drawable.blue);

                break;
            case 3:
                o1.setBackgroundResource(R.drawable.orange);
                o2.setBackgroundResource(R.drawable.orange);
                o3.setBackgroundResource(R.drawable.orange);
                p1.setBackgroundResource(R.drawable.orange);

                break;
            case 4:
                o1.setBackgroundResource(R.drawable.yellow);
                o2.setBackgroundResource(R.drawable.yellow);
                p1.setBackgroundResource(R.drawable.yellow);
                p2.setBackgroundResource(R.drawable.yellow);


                break;
            case 5:
                o2.setBackgroundResource(R.drawable.green);
                o3.setBackgroundResource(R.drawable.green);
                p1.setBackgroundResource(R.drawable.green);
                p2.setBackgroundResource(R.drawable.green);

                break;
            case 6:
                o1.setBackgroundResource(R.drawable.purple);
                o2.setBackgroundResource(R.drawable.purple);
                o3.setBackgroundResource(R.drawable.purple);
                p2.setBackgroundResource(R.drawable.purple);

                break;
            case 7:
                o1.setBackgroundResource(R.drawable.red);
                o2.setBackgroundResource(R.drawable.red);
                p2.setBackgroundResource(R.drawable.red);
                p3.setBackgroundResource(R.drawable.red);

                break;
        }

        nextUp = randomNumber;

        if (once == 0) {
            m1.setBackgroundResource(R.drawable.gray);
            m2.setBackgroundResource(R.drawable.gray);
            m3.setBackgroundResource(R.drawable.gray);
            o1.setBackgroundResource(R.drawable.gray);
            o2.setBackgroundResource(R.drawable.gray);
            o3.setBackgroundResource(R.drawable.gray);
            p1.setBackgroundResource(R.drawable.gray);
            p2.setBackgroundResource(R.drawable.gray);
            p3.setBackgroundResource(R.drawable.gray);
            q1.setBackgroundResource(R.drawable.gray);
            q2.setBackgroundResource(R.drawable.gray);
            q3.setBackgroundResource(R.drawable.gray);
            o1.setBackgroundResource(R.drawable.yellow);
            o2.setBackgroundResource(R.drawable.yellow);
            p1.setBackgroundResource(R.drawable.yellow);
            p2.setBackgroundResource(R.drawable.yellow);


        } else if (starting == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    shapes();
                }
            }, 1500);
            starting = 1;
        }
    }

    private void shapes() {

        GridLayout gridLayout = findViewById(R.id.gridLayout);

// Lista para almacenar los IDs de los TextView del primer GridLayout
        ArrayList<Integer> textViewIds = new ArrayList<>();

// Iterar sobre todas las vistas dentro del GridLayout
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            // Verificar si la vista actual es un TextView
            if (gridLayout.getChildAt(i) instanceof TextView) {
                int id = gridLayout.getChildAt(i).getId();
                textViewIds.add(id); // Agregar el ID del TextView a la lista
            }
        }

// Recorrer el ArrayList de IDs de TextViews y comparar el texto de cada TextView con "0"
        for (int id : textViewIds) {
            TextView textView = findViewById(id); // Obtener la referencia al TextView utilizando su ID
            String text = textView.getText().toString(); // Obtener el texto del TextView como String

            // Comparar el texto del TextView con "0" y realizar acciones si es igual
            if ("B11".equals(text) || "B12".equals(text) || "B13".equals(text) || "B14".equals(text) || "B15".equals(text) || "B16".equals(text) || "B17".equals(text) || "B18".equals(text) || "B19".equals(text) || "B20".equals(text)) {

                m1.setBackgroundResource(R.drawable.gray);
                m2.setBackgroundResource(R.drawable.gray);
                m3.setBackgroundResource(R.drawable.gray);
                o1.setBackgroundResource(R.drawable.gray);
                o2.setBackgroundResource(R.drawable.gray);
                o3.setBackgroundResource(R.drawable.gray);
                p1.setBackgroundResource(R.drawable.gray);
                p2.setBackgroundResource(R.drawable.gray);
                p3.setBackgroundResource(R.drawable.gray);
                q1.setBackgroundResource(R.drawable.gray);
                q2.setBackgroundResource(R.drawable.gray);
                q3.setBackgroundResource(R.drawable.gray);
            }
            loseAlinh();
            for (int id2: textViewIds){
                TextView textView2 = findViewById(id); // Obtener la referencia al TextView utilizando su ID
                String text2 = textView2.getText().toString(); // Obtener el texto del TextView como String

                if ("B24".equals(text2) || "B25".equals(text2) || "B26".equals(text2) || "B27".equals(text2)) {
                    nextUp=7;
                }array.removeAll(array);
                arrayCollectPreviousOne.removeAll(arrayCollectPreviousOne);
                shape_is = nextUp;
                next_shape();

            }
        }

    }

    ArrayList<TextView> arrayCollectPreviousOne = new ArrayList<>();
    ArrayList<TextView> array = new ArrayList<>();

    private ArrayList<TextView> downArray = new ArrayList<>();

    // Método para obtener el ArrayList
    public ArrayList<TextView> getDownArray() {
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        // Lista para almacenar los TextView del primer GridLayout
        ArrayList<TextView> downArray = new ArrayList<>();

        // Iterar sobre todas las vistas dentro del GridLayout
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            // Verificar si la vista actual es un TextView
            if (gridLayout.getChildAt(i) instanceof TextView) {
                TextView textView = (TextView) gridLayout.getChildAt(i);
                downArray.add(textView); // Agregar el TextView a la lista
            }
        }

        return downArray;
    }

    int a = 0;
    int b = 0;
    int z = 0;

    private void list() {
    }

    private void list2() {
    }

    private void R_L() {
    }

    private void Landing() {
    }

    private void colors() {
    }


}
