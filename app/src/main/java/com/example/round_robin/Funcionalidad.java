package com.example.round_robin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Funcionalidad extends AppCompatActivity {
    private  int[] rem_bt = new int[10];
    private int qt;
    private String resultado = "";
    private EditText edt_p1;
    private EditText edt_p2;
    private EditText edt_p3;
    private EditText edt_p4;
    private EditText edt_Quantum;
    private TextView tv_resultado;
    private TextView tv_procesos;
    private TextView tv_awt;
    private TextView tv_tr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionalidad);
        tv_tr = (TextView) findViewById(R.id.txt_tr);
        tv_awt = (TextView) findViewById(R.id.txt_awt);
        tv_procesos = (TextView) findViewById(R.id.txt_procesos);
        edt_Quantum = (EditText) findViewById(R.id.txt_quantum);
        tv_resultado = (TextView) findViewById(R.id.txt_resultado);
        edt_p1 =(EditText) findViewById(R.id.txt_p1);
        edt_p2 =(EditText) findViewById(R.id.txt_p2);
        edt_p3 =(EditText) findViewById(R.id.txt_p3);
        edt_p4 =(EditText) findViewById(R.id.txt_p4);
    }

    public void guardar(View view){


    }

    public void Round_robin (View view){

        int i,y=0,temp,sq=0;

        float promedio_espera=0,promedio_respuesta=0;

        int[] Tiempo_rafaga= new int[10];
        int[] wt = new int[10];
        int[] Tiempo_final = new int[10];

        String p1 = edt_p1.getText().toString();
        String p2 = edt_p2.getText().toString();
        String p3 = edt_p3.getText().toString();
        String p4 = edt_p4.getText().toString();
        String Quantum = edt_Quantum.getText().toString();

        qt = Integer.parseInt(Quantum);
        Tiempo_rafaga[0]= Integer.parseInt(p1);
        Tiempo_rafaga[1]= Integer.parseInt(p2);
        Tiempo_rafaga[2]= Integer.parseInt(p3);
        Tiempo_rafaga[3]= Integer.parseInt(p4);


        int g;
        for ( g=0; g<4; g++){
            rem_bt[g] = Tiempo_rafaga[g];
        }


        while (true)
        {
            for ( i = 0, y=0; i<4; i++ )
            {
                temp = qt;
                if(rem_bt[i] == 0)
                {
                    y++;
                    continue;
                }
                if(rem_bt[i]>qt)
                {
                    rem_bt[i]=rem_bt[i]-qt;
                }else if (rem_bt[i]>=0)
                        {
                            temp = rem_bt[i];
                            rem_bt[i]=0;
                        }
                sq =sq +temp;
                Tiempo_final[i] = sq;
            }
            if (4 == y){
                break;
            }
        }

        tv_resultado.setText("\nPro \tTiempo_rafaga\t  Tiempo_final\t   Tiempo_espera\n");
        int x;
        for( x=0; x <4; x ++)
        {
            wt[x]=Tiempo_final[x]-Tiempo_rafaga[x];
            promedio_espera=promedio_espera+wt[x];
            promedio_respuesta = promedio_respuesta+Tiempo_final[x];
            resultado+="\n "+String.valueOf(x+1)+"\t              "+String.valueOf(Tiempo_rafaga[x])+"\t\t                       "+String.valueOf(Tiempo_final[x])+"\t\t                           "+String.valueOf(wt[x])+"\n";

        }

        tv_procesos.setText(resultado);
        promedio_espera=promedio_espera/4;
        promedio_respuesta=promedio_respuesta/4;
        tv_awt.setText("Promedio tiempo de espera "+promedio_espera+"\n");
        tv_tr.setText("Promedio tiempo de respuesta "+promedio_respuesta+"\n");
    }

}