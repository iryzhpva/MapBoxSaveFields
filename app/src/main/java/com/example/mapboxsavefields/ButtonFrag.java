package com.example.mapboxsavefields;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.mapboxsavefields.adapter.CultureCallback;
import com.example.mapboxsavefields.alertDialog.AlertDialogSuccessfulSendField;
import com.example.mapboxsavefields.pojo.Crops;
import com.example.mapboxsavefields.pojo.CurrentCrop;
import com.example.mapboxsavefields.pojo.Field;
import com.example.mapboxsavefields.request.SendFieldComplete;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mapbox.geojson.Point;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.transition.FragmentTransitionSupport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.example.mapboxsavefields.MainActivity.getPointDraField;
import static com.example.mapboxsavefields.request.SendNewField.sendNewFields;


public class ButtonFrag extends Fragment implements SendFieldComplete {

    View view;
    //кнопка "Вручную"
    Button handsAddField;
    //кнопка "Кадастр"
    Button cadastralAddField;
    //кпопка Отменить
    Button buttonCancel;
    //кнопка Добавить
    Button buttonSaveField;

    //открыть список куьтур
    RelativeLayout showListCulture;
    //открыть календарь
    RelativeLayout showCalendar;
    //ввести поле
    EditText nameField;
    //TextView, в котором будет отображаться выбранная культура
    public static TextView cropField;
    //ввести сорт
    EditText sortField;
    //отобрадается дата
    TextView seedingDateFiels;
    //флаг, который показывает, какой способ добавления полей выбрал пользователь
    Boolean flagWhatAddField = true;

    Calendar myCalendar;
    long seeding_date;

    AlertDialogSuccessfulSendField alertDialogSuccessfulSendField;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet, container, false);
        handsAddField = view.findViewById(R.id.handsadd);
        cadastralAddField = view.findViewById(R.id.cadastraladd);
        nameField = view.findViewById(R.id.id_namefield);
        showCalendar = view.findViewById(R.id.showCalendar);
        sortField = view.findViewById(R.id.id_sort);
        showListCulture = view.findViewById(R.id.showListCulture);
        buttonCancel = view.findViewById(R.id.button_cancel);
        buttonSaveField = view.findViewById(R.id.button_save);

        DatePickerDialog.OnDateSetListener date = (datePicker, year, monthOfYear, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "dd/MM/yyyy";

            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            seedingDateFiels.setText(sdf.format(myCalendar.getTime()));
            seeding_date = myCalendar.getTimeInMillis();
        };
        myCalendar = Calendar.getInstance();
        seedingDateFiels = view.findViewById(R.id.id_dateSowing);
        showCalendar.setOnClickListener(v -> {
            new DatePickerDialog(getContext(), date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        handsAddField.setOnClickListener(v -> {
            flagWhatAddField = true;
        });
        cadastralAddField.setOnClickListener(v -> {
            flagWhatAddField = false;
        });

        buttonCancel.setOnClickListener(v -> {

        });

        buttonSaveField.setOnClickListener(v -> {
            if (flagWhatAddField) {
                try {
                    saveFieldHands();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else
                saveFieldCadastr();
        });
        cropField = view.findViewById(R.id.id_crop);
        showListCulture.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ChoiceOfCultureActivity.class);
            startActivity(intent);
        });

        alertDialogSuccessfulSendField = new AlertDialogSuccessfulSendField(getContext());


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    String fieldName="";
    String fieldCrop="";
    String fieldSort="";
    String fieldDateSeeding="";

    private void saveFieldHands() throws JSONException {

        List<List<Double>> lestDoubles = ParserPointToDouble(getPointDraField());
        if(lestDoubles.size()<3) {
            Toast.makeText(getContext(), "Пожалуйста, нарисуйте полигон", Toast.LENGTH_SHORT).show();
            return;
        }
        if(nameField.getText()!= null)
            fieldName = nameField.getText().toString();
        if(cropField.getText()!= null)
            fieldCrop = cropField.getText().toString();
        if(sortField.getText()!= null)
        fieldSort = sortField.getText().toString();
        if(seedingDateFiels.getText()!= null)
            fieldDateSeeding = seedingDateFiels.getText().toString();
        if (fieldName.length() < 2) {
            Toast.makeText(getContext(), "Пожалуйста, укажите название поля", Toast.LENGTH_SHORT).show();
            return;
        }
        if (fieldDateSeeding.length() < 2) {
            Toast.makeText(getContext(), "Пожалуйста, укажите дату посева", Toast.LENGTH_SHORT).show();
            return;
        }
        if (fieldCrop.length() < 2) {
            Toast.makeText(getContext(), "Пожалуйста, укажите культуру", Toast.LENGTH_SHORT).show();
            return;
        }
        if (fieldSort.length() < 2) {
            Toast.makeText(getContext(), "Пожалуйста, укажите сорт", Toast.LENGTH_SHORT).show();
            return;
        }


        CurrentCrop currentCrop = new CurrentCrop();
        currentCrop.setCropName(fieldCrop);
        currentCrop.setCropSort(fieldSort);
        currentCrop.setSeedingDate(seeding_date);

        Field field = new Field(getCenterPolygon(getPointDraField()), lestDoubles, fieldName, 0, currentCrop);
        List<Field> fields = new ArrayList<>();
        fields.add(field);
        sendNewFields(fields, this);

    }

    public Point getCenterPolygon(List<Point> points) {

        double lat = 0.0;
        double lon = 0.0;

        if (points.size() > 0) {
            for (Point point : points) {
                lat += point.latitude();
            }
            lat /= points.size();

            for (Point point : points) {
                lon += point.longitude();
            }
            lon /= points.size();
        }
        Point pointCenter = Point.fromLngLat(lon, lat);
        return pointCenter;
    }


    private void saveFieldCadastr() {
        //Toast.makeText(getContext(), "Опция находится в разработке", Toast.LENGTH_SHORT).show();
    }

    private List<List<Double>> ParserPointToDouble(List<Point> listPoints) {
        List<List<Double>> listsPointsDouble = new ArrayList<>();
        for (Point point : listPoints) {
            listsPointsDouble.add(point.coordinates());
        }
        return listsPointsDouble;
    }

    private List<Point> ParserDoubleToPoint(List<List<Double>> listsPointsDouble) {
        List<Point> listPoints = new ArrayList<>();
        for (List<Double> listCoordinatesDouble : listsPointsDouble) {
            Point pointNew = Point.fromLngLat(listCoordinatesDouble.get(1),
                    listCoordinatesDouble.get(0));
            listPoints.add(pointNew);
        }
        return listPoints;
    }

    @Override
    public void successfulSendFields(boolean isSuccessul, String answerSever, List<Field> fields) {
        if (isSuccessul) {
            alertDialogSuccessfulSendField.showAlertDialog("", fieldDateSeeding, fieldCrop, fieldSort, "nameHousehold");
            ((Activity) getContext()).runOnUiThread(() -> {
                fieldName = "";
                nameField.getText().clear();
                fieldCrop = "";
                cropField.setText("");
                fieldSort = "";
                sortField.getText().clear();
                fieldDateSeeding = "";
                seedingDateFiels.setText("");
            });
        }
    }
}
