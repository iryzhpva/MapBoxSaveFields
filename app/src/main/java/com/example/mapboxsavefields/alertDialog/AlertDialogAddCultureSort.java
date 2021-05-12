package com.example.mapboxsavefields.alertDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapboxsavefields.R;
import com.example.mapboxsavefields.pojo.Crops;
import com.mapbox.geojson.Point;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


/*public class AlertDialogAddCultureSort implements AdapterView.OnItemSelectedListener {
    Context context;
    String sort;

    Calendar myCalendar;
    TextView id_editdate;
    private long seeding_date = 0;
    Spinner spinner_culture;
    EditText esort;
    EditText namefield;

    public Button button_saveindialogalert, button_cancelindialogalert;
    CloseDialogAlert closeDialogAlert;
    AlertDialogSuccessfulSendField alertDialogSuccessfulSendField;
    int numfield;



    public AlertDialogAddCultureSort(Context context, int id, List<Point>, CloseDialogAlert closeDialogAlert, int numberfield) {

        //TODO THERE IS GET CROPS /api/farmers/api/sorts: REQUEST OR DATABASE

        numfield = numberfield;
        this.context = context;
        this.closeDialogAlert = closeDialogAlert;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_add_culture_sort, null);
        builder.setView(dialogView);
        dialog = builder.create();

        spinner_culture = dialogView.findViewById(R.id.spinner_culture);

        esort = dialogView.findViewById(R.id.id_editsort);
        namefield=dialogView.findViewById(R.id.id_namefield);


        spinner_culture.setOnItemSelectedListener(this);

        button_saveindialogalert = dialogView.findViewById(R.id.button_saveindialogalert);
        button_cancelindialogalert = dialogView.findViewById(R.id.button_cancelindialogalert);
        button_saveindialogalert.setOnClickListener(v -> {
            sendfield(context, id, polygonDrawUtils);
        });
        button_cancelindialogalert.setOnClickListener(v -> {
            dialog.cancel();
        });

        myCalendar = Calendar.getInstance();

        id_editdate = dialogView.findViewById(R.id.id_editdate);
        id_editdate.setOnClickListener(view -> {
            new DatePickerDialog(context, date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        alertDialogSuccessfulSendField = new AlertDialogSuccessfulSendField(context);
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd/MM/yyyy";

            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            id_editdate.setText(sdf.format(myCalendar.getTime()));
            seeding_date = myCalendar.getTimeInMillis();
        }

    };

    public AlertDialog dialog;

    public void showEditLabelFieldAlert() {
        dialog.show();

    }

    //mapBox point
    private List<Point> listpoint;

    public void sendfield(Context context, int id, PolygonDrawUtils polygonDrawUtils) {
        if (namefield.equals("")) {
            Toast.makeText(context, context.getString(R.string.pleaseWriteNameField), Toast.LENGTH_LONG).show();
            return;
        }
        if (thisChoiseCulture.equals("")) {
            Toast.makeText(context, context.getString(R.string.pleaseWriteCulture), Toast.LENGTH_LONG).show();
            return;
        }
        if (esort.getText().toString().equals("")) {
            Toast.makeText(context, context.getString(R.string.pleaseWriteSort), Toast.LENGTH_LONG).show();
            return;
        }
        if (seeding_date == 0) {
            Toast.makeText(context,  context.getString(R.string.pleaseWriteDateSowing), Toast.LENGTH_LONG).show();
            return;
        }
        sort = esort.getText().toString();
        if (thisChoiseCulture != null && seeding_date != 0 && namefield != null) {
            Field field = new Field(polygonDrawUtils.getPoints(), polygonDrawUtils.getCenterPolygon(), thisChoiseCulture, sort, seeding_date, namefield.getText().toString());
            Field.HouseholdInfo householdInfo=field.getHouseholdInfo();
            if(householdInfo!=null) {
                householdInfo.setId(houseHold.getIdServer());
            }
            else{
                householdInfo=new Field.HouseholdInfo();
                householdInfo.setId(houseHold.getIdServer());
            }
            field.setHouseholdInfo(householdInfo);
            listpoint = polygonDrawUtils.getPoints();
            List<Field> fieldDrawList = new ArrayList<>();
            fieldDrawList.add(field);
            if(isConnect) {
                //TODO THERE IS REQUETS /api/farmers/api/cadast-fields

            }
            else {
                field.setSynchronSerberDB(false);
                insertOneFieldDatabase(field,this);
            }
        }
    }

    List<String> nameculture;
    private String thisChoiseCulture="";

    @Override
    public void getCulturesComplete(boolean isSucceessful, List<Crops> crops, String listerror) {
        if (isSucceessful && crops != null){
            showCrops(crops);
            ((Activity) Objects.requireNonNull(context)).runOnUiThread(() -> {
                insertCropDatabase(crops,this);
                //Toast.makeText(context, "GET NEW CURRENT CROP SUCCESSFUL", Toast.LENGTH_LONG).show();
        });}
        else {
            ((Activity) context).runOnUiThread(() -> {Toast.makeText(context, context.getString(R.string.ErrorAddCultureDataa), Toast.LENGTH_LONG).show();});
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        thisChoiseCulture=nameculture.get(position);
        System.out.println("SPINNER ---> "+thisChoiseCulture);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void showCrops(List<Crops> crops){
        if(crops.size()> 0){
            nameculture = new ArrayList<>();
            for (Crops crop : crops) {
                nameculture.add(crop.getName());
            }
            ((Activity) context).runOnUiThread(() -> {
                ArrayAdapter adapterSpinnerCulture = new ArrayAdapter(context, android.R.layout.select_dialog_item, nameculture);
                adapterSpinnerCulture.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_culture.setAdapter(adapterSpinnerCulture);
            });
        }
    }
    @Override
    public void getCropsWithDatabaseComplete(List<Crops> cropsList) {
        showCrops(cropsList);
    }

    @Override
    public void addCropsInDatabaseComplete(List<Crops> cropsList) {
        ((Activity) context).runOnUiThread(() -> {
            //Toast.makeText(context, "SUCCESSFULL insert db", Toast.LENGTH_LONG).show();
            getDbCropThisHouseHoldIdDb(this);
        });
    }

    @Override
    public void deleteCropsFromDatabaseComplete() {
        System.out.println("SUCCESSFUL DELETE CURRENT CROPS");
    }

    @Override
    public void addOneFieldInDatabaseComplete(Field fieldList) {
       List<Field> fields=houseHold.getFields();
       fields.add(fieldList);
       houseHold.setFields(fields);
       houseHold.setSynchronServerDB(false);
       houseHold.setCountOfflineField(houseHold.getCountOfflineField()+1);
        ((Activity) context).runOnUiThread(() -> updateHouseHoldDatabase(houseHold, this));
    }

    @Override
    public void updateHouseHoldFromDatabaseComplete() {
        ((Activity) context).runOnUiThread(() -> {
            dialog.cancel();
            alertDialogSuccessfulSendField.showAlertDialog("", String.valueOf(myCalendar.getTimeInMillis()), thisChoiseCulture, esort.getText().toString(), houseHold.getName());
            ((Activity) context).runOnUiThread(() -> {
                esort.getText().clear();
                myCalendar.clear();});
            updateInformationAboutFields.updateInfFields(true);
        });
    }

    @Override
    public void successfulSendFields(boolean ans, String answ, List<Field> fields) {
        if (ans) {
            dialog.cancel();
            alertDialogSuccessfulSendField.showAlertDialog("", String.valueOf(myCalendar.getTimeInMillis()), thisChoiseCulture, esort.getText().toString(), houseHold.getName());
            ((Activity) context).runOnUiThread(() -> {
                esort.getText().clear();
                myCalendar.clear();
            });
            updateInformationAboutFields.updateInfFields(true);
        }
        closeDialogAlert.closeDialogAlertAddCulture(ans, answ, listpoint);
    }
}*/




