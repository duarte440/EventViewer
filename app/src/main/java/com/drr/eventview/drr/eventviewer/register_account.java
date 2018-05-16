package com.drr.eventview.drr.eventviewer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by duart on 06/05/2018.
 */

public class register_account extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_account);

        TextView textView = (TextView) findViewById(R.id.textView4);
        Button register = (Button) this.findViewById(R.id.Register_button);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("A sua conta foi registada com sucesso")
                .setTitle("AVISO");
        builder.setCancelable(false);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                gotoindex();
            }
        });

        AlertDialog.Builder warning = new AlertDialog.Builder(this);
        builder.setMessage("Tem de aceitar os termos de uso para continuar")
                .setTitle("AVISO");
        builder.setCancelable(false);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        final AlertDialog registerWarning = warning.create();
        final AlertDialog dialog = builder.create();

        textView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                gotoindex();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    dialog.show();
                }
                else
                {
                    registerWarning.show();
                }
            }
        });

    }

    public void gotoindex(){
        Intent myIntent = new Intent(register_account.this, Index.class);
        startActivity(myIntent);
    }
}
