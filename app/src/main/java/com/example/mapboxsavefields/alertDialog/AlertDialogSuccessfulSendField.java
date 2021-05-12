package com.example.mapboxsavefields.alertDialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mapboxsavefields.R;

import java.util.Date;

public class AlertDialogSuccessfulSendField {
    Context context;
    TextView id_alert_square;
    TextView id_alert_date;
    TextView id_alert_cult;
    TextView id_alert_sort;
    TextView alert_add_namefield;
    TextView id_alert_namehousehold;


    Button button_alert_ok;
    AlertDialog dialog;

    public AlertDialogSuccessfulSendField(Context context){
        this.context=context;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_successful_sendfield, null);

        builder.setView(dialogView);
        dialog = builder.create();
        id_alert_square=dialogView.findViewById(R.id.id_alert_square);
        id_alert_date=dialogView.findViewById(R.id.id_alert_date);
        id_alert_cult=dialogView.findViewById(R.id.id_alert_cult);
        id_alert_sort=dialogView.findViewById(R.id.id_alert_sort);
        alert_add_namefield=dialogView.findViewById(R.id. alert_add_namefield);
        id_alert_namehousehold=dialogView.findViewById(R.id.id_alert_namehousehold);
        button_alert_ok=dialogView.findViewById(R.id.button_alert_ok);
        button_alert_ok.setOnClickListener(view -> {
            dialog.cancel();
        });
    }

    @SuppressLint("SetTextI18n")
    public void showAlertDialog(String square, String date, String cult , String sort,  String namehousehold){
        id_alert_square.setText(square);
        long millisecond = Long.parseLong(date);
        String dateString = DateFormat.format("dd/MM/yyyy", new Date(millisecond)).toString();
        id_alert_date.setText(dateString);
        id_alert_cult.setText(cult);
        id_alert_sort.setText(sort);
        //id_alert_namehousehold.setText( context.getString(R.string.inHouseHold)+namehousehold);
        //alert_add_namefield.setText(context.getString(R.string.weAddField));
        ((Activity)context).runOnUiThread(() -> {
            dialog.show();
        });


    }

}
